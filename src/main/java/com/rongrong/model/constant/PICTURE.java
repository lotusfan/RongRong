package com.rongrong.model.constant;

/**
 * Created by zhangfan on 2015/7/23.
 */
public enum PICTURE {

    USERHEAD(1, "头像"),
    PROJECT(2, "项目"),

    //状态
    LOSEEFFECTIVENESSSTATUS(2, "失效"),
    INITIALIZTIONSTATUS(1, "初始"),

    ;

    private Integer code;
    private String instruction;

    PICTURE(Integer code, String instruction) {
        this.code = code;
        this.instruction = instruction;
    }

    public Integer getCode() {
        return code;
    }

    public String getInstruction() {
        return instruction;
    }
}
