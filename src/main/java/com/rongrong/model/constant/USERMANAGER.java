package com.rongrong.model.constant;

/**
 * Created by zhangfan on 2015/7/14.
 */
public enum USERMANAGER {


    SERVICEERROR("1000", "服务器出错"),
    SUCCESS("1200", "服务器连接成功"),

    //登录
    LOGINSUCCESS("1001", "登录成功"),
    LOGINFAIL("1002", "登录失败"),

    //注册
    REGISTERSUCCESS("1003", "注册成功"),
    USERNAMEREPEAT("1004", "用户名重复"),
    USERNAMEILLEGAL("1005", "用户名不合法"),
    PASSWORDILLEGAL("1006", "密码不合法"),
    VALIDATECODEINVALID("1006", ""),

    //修改完善信息
    ALERTSUCCESS("1007", "修改信息成功"),
    LACKUSERID("1008", "缺少用户Id"),

    //修改密码
    OLDPSMITAKE("1009", "缺少旧的密码"),

    //个人详情
    NOTEXISTUSER("1010", "不存在此用户"),

    //消息
    NOTEXISTMESSAGEID("1011", "不存在此消息Id"),
    NOTEXISTMESSAGELIST("1012", "没有消息"),

    ;

    private String code;
    private String instruction;

    USERMANAGER(String code, String instruction) {
        this.code = code;
        this.instruction = instruction;
    }

    public String getCode() {
        return code;
    }

    public String getInstruction() {
        return instruction;
    }
}
