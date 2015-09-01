package com.rongrong.action;

import com.jcabi.aspects.Loggable;
import com.rongrong.model.MessageTb;
import com.rongrong.model.UserTb;
import com.rongrong.model.constant.HTTPCODE;
import com.rongrong.model.constant.MESSAGE;
import com.rongrong.model.constant.USERMANAGER;
import com.rongrong.model.requestview.*;
import com.rongrong.service.UserManagerService;
import com.rongrong.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by zhangfan on 2015/7/14.
 * <p/>
 * 用户信息管理  登录，注册，用户信息修改，密码修改
 */
@Controller
@RequestMapping(value = "/user")
@Loggable(trim = false)
public class UserManagerAction extends ActionParent {

    @Autowired
    private UserManagerService userManagerService;

    /**
     * 用户登录
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel userLogin(@RequestBody RequestModel requestModel) {

        try {

            UserTb user = (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);//将requestModel里的o强转为user对象

            //验证信息格式
            if (!ValidateUtil.loginNameValidate(user.getLoginName())) { //用户名格式校验
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.USERNAMEILLEGAL.getCode(), null, null);//返回结构化对象
            }
            if (!ValidateUtil.loginPwValidate(user.getLoginPs())) { //用户密码格式校验
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);//返回结构化对象
            }

            //Service验证
            LoginReturnView loginReturnView = userManagerService.userLogin(user);

            if (loginReturnView == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.LOGINFAIL.getCode(), null, null);
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.LOGINSUCCESS.getCode(), null, loginReturnView);//返回结构化对象

        } catch (Exception e) {
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);//返回结构化对象
        }

    }

    /**
     * 用户注册
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel userRegister(@RequestBody RequestModel requestModel) {

        try {

            UserTb user = (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);//将requestModel里的o强转为user对象

            //手机验证码校验

            //验证信息格式
            if (!ValidateUtil.loginNameValidate(user.getLoginName())) { //用户名格式校验
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.USERNAMEILLEGAL.getCode(), null, null);//返回结构化对象
            }
            if (!ValidateUtil.loginPwValidate(user.getLoginPs())) { //用户密码格式校验
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);//返回结构化对象
            }
            //Service 插入
            user = userManagerService.userRegister(user);

            if (user == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.REGISTERSUCCESS.getCode(), null, user);//返回结构化对象

        } catch (Exception e) {
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }


    }

    /**
     * 用户修改完善信息
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "alert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel userAlertInfo(@RequestBody RequestModel requestModel) {

        try {

            UserTb user = (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);//将requestModel里的o强转为user对象

            //验证信息格式

            //Service 更新
            user = userManagerService.userAlertInfo(user);

            if (user == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.ALERTSUCCESS.getCode(), null, user);//返回结构化对象

        } catch (Exception e) {
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }

    }

    /**
     * 用户找回密码
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "retrievePs", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel retrievePassword(@RequestBody RequestModel requestModel) {

        try {

            //手机验证码校验

            UserTb user = (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);//将requestModel里的o强转为user对象

            //验证信息格式
            if (!ValidateUtil.loginNameValidate(user.getLoginName())) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.USERNAMEILLEGAL.getCode(), null, null);//返回结构化对象
            }
            if (!ValidateUtil.loginPwValidate(user.getLoginPs())) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);//返回结构化对象
            }

            //Service 更新
            USERMANAGER e = userManagerService.retrievePassword(user);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);//返回结构化对象

        } catch (Exception e) {
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }
    }

    /**
     * 用户修改密码
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "alertpPs", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel alertPassword(@RequestBody RequestModel requestModel) {

        try {

            AlertPasswordView alertPasswordView = (AlertPasswordView) transformJSONObjectToModel(requestModel, AlertPasswordView.class);

            //验证信息格式
            if (!ValidateUtil.userIdValidate(alertPasswordView.getUserId())) { //用户Id校验
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);
            }
            if (!(ValidateUtil.loginPwValidate(alertPasswordView.getOldPs()) || ValidateUtil.loginPwValidate(alertPasswordView.getNewPs()))) { //密码校验
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);
            }
            //Service 更新
            USERMANAGER e = userManagerService.alertPassword(alertPasswordView);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);

        } catch (Exception e) {
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }

    }

    /**
     * 用户发送名片
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "sendCard", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel sendCard(@RequestBody RequestModel requestModel) {
        try {
            MessageTb message = (MessageTb) transformJSONObjectToModel(requestModel, MessageTb.class);

            //验证信息


            //Service add
            USERMANAGER e = userManagerService.sendCard(message);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }
    }


    /**
     * 个人详情接口
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "perInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel personalInfo(@RequestBody RequestModel requestModel) {

        try {
            UserTb user = (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);

            //验证信息
            if (!ValidateUtil.userIdValidate(user.getId())) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);//返回结构化对象
            }
            //Service
            user = userManagerService.personalInfo(user);
            if (user == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.NOTEXISTUSER.getCode(), null, null);
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SUCCESS.getCode(), null, user);

        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }
    }

    /**
     * 用户获取已读消息列表(有分页)
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "gethr", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getHaveReadedMessageBoxListView(@RequestBody RequestModel requestModel) {
        try {
            UserTb user = (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);

            //验证信息


            //Service get
            List<MessageView> list = userManagerService.getMessageBoxListView(user, MESSAGE.HAVEREADEDSTATUS.getCode());

            if (list == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SUCCESS.getCode(), null, list);
        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }
    }

    /**
     * 用户获取未读消息列表(有分页)
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "getnr", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel getNotReadedMessageBoxListView(@RequestBody RequestModel requestModel) {
        try {
            UserTb user = (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);

            //验证信息


            //Service get
            List<MessageView> list = userManagerService.getMessageBoxListView(user, MESSAGE.INITIALIZTIONSTATUS.getCode());

            if (list == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SUCCESS.getCode(), null, list);
        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }
    }


    /**
     * 用户清空消息盒子,包括已读,未读消息
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "clearm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel clearMessageBox(@RequestBody RequestModel requestModel) {
        try {

            UserTb user = (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);

            //验证信息
            if (!ValidateUtil.userIdValidate(user.getId())) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);//返回结构化对象
            }
            //Service clear
            USERMANAGER e = userManagerService.clearMessageBox(user);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }
    }

    /**
     * 删除消息
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "delMes", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel deleteMessgae(@RequestBody RequestModel requestModel) {

        try {
            MessageTb message = (MessageTb) transformJSONObjectToModel(requestModel, MessageTb.class);

            //验证信息
            if (!ValidateUtil.figureValidate(message.getId())) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.NOTEXISTMESSAGEID.getCode(), null, null);
            }

            //Service delete
            USERMANAGER e = userManagerService.deleteMessage(message);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SUCCESS.getCode(), null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }
    }

    /**
     * 收到的名卡
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "receivedCard", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel receiveCard(@RequestBody RequestModel requestModel) {

        List<CardView> list = null;
        try {
            UserTb user = (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);

            //验证信息
            if (!ValidateUtil.userIdValidate(user.getId())) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);//返回结构化对象
            }


            //Service select
            list = userManagerService.getReceiveCardViews(user);

            if (list == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.NOTEXISTMESSAGELIST.getCode(), null, null);
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SUCCESS.getCode(), null, list);

        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }
    }

    /**
     * 发送的名卡
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "sendedCard", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel sendedCard(@RequestBody RequestModel requestModel) {

        List<CardView> list = null;
        try {
            UserTb user = (UserTb) transformJSONObjectToModel(requestModel, UserTb.class);

            //验证信息
            if (!ValidateUtil.userIdValidate(user.getId())) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);//返回结构化对象
            }


            //Service select
            list = userManagerService.getSendCardViews(user);

            if (list == null) {
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.NOTEXISTMESSAGELIST.getCode(), null, null);
            }

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SUCCESS.getCode(), null, list);

        } catch (Exception e) {
            e.printStackTrace();
            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.SERVICEERROR.getCode(), null, null);
        }
    }


}
