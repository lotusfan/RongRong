package com.rongrong.service;

import com.rongrong.dao.transactionmanager.*;
import com.rongrong.model.*;
import com.rongrong.model.constant.*;
import com.rongrong.model.requestview.ProjectListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangfan on 2015/7/17.
 * <p/>
 * 产品信息管理     添加 删除  赞  扩散  评论
 */

@Service
public class ProjectManagerService {

    @Autowired
    private ProjectTbTransactionManager projectTbTransactionManager;
    @Autowired
    private PrPraiseTbTransactionManager prPraiseTbTransactionManager;
    @Autowired
    private MessageTbTransactionManager messageTbTransactionManager;
    @Autowired
    private PrShareTbTransactionManager prShareTbTransactionManager;
    @Autowired
    private PrCommentTbTransactionManager prCommentTbTransactionManager;
    @Autowired
    private PictureTbTransactionManager pictureTbTransactionManager;


    /**
     * 用户添加项目
     *
     * @param project
     * @return
     */
    public PROJECTMANAGER addProject(ProjectTb project) {
        try {
            project.setStatus(PROJECT.PUBLIST.getCode());
            projectTbTransactionManager.saveProjectTb(project);
            return PROJECTMANAGER.PROJECTADDSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return PROJECTMANAGER.SERVICEERROR;
        }
    }

    /**
     * 用户修改项目
     *
     * @param project
     * @return
     */
    public PROJECTMANAGER alertProject(ProjectTb project) {

        try {
            projectTbTransactionManager.updateProjectTb(project);
            return PROJECTMANAGER.PROJECTADDSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return PROJECTMANAGER.SERVICEERROR;
        }
    }

    /**
     * 用户点赞
     *
     * @param prPraise
     * @return
     */
    public PROJECTMANAGER addPraise(PrPraiseTb prPraise) {
        try {
            //项目点赞记录
            prPraiseTbTransactionManager.savePrPraiseTb(prPraise);

            //消息通知
            MessageTb messageTb = new MessageTb();
            messageTb.setFromUserId(prPraise.getPraiseUserId());
            messageTb.setRelationId(prPraise.getProjectId());
            messageTb.setType(MESSAGE.PRAISE.getCode());
            messageTb.setStatus(MESSAGE.INITIAL.getCode());

            //获取项目发布人
            ProjectTb project = new ProjectTb();
            project.setId(prPraise.getProjectId());
            project = projectTbTransactionManager.getUserIdUniqueBy(project);

            messageTb.setToUserId(project.getUserId());
            messageTbTransactionManager.saveMessageTb(messageTb);

            return PROJECTMANAGER.PROJECTADDSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return PROJECTMANAGER.SERVICEERROR;
        }
    }


    /**
     * 用户扩散
     *
     * @param prShare
     * @return
     */
    public PROJECTMANAGER addShare(PrShareTb prShare) {

        try {
            //项目扩散记录
            prShareTbTransactionManager.savePrShareTb(prShare);

            return PROJECTMANAGER.PROJECTADDSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return PROJECTMANAGER.SERVICEERROR;
        }
    }

    /**
     * 项目评论添加
     *
     * @param prComment
     * @return
     */
    public PROJECTMANAGER addComment(PrCommentTb prComment) {
        try {
            //项目评论添加
            prCommentTbTransactionManager.savePrCommentTb(prComment);

            //消息通知
            MessageTb message = new MessageTb();
            message.setFromUserId(prComment.getUserId());
            message.setRelationId(prComment.getProjectId());
            message.setType(MESSAGE.COMMENT.getCode());
            message.setStatus(MESSAGE.INITIAL.getCode());

            //获取项目发布人
            ProjectTb project = new ProjectTb();
            project.setId(prComment.getProjectId());
            project = projectTbTransactionManager.getUserIdUniqueBy(project);

            message.setToUserId(project.getUserId());
            messageTbTransactionManager.saveMessageTb(message);

            //如果评论有@则通知
            Integer relationUserId = prComment.getRelationUserId();
            if (relationUserId != null && relationUserId > 0) {
                message.setToUserId(relationUserId);
                messageTbTransactionManager.saveMessageTb(message);
            }

            return PROJECTMANAGER.PROJECTADDSUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return PROJECTMANAGER.SERVICEERROR;
        }
    }

