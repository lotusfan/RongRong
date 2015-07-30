package com.rongrong.action;

import com.alibaba.fastjson.JSON;
import com.rongrong.model.requestview.RequestModel;
import com.rongrong.model.requestview.ResponseModel;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * Action层的父类 提供Action层的访问控制和其它的一些验证方法
 */
public class ActionParent {


    /**
     * 判定请求是否受权访问接口
     * @param httpServletRequest
     * @return
     */
    public boolean isRequestLegal(HttpServletRequest httpServletRequest) {
       /* if (!httpServletRequest.isRequestedSessionIdValid()) {
            return false;
        }
        return true;*/
        return httpServletRequest.isRequestedSessionIdValid();
    }

    /**
     * 生成返回前端统一Model形式
     * @param httpCode
     * @param code
     * @param mark
     * @param o
     * @return
     */
    public ResponseModel generateResponseModel(Integer httpCode, String code, String mark, Object o) {

        ResponseModel responseModel = new ResponseModel();
        if (httpCode != null)
            responseModel.setHttpCode(httpCode);
        if (code != null)
            responseModel.setCode(code);
        if (code != null)
            responseModel.setMark(mark);
        responseModel.setO(o);
        return responseModel;
    }

    /**
     * 将requestModel中的Object转化成对应的类型
     * @param requestModel
     * @param cl
     * @return
     */
    public Object transformJSONObjectToModel(RequestModel requestModel, Class cl) {
        return JSON.toJavaObject((JSON)requestModel.getO(), cl);
    }


    /**
     *版本检测   不实现
     * @param requestModel
     * @return
     */
    public String checkVersion(RequestModel requestModel) {
        return null;
    }


}
