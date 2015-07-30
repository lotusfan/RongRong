package com.rongrong.model.constant;

/**
 * Created by zhangfan on 2015/7/14.
 */
public enum USERMANAGER {


    SERVICEERROR("1000", ""),
    SUCCESS("1001", ""),

    //登录
    LOGINSUCCESS("1001", ""),
    LOGINFAIL("1002", ""),

    //注册
    REGISTERSUCCESS("1001", ""),
    USERNAMEREPEAT("1004", ""),
    USERNAMEILLEGAL("1005", ""),
    PASSWORDILLEGAL("1006", ""),
    VALIDATECODEINVALID("1006", ""),

    //修改完善信息
    ALERTSUCCESS("1001", ""),
    LACKUSERID("1008", ""),

    //修改密码
    OLDPSMITAKE("1009", ""),

    //个人详情
    NOTEXISTUSER("1010", ""),

    //消息
    NOTEXISTMESSAGEID("1011", ""),
    NOTEXISTMESSAGELIST("1012", ""),

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