    /**
     * 个人动态列表 分页
     *
     * @param project
     * @return
     */
    public List<ProjectListView> personalProjectList(ProjectTb project) {

        List<ProjectListView> projectListViews = null;
        try {
            project.setSkipNum((project.getCurrentPage() - 1) * PAGENUM.num);
            project.setPageNum(PAGENUM.num);
            project.setSequence1("id");
            project.setSequence1Type("desc");
            List<ProjectTb> projectTbs = projectTbTransactionManager.getConditionBy(project);

            projectListViews = projectRelationInfo(projectTbs);

            return projectListViews;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 我参与的项目
     *
     * @param user
     * @return
     */
    public List<ProjectListView> personalRelateProjectList(UserTb user) {

        List<ProjectListView> projectListViews = null;
        try {
            List<ProjectTb> projectTbs = projectTbTransactionManager.personalRelateProjectList(user);

            projectListViews = projectRelationInfo(projectTbs);

            return projectListViews;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 项目列表
     *
     * @param project
     * @return
     */
    public List<ProjectListView> projectList(ProjectTb project) {

        List<ProjectListView> projectListViews = null;
        try {
            //获取项目
            project.setSkipNum((project.getCurrentPage() - 1) * PAGENUM.num);
            project.setPageNum(PAGENUM.num);
            project.setSequence1("id");
            project.setSequence1Type("desc");
            List<ProjectTb> projectTbs = projectTbTransactionManager.getConditionBy(project);
            if (projectTbs == null || projectTbs.size() < 1) {
                return null;
            }

            projectListViews = projectRelationInfo(projectTbs);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return projectListViews;
    }


    /**
     * 获取项目关联 评论 点赞 扩散 图片
     *
     * @param projectTbs
     * @return
     */
    public List<ProjectListView> projectRelationInfo(List<ProjectTb> projectTbs) {

        if (projectTbs == null) {
            return null;
        }

        List<ProjectListView> projectListViews = new ArrayList<>();

        try {
            //获取评论  组织条件
            PrCommentTb prComment = new PrCommentTb();
            prComment.setSequence1("p.id");
            prComment.setSequence1Type("desc");

            //获取点赞  组织条件
            PrPraiseTb prPraise = new PrPraiseTb();
            prPraise.setSequence1("p.id");
            prPraise.setSequence1Type("desc");

            //获取扩散 组织条件
            PrShareTb prShare = new PrShareTb();
            prShare.setSequence1("p.id");
            prShare.setSequence1Type("desc");

            //获取图片  组织条件
            PictureTb picture = new PictureTb();
            picture.setType(PICTURE.PROJECT.getCode()); //类型为项目
            picture.setStatus(PICTURE.INITIALIZTIONSTATUS.getCode()); //图片状态为初始

            for (ProjectTb tb : projectTbs) {

                ProjectListView projectListView = new ProjectListView();
                projectListView.setProjectTb(tb);

                //获取评论
                prComment.setProjectId(tb.getId());
                List<PrCommentTb> prCommentTbs = prCommentTbTransactionManager.getConditionBy(prComment);
                projectListView.setPrCommentTbs(prCommentTbs);

                //获取点赞
                prPraise.setProjectId(tb.getId());
                List<PrPraiseTb> prPraiseTbs = prPraiseTbTransactionManager.getConditionBy(prPraise);
                projectListView.setPrPraiseTbs(prPraiseTbs);

                //获取扩散
                prShare.setProjectId(tb.getId());
                List<PrShareTb> prShareTbs = prShareTbTransactionManager.getConditionBy(prShare);
                projectListView.setPrShareTbs(prShareTbs);

                //获取图片
                picture.setRelationId(tb.getId());
                List<PictureTb> pictureTbs = pictureTbTransactionManager.getBy(picture);
                projectListView.setPictureTbs(pictureTbs);


                projectListViews.add(projectListView);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return projectListViews;
    }


    /**
     * 删除图片（置图版状态为失效）
     *
     * @param picture
     * @return
     */
    public PROJECTMANAGER deletePicture(PictureTb picture) {

        try {

            picture.setStatus(PICTURE.LOSEEFFECTIVENESSSTATUS.getCode());  //图片置为失效状态
            pictureTbTransactionManager.updatePictureTb(picture);

            return PROJECTMANAGER.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return PROJECTMANAGER.SERVICEERROR;
        }

    }


    /**
     * 删除项目（置项目失效，赞、评论消息失效）
     *
     * @param project
     * @return
     */
    public PROJECTMANAGER deleteProject(ProjectTb project) {

        try {
            project.setStatus(PROJECT.CANCEL.getCode()); //项目置取消状态
            projectTbTransactionManager.updateProjectTb(project);

            //置消息为失效
            MessageTb message = new MessageTb();
            message.setStatus(MESSAGE.LOSEEFFECTIVENESSSTATUS.getCode());
                //赞失效
            message.setType(MESSAGE.PRAISE.getCode());
            messageTbTransactionManager.updateMessageTb(message);
                //评论失效
            message.setType(MESSAGE.COMMENT.getCode());
            messageTbTransactionManager.updateMessageTb(message);

            return PROJECTMANAGER.SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            return PROJECTMANAGER.SERVICEERROR;
        }
    }




























    /*public List<PrCommentTb> getPrCommentTbs(ProjectTb project) {
        try {

        } catch (Exception e) {
        }

    }

    public List<PrPraiseTb> getPrPraiseTbs(PrPraiseTb prPraise) {

        try {

        } catch (Exception e) {
        }
    }

    public List<PrShareTb> getPrShareTbs(PrShareTb prShare) {
        try {

        } catch (Exception e) {
        }
    }

    public List<PictureTb> getPictureTbs(PictureTb picture) {
        try {

        } catch (Exception e) {
        }
    }*/
}
