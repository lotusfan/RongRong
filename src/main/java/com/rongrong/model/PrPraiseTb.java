package com.rongrong.model;

import java.sql.Timestamp;

public class PrPraiseTb extends ParentModel{

	private Integer id; //
	private Integer projectId; //
	private Integer praiseUserId; //
	private Timestamp createTime; //

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
	public Integer getPraiseUserId() {
		return praiseUserId;
	}
	public void setPraiseUserId (Integer praiseUserId) {
		this.praiseUserId = praiseUserId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}
}