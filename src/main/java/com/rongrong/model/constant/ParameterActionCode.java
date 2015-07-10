package com.rongrong.model.constant;

/**
 * Created by zhangfan on 2015/3/9.
 * <p/>
 * Action层返回前台参数编码
 */
public enum ParameterActionCode {
    /*Action层*/
    REQUESTSUCCESS("0200"),
    REQUESTFAIL("0500"),

    NOAUTHORITY("0003"),
    TIMEOUT("0004"),
    SERVERERROR("0005"),
    REQUESTLEGAL("0006"),
    VERSIONINCOMPLETE("0007"), //版本信息不完整
    VERSIONNEEDUPDATE("0008"),//版本需要更新
    VERSIONNOTNEEDUPDATE("0009"),//版本不需要更新
    SESSIONINVALID("0010"),//Session过期超时
    DATANOTCOMPLETE("0011"),//上传数据不完整
    USEREXIST("0012"), //用户已存在


    /*服务器层*/
    SELECTUSERERROR("0051"), //用户名和密码不匹配
    SELECTUSERSUCCESS("0052"), //用户登录成功
    NOID("0053"), //没有用户ID
    UPDATEERROR("0054"),//更新错误
    UPDATESUCCESS("0055"),//更新成功
    SELECTERROR("0056"),//查询错误
    SELECTSUCCESS("0057"),//查询成功
    INSERTERROR("0059"),//数据添加错误
    INSERTSUCCESS("0058"),//数据添加正确
    UPLOADPICSUCCESS("0059"),//图片存储成功
    UPLOADPICERROR("0060"),//图片存储出错
    AUTHENTICODEERROR("0061"),//验证码发送失败
    AUTHENTICODESUCCESS("0062"),//验证码发送成功

    ;


    private String code;

    ParameterActionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
