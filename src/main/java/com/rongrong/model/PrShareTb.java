package com.rongrong.model;

import java.sql.Timestamp;

public class PrShareTb extends ParentModel{

	private Integer id; //
	private Integer projectId; //
	private Integer shareUserId; //
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
	public Integer getShareUserId() {
		return shareUserId;
	}
	public void setShareUserId (Integer shareUserId) {
		this.shareUserId = shareUserId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}
}