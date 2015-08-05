package com.rongrong.service;

import com.rongrong.dao.transactionmanager.MessageTbTransactionManager;
import com.rongrong.dao.transactionmanager.PictureTbTransactionManager;
import com.rongrong.dao.transactionmanager.ProjectTbTransactionManager;
import com.rongrong.dao.transactionmanager.UserTbTransactionManager;
import com.rongrong.model.MessageTb;
import com.rongrong.model.PictureTb;
import com.rongrong.model.ProjectTb;
import com.rongrong.model.UserTb;
import com.rongrong.model.constant.MESSAGE;
import com.rongrong.model.constant.PAGENUM;
import com.rongrong.model.constant.PICTURE;
import com.rongrong.model.constant.USERMANAGER;
import com.rongrong.model.requestview.AlertPasswordView;
import com.rongrong.model.requestview.CardView;
import com.rongrong.model.requestview.LoginReturnView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangfan on 2015/7/14.
 *
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
    public USERMANAGER userRegister(UserTb user) {
        try {
            userTbTransactionManager.saveUserTb(user);
            return USERMANAGER.REGISTERSUCCESS;
        } catch (Exception e) {
            return USERMANAGER.SERVICEERROR;
        }
    }

    /**
     * 用户修改完善信息
     *
     * @param user
     * @return
     */
    public USERMANAGER userAlertInfo(UserTb user) {
        try {
            userTbTransactionManager.updateUserTb(user);
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
            }else if (count > 1) {
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
