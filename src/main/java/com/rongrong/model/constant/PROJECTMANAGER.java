package com.rongrong.model.constant;

/**
 * Created by zhangfan on 2015/7/17.
 */
public enum PROJECTMANAGER {

    SERVICEERROR("1000", ""),
    SUCCESS("2001", ""),

    PROJECTADDSUCCESS("2001", "项目添加成功"),
    PROJECTEMPTY("2002", "项目为空"),
    NOTEXISTCURRENTPAGE("2003", "没有当前页数"),

    ;


    PROJECTMANAGER(String code, String instruction) {
        this.code = code;
        this.instruction = instruction;
    }

    private String code;
    private String instruction;

    public String getCode() {
        return code;
    }

    public String getInstruction() {
        return instruction;
    }
}
