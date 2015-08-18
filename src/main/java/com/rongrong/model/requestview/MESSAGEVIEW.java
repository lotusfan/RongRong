package com.rongrong.model.requestview;


import java.sql.Timestamp;

/**
 * Created by zhangfan on 15/8/13.
 */
public class MessageView {

    private Integer messageId;
    private String headUrl; //头像路径
    private String nameReal; //真实姓名
    private String comment; //评论内容(点赞为空)
    private Integer type; //类型(评论,点赞)
    private Integer status; //状态(已读,未读)
    private Integer projectId; //项目ID
    private String summary; //项目简介
    private Timestamp createTime; //创建时间


    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getNameReal() {
        return nameReal;
    }

    public void setNameReal(String nameReal) {
        this.nameReal = nameReal;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MessageView{" +
                "messageId=" + messageId +
                ", headUrl='" + headUrl + '\'' +
                ", nameReal='" + nameReal + '\'' +
                ", comment='" + comment + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", projectId=" + projectId +
                ", summary='" + summary + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
