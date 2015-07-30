package com.rongrong.action;

import com.rongrong.model.MessageTb;
import com.rongrong.model.UserTb;
import com.rongrong.model.constant.HTTPCODE;
import com.rongrong.model.constant.USERMANAGER;
import com.rongrong.model.requestview.AlertPasswordView;
import com.rongrong.model.requestview.CardView;
import com.rongrong.model.requestview.RequestModel;
import com.rongrong.model.requestview.ResponseModel;
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
            USERMANAGER e = userManagerService.userLogin(user);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);//返回结构化对象

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
            USERMANAGER e = userManagerService.userRegister(user);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);//返回结构化对象

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
            USERMANAGER e = userManagerService.userAlertInfo(user);

            return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), e.getCode(), null, null);//返回结构化对象

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
            if (!ValidateUtil.userIdValidate(user.getId())) { //用户Id校验
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);//返回结构化对象
            }

            if (!ValidateUtil.loginPwValidate(user.getLoginPs())) { //密码校验
                return generateResponseModel(HTTPCODE.HTTPSUCCESS.getCode(), USERMANAGER.PASSWORDILLEGAL.getCode(), null, null);//返回结构化对象
            }

            //Service 更新
            USERMANAGER e = userManagerService.userAlertInfo(user);

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
            if (ValidateUtil.figureValidate(message.getId())) {
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
