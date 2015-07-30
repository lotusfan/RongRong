package com.rongrong.model.requestview;

/**
 * Created by zhangfan on 2015/7/15.
 */
public class AlertPasswordView {

    private Integer userId; //用户Id
    private String oldPs; //旧密码
    private String newPs; //新密码


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOldPs() {
        return oldPs;
    }

    public void setOldPs(String oldPs) {
        this.oldPs = oldPs;
    }

    public String getNewPs() {
        return newPs;
    }

    public void setNewPs(String newPs) {
        this.newPs = newPs;
    }

    @Override
    public String toString() {
        return "AlertPasswordView{" +
                "userId=" + userId +
                ", oldPs='" + oldPs + '\'' +
                ", newPs='" + newPs + '\'' +
                '}';
    }
}
