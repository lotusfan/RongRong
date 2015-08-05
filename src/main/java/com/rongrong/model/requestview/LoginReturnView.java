package com.rongrong.model.requestview;

import com.rongrong.model.UserTb;

/**
 * Created by zhangfan on 2015/8/5.
 */
public class LoginReturnView {
    private UserTb userTb;
    private int myselfProjectNum;
    private int myselfReceiveCard;
    private int myselfSendCard;


    public UserTb getUserTb() {
        return userTb;
    }

    public void setUserTb(UserTb userTb) {
        this.userTb = userTb;
    }

    public int getMyselfProjectNum() {
        return myselfProjectNum;
    }

    public void setMyselfProjectNum(int myselfProjectNum) {
        this.myselfProjectNum = myselfProjectNum;
    }

    public int getMyselfReceiveCard() {
        return myselfReceiveCard;
    }

    public void setMyselfReceiveCard(int myselfReceiveCard) {
        this.myselfReceiveCard = myselfReceiveCard;
    }

    public int getMyselfSendCard() {
        return myselfSendCard;
    }

    public void setMyselfSendCard(int myselfSendCard) {
        this.myselfSendCard = myselfSendCard;
    }

    @Override
    public String toString() {
        return "LoginReturnView{" +
                "userTb=" + userTb +
                ", myselfProjectNum=" + myselfProjectNum +
                ", myselfReceiveCard=" + myselfReceiveCard +
                ", myselfSendCard=" + myselfSendCard +
                '}';
    }
}
