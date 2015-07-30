package com.rongrong.model.constant;

/**
 * Created by zhangfan on 2015/7/20.
 */
public enum PROJECT {
    PUBLIST(1, "发布"),
    CANCEL(2, "取消"),
    ;

    private int code;
    private String instruction;

    PROJECT(int code, String instruction) {
        this.code = code;
        this.instruction = instruction;
    }

    public int getCode() {
        return code;
    }

    public String getInstruction() {
        return instruction;
    }
}
