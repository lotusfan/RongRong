package com.rongrong.service;

import com.rongrong.dao.transactionmanager.*;
import com.rongrong.model.*;
import com.rongrong.model.constant.MESSAGE;
import com.rongrong.model.constant.PAGENUM;
import com.rongrong.model.constant.PICTURE;
import com.rongrong.model.constant.USERMANAGER;
import com.rongrong.model.requestview.AlertPasswordView;
import com.rongrong.model.requestview.CardView;
import com.rongrong.model.requestview.LoginReturnView;
import com.rongrong.model.requestview.MessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan on 2015/7/14.
 * <p/>
 * 用户信息管理  登录，注册，用户信息修改， 密码修改
 */
@Service
public class UserManagerService {

    @Autowired
    private UserTbTransactionManager userTbTransactionManager;
    @Autowired
    private MessageTbTransactionManager messageTbTransactionManager;
    @Autowired
    private ProjectTbTransactionManager projectTbTransactionManager;
    @Autowired
    private PictureTbTransactionManager pictureTbTransactionManager;
    @Autowired
    private PrCommentTbTransactionManager prCommentTbTransactionManager;
    @Autowired
    private PrPraiseTbTransactionManager prPraiseTbTransactionManager;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    public LoginReturnView userLogin(UserTb user) {

        try {

            user = userTbTransactionManager.getUniqueBy(user);

            if (user == null) return null; //登录失败

            LoginReturnView loginReturnView = new LoginReturnView();

            user.setLoginPs(""); //清空登录密码
            //获取新动态
            MessageTb message = new MessageTb();
            message.setToUserId(user.getId());
            message.setStatus(MESSAGE.INITIALIZTIONSTATUS.getCode());
            loginReturnView.setMyselfProjectNum(messageTbTransactionManager.count(message));

            //获取收到的名片数
            message.setType(MESSAGE.CARD.getCode());
            loginReturnView.setMyselfReceiveCard(messageTbTransactionManager.count(message));

            //获取发送的名片数
            message.setToUserId(null);
            message.setFromUserId(user.getId());
            loginReturnView.setMyselfSendCard(messageTbTransactionManager.count(message));

            loginReturnView.setUserTb(user);

            return loginReturnView;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    public UserTb userRegister(UserTb user) {
        try {
            UserTb userTb = new UserTb();
            userTb.setLoginName(user.getLoginName());

            int count = userTbTransactionManager.count(userTb);

            if (count > 0) {
                return null;
            }

            user.setLoginPs("");
            userTbTransactionManager.saveUserTb(user);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 用户修改完善信息
     *
     * @param user
     * @return
     */
    public UserTb userAlertInfo(UserTb user) {
        try {
            userTbTransactionManager.updateUserTb(user);
            UserTb userTb = new UserTb();
            userTb.setId(user.getId());
            userTb = userTbTransactionManager.getUniqueBy(userTb);
            return userTb;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 用户找回密码
     *
     * @param user
     * @return
     */
    public USERMANAGER retrievePassword(UserTb user) {
        try {
            userTbTransactionManager.retrievePassword(user);

            return USERMANAGER.ALERTSUCCESS;
        } catch (Exception e) {
            return USERMANAGER.SERVICEERROR;
        }
    }

    /**
     * 用户修改密码
     *
     * @param alertPasswordView
     * @return
     */
    public USERMANAGER alertPassword(AlertPasswordView alertPasswordView) {
        try {
            UserTb user = new UserTb();
            user.setId(alertPasswordView.getUserId());

            //旧密码认证
            user.setLoginPs(alertPasswordView.getOldPs());
            int count = userTbTransactionManager.count(user);
            if (count < 1) {
                return USERMANAGER.OLDPSMITAKE;
            } else if (count > 1) {
                return USERMANAGER.SERVICEERROR;
            }

            //新密码更新
            user.setLoginPs(alertPasswordView.getNewPs());
            userTbTransactionManager.updateUserTb(user);

            return USERMANAGER.ALERTSUCCESS;
        } catch (Exception e) {
            return USERMANAGER.SERVICEERROR;
        }
    }

    /**
     * 用户发送名片
     *
     * @param message
     * @return
     */
    public USERMANAGER sendCard(MessageTb message) {
        try {
            message.setType(MESSAGE.CARD.getCode());
            message.setStatus(MESSAGE.INITIALIZTIONSTATUS.getCode());
            messageTbTransactionManager.saveMessageTb(message);

            return USERMANAGER.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return USERMANAGER.SERVICEERROR;
        }
    }

    /**
     * 个人详情页接口
     *
     * @param user
     * @return
     */
    public UserTb personalInfo(UserTb user) {
        try {
            //查询用户基本信息
            user = userTbTransactionManager.getUniqueBy(user);
            if (user == null) return null;

            //查询他的发布项目总数
            ProjectTb project = new ProjectTb();
            project.setUserId(user.getId());
            int projectNum = projectTbTransactionManager.count(project);

            user.setProjectNum(projectNum);
            user.setLoginPs(""); //将密码置空

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取用户消息列表(已读/未读)
     *
     * @param user
     * @return
     */
    public List<MessageView> getMessageBoxListView(UserTb user, Integer status) {

        MessageTb message = new MessageTb();
        message.setToUserId(user.getId());
        message.setStatus(status); //已读, 未读状态
        message.setOrParameter1("type");
        message.setOrValue1(MESSAGE.COMMENT.getCode() + "");
        message.setOrParameter2("type");
        message.setOrValue2(MESSAGE.PRAISE.getCode() + "");
        message.setSequence1Type("desc");
        message.setSequence1("id");
        message.setPageNum(PAGENUM.messageNum);
        message.setSkipNum((user.getCurrentPage()-1)*PAGENUM.messageNum);
        //获取消息基础表信息
        List<MessageTb> messageTbs = messageTbTransactionManager.getConditionBy(message);


        //获取用户头像地址 条件创建
        PictureTb picture = new PictureTb();
        picture.setType(PICTURE.USERHEAD.getCode());
        picture.setStatus(PICTURE.INITIALIZTIONSTATUS.getCode()); //使用中的头像

        List<MessageView> messageViews = new ArrayList<>(); //创建返回消息列表

        //获取消息相关类型(评论,点赞)信息
        for (MessageTb messageTb : messageTbs) {
            MessageView messageView = new MessageView();

            //获取用户头像地址
            picture.setRelationId(messageTb.getFromUserId());
            PictureTb pictureHe = pictureTbTransactionManager.getUniqueBy(picture);
            if (picture != null) {
                messageView.setHeadUrl(pictureHe.getUrl()); //赋值用户头像路径
            }

            //评论信息要获取相关信息
            if (MESSAGE.COMMENT.getCode().equals(messageTb.getType())) {
                PrCommentTb prComment = new PrCommentTb();
                prComment.setId(messageTb.getRelationId());
                prComment = prCommentTbTransactionManager.getUniqueBy(prComment);
                messageView.setComment(prComment.getContent()); //赋值评论信息
                messageView.setNameReal(prComment.getNameReal()); //赋值真实姓名
                //评论相关项目信息
                ProjectTb project = new ProjectTb();
                project.setId(prComment.getProjectId());
                project = projectTbTransactionManager.getUniqueBy(project);
                messageView.setSummary(project.getSummary()); //赋值项目简介
                messageView.setProjectId(project.getId()); //赋值项目Id
            }

            //点赞相关信息
            if (MESSAGE.PRAISE.getCode().equals(messageTb.getToUserId())) {
                PrPraiseTb prPraise = new PrPraiseTb();
                prPraise.setId(messageTb.getRelationId());
                prPraise = prPraiseTbTransactionManager.getUniqueBy(prPraise);
                messageView.setNameReal(prPraise.getNameReal());

                //点赞相关项目信息
                ProjectTb projectTb = new ProjectTb();
                projectTb.setId(prPraise.getProjectId());
                projectTb = projectTbTransactionManager.getUniqueBy(projectTb);
                messageView.setSummary(projectTb.getSummary()); //赋值项目简介
                messageView.setProjectId(projectTb.getId()); //赋值项目Id
            }

            messageView.setCreateTime(messageTb.getCreateTime());
            messageView.setType(messageTb.getType());
            messageView.setStatus(messageTb.getStatus());
            messageView.setMessageId(messageTb.getId());

            messageViews.add(messageView);
        }

        return messageViews;
    }

    /**
     * 用户清空消息盒子(包括已读,未读)
     *
     * @param user
     * @return
     */
    public USERMANAGER clearMessageBox(UserTb user) {
        try {
            MessageTb message = new MessageTb();
            message.setToUserId(user.getId());
            message.setOrParameter1("type");
            message.setOrValue1(MESSAGE.COMMENT.getCode() + "");
            message.setOrParameter2("type");
            message.setOrValue2(MESSAGE.PRAISE.getCode() + "");
            message.setStatus(MESSAGE.LOSEEFFECTIVENESSSTATUS.getCode()); //设置已读,未读消息失效

            messageTbTransactionManager.clearMessageBox(message);

            return USERMANAGER.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return USERMANAGER.SERVICEERROR;
        }
    }


    /**
     * 删除消息
     *
     * @param message
     * @return
     */
    public USERMANAGER deleteMessage(MessageTb message) {

        try {
            message.setStatus(MESSAGE.LOSEEFFECTIVENESSSTATUS.getCode());
            messageTbTransactionManager.updateMessageTb(message);

            return USERMANAGER.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return USERMANAGER.SERVICEERROR;
        }
    }


    /**
     * 收到的名片
     *
     * @param user
     * @return
     */
    public List<CardView> getReceiveCardViews(UserTb user) {

        List<CardView> cardViews = null;
        try {
            MessageTb message = new MessageTb();
            message.setToUserId(user.getId());  //接收的Id
            message.setType(MESSAGE.CARD.getCode());
            message.setStatus(MESSAGE.INITIALIZTIONSTATUS.getCode());
            message.setSkipNum((user.getCurrentPage() - 1) * PAGENUM.messageNum);
            message.setPageNum(PAGENUM.messageNum);

            cardViews = messageTbTransactionManager.getReceiveCardConditionBy(message);


            //头像 组织条件
            PictureTb picture = new PictureTb();
            picture.setType(PICTURE.USERHEAD.getCode());
            picture.setStatus(PICTURE.INITIALIZTIONSTATUS.getCode());

            for (CardView cardView : cardViews) {
                cardView.setOtherUserId(cardView.getFromUserId()); //发送者的Id
                picture.setRelationId(cardView.getOtherUserId());

                PictureTb pictureTb = pictureTbTransactionManager.getUniqueBy(picture);
                if (pictureTb != null) {
                    cardView.setHeadUrl(pictureTb.getUrl());
                }
            }

            return cardViews;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 发送的名片
     *
     * @param user
     * @return
     */
    public List<CardView> getSendCardViews(UserTb user) {

        List<CardView> cardViews = null;
        try {
            MessageTb message = new MessageTb();
            message.setFromUserId(user.getId());  //发送者 Id
            message.setType(MESSAGE.CARD.getCode());
            message.setStatus(MESSAGE.INITIALIZTIONSTATUS.getCode());
            message.setSkipNum((user.getCurrentPage() - 1) * PAGENUM.messageNum);
            message.setPageNum(PAGENUM.messageNum);

            cardViews = messageTbTransactionManager.getSendCardConditionBy(message);


            //头像 组织条件
            PictureTb picture = new PictureTb();
            picture.setType(PICTURE.USERHEAD.getCode());
            picture.setStatus(PICTURE.INITIALIZTIONSTATUS.getCode());

            for (CardView cardView : cardViews) {
                cardView.setOtherUserId(cardView.getToUserId()); //接收者的Id
                picture.setRelationId(cardView.getOtherUserId());

                PictureTb pictureTb = pictureTbTransactionManager.getUniqueBy(picture);
                if (pictureTb != null) {
                    cardView.setHeadUrl(pictureTb.getUrl());
                }
            }

            return cardViews;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
