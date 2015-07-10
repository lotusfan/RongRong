package com.rongrong.model;

import java.sql.Timestamp;

public class PrCommentTb extends ParentModel{

	private Integer id; //
	private Integer projectId; //
	private Integer userId; //
	private String content; //
	private Integer relationUserId; //
	private Timestamp createId; //

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
	public Timestamp getCreateId() {
		return createId;
	}
	public void setCreateId (Timestamp createId) {
		this.createId = createId;
	}
}