package com.rongrong.model;

import java.sql.Timestamp;

public class PrCommentTb extends ParentModel{

	private Integer id; //
	private Integer projectId; //
	private Integer userId; //
	private String content; //
	private Integer relationUserId; //
	private Timestamp createTime; //

    //用户真实姓名
    private String nameReal;

    public String getNameReal() {
        return nameReal;
    }

    public void setNameReal(String nameReal) {
        this.nameReal = nameReal;
    }

    public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId (Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId (Integer userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent (String content) {
		this.content = content;
	}
	public Integer getRelationUserId() {
		return relationUserId;
	}
	public void setRelationUserId (Integer relationUserId) {
		this.relationUserId = relationUserId;
	}

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "PrCommentTb{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", relationUserId=" + relationUserId +
                ", createTime=" + createTime +
                ", nameReal='" + nameReal + '\'' +
                '}';
    }
}