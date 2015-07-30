package com.rongrong.action;

import com.rongrong.model.LogInfo;
import com.rongrong.model.requestview.RequestModel;
import com.rongrong.model.requestview.ResponseModel;
import com.rongrong.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangfan on 2015/7/15.
 * <p/>
 * 系统基础服务  登录，登出日志，
 */
@Controller
@RequestMapping(value = "/sys")
public class SystemAction extends ActionParent {

    @Autowired
    private SystemService systemService;


    /**
     * 登录，登出日志
     *
     * @param requestModel
     * @return
     */
    @RequestMapping(value = "loginInfo", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel loginInfo(@RequestBody RequestModel requestModel) {

        try {

            LogInfo logInfo = (LogInfo) transformJSONObjectToModel(requestModel, LogInfo.class);//将requestModel里的o强转为user对象

            systemService.loginInfo(logInfo);

        } catch (Exception e) {
        }

        return new ResponseModel();
    }
}
