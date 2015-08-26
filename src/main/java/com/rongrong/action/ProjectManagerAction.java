package com.rongrong.action;

import com.rongrong.model.*;
import com.rongrong.model.constant.HTTPCODE;
import com.rongrong.model.constant.PROJECTMANAGER;
import com.rongrong.model.constant.USERMANAGER;
import com.rongrong.model.requestview.ProjectListView;
import com.rongrong.model.requestview.RequestModel;
import com.rongrong.model.requestview.ResponseModel;
import com.rongrong.service.ProjectManagerService;
import com.rongrong.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhangfan on 2015/7/17.
 * <p/>
 * 产品信息管理     添加 删除  赞  扩散  评论
 */

@Controller
@RequestMapping(value = "/product")
public class ProjectManagerAction extends ActionParent {

    @Autowired
    private ProjectManagerService projectManagerService;

    /**
     * 用户添加项目
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "addProject", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel addProject(@RequestBody RequestModel requestModel) {

        try {
            ProjectTb project = (ProjectTb) transformJSONObjectToModel(requestModel, ProjectTb.class);

            //验证信息格式


            //Service  Add
            PROJECTMANAGER e = projectManagerService.addProject(project);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);//返回结构化对象


        } catch (Exception e) {
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
        }

    }

    /**
     * 用户修改项目
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "alertProject", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel alertProject(@RequestBody RequestModel requestModel) {
        try {
            ProjectTb project = (ProjectTb) transformJSONObjectToModel(requestModel, ProjectTb.class);

            //验证信息格式


            //Service  alert
            PROJECTMANAGER e = projectManagerService.alertProject(project);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);//返回结构化对象


        } catch (Exception e) {
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
        }
    }

    /**
     * 用户点赞
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "addPraise", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel addPraise(@RequestBody RequestModel requestModel) {
        try {
            PrPraiseTb prPraise = (PrPraiseTb) transformJSONObjectToModel(requestModel, PrPraiseTb.class);

            //验证信息格式


            //Service Add
            PROJECTMANAGER e = projectManagerService.addPraise(prPraise);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);//返回结构化对象

        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
        }
    }

    /**
     * 用户扩散
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "addShare", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel addShare(@RequestBody RequestModel requestModel) {
        try {
            PrShareTb prShare = (PrShareTb) transformJSONObjectToModel(requestModel, PrShareTb.class);

            //验证信息格式


            //Service Add
            PROJECTMANAGER e = projectManagerService.addShare(prShare);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);//返回结构化对象

        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
        }
    }

    /**
     * 用户添加评论
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "addComment", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel addComment(@RequestBody RequestModel requestModel) {
        try {
            PrCommentTb prComment = (PrCommentTb) transformJSONObjectToModel(requestModel, PrCommentTb.class);

            //Service add
            PROJECTMANAGER e = projectManagerService.addComment(prComment);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);//返回结构化对象
        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
        }
    }

    /**
     * 个人动态列表
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "perProlist", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel personalProjectList(@RequestBody RequestModel requestModel) {
        try {
            ProjectTb project = (ProjectTb) transformJSONObjectToModel(requestModel, ProjectTb.class);

            //验证信息

            //Service select
            List<ProjectListView> list = projectManagerService.personalProjectList(project);

            if (list == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.PROJECTEMPTY.getCode(), null, null);//返回结构化对象
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SUCCESS.getCode(), null, list);//返回结构化对象
        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
        }
    }

    /**
     * 我参与的项目
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "prpl", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel personalRelateProjectList(@RequestBody RequestModel requestModel) {
        try {
            UserTb user= (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);

            //验证信息
            if (!ValidateUtil.userIdValidate(user.getId())) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.NOTEXISTUSER.getCode(), null, null);//返回结构化对象\
            }

            //Service select
            List<ProjectListView> list = projectManagerService.personalRelateProjectList(user);

            if (list == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.PROJECTEMPTY.getCode(), null, null);//返回结构化对象
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SUCCESS.getCode(), null, list);//返回结构化对象
        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
        }
    }

    /**
     * 项目列表
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "projectList", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel projectList(@RequestBody RequestModel requestModel) {
        try {
            ProjectTb project = (ProjectTb) transformJSONObjectToModel(requestModel, ProjectTb.class);

            //验证信息
            if (!ValidateUtil.figureValidate(project.getCurrentPage())) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.NOTEXISTCURRENTPAGE.getCode(), null, null);//返回结构化对象\
            }

            //Service select
            List<ProjectListView> projectListViews = projectManagerService.projectList(project);
            if (projectListViews == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SUCCESS.getCode(), null, projectListViews);//返回结构化对象\

        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
        }
    }

    /**
     * 删除图片
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "delPic", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel deletePicture(@RequestBody RequestModel requestModel) {

        try {
            PictureTb picture = (PictureTb) transformJSONObjectToModel(requestModel, PictureTb.class);

            //验证信息


            //Service delete
            PROJECTMANAGER e = projectManagerService.deletePicture(picture);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SUCCESS.getCode(), null, null);//返回结构化对象\
        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
        }
    }

    /**
     * 删除项目
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "delPro", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel deleteProject(@RequestBody RequestModel requestModel) {
        try {
            ProjectTb project = (ProjectTb) transformJSONObjectToModel(requestModel, ProjectTb.class);

            //验证信息
            if (!ValidateUtil.figureValidate(project.getId())) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.PROJECTEMPTY.getCode(), null, null);//返回结构化对象\
            }

            //Service delete
            PROJECTMANAGER e = projectManagerService.deleteProject(project);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SUCCESS.getCode(), null, null);//返回结构化对象\

        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), PROJECTMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象\
        }
    }




}
