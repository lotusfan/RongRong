package com.rongrong.model.constant;

/**
 * Created by zhangfan on 2015/7/20.
 */
public enum MESSAGE {

    INITIAL(0, ""),

    PRAISE(1, "赞"),
    COMMENT(2, "评论"),
    CARD(3, "名片"),

    //状态
    LOSEEFFECTIVENESSSTATUS(2, "失效"),
    INITIALIZTIONSTATUS(1, "初始"),
    ;


    private Integer code;
    private String instruction;

    MESSAGE(Integer code, String instruction) {
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
