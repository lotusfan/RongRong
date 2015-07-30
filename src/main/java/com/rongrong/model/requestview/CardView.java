package com.rongrong.model.requestview;

import java.sql.Timestamp;

/**
 * Created by zhangfan on 2015/7/25.
 */
public class CardView {

    private Integer messageId;
    private Timestamp createTime;
    private Integer fromUserId;
    private Integer toUserId;
    private Integer otherUserId;
    //用户
    private String nameReal; //真实姓名
    private String headUrl; //头像路径
    private String companyAddress; //地址
    private String position; //职位
    private String company; //公司名


    public Integer getOtherUserId() {
        return otherUserId;
    }

    public void setOtherUserId(Integer otherUserId) {
        this.otherUserId = otherUserId;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getNameReal() {
        return nameReal;
    }

    public void setNameReal(String nameReal) {
        this.nameReal = nameReal;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "CardView{" +
                "messageId=" + messageId +
                ", createTime=" + createTime +
                ", fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", otherUserId=" + otherUserId +
                ", nameReal='" + nameReal + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
