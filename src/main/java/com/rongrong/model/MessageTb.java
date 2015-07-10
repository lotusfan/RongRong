package com.rongrong.model;

import java.sql.Timestamp;

public class MessageTb extends ParentModel{

	private Integer id; //
	private Integer fromUserId; //
	private Integer toUserId; //
	private Integer type; //
	private Integer status; //
	private Integer relationId; //
	private Timestamp createTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId (Integer fromUserId) {
		this.fromUserId = fromUserId;
	}
	public Integer getToUserId() {
		return toUserId;
	}
	public void setToUserId (Integer toUserId) {
		this.toUserId = toUserId;
	}
	public Integer getType() {
		return type;
	}
	public void setType (Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus (Integer status) {
		this.status = status;
	}
	public Integer getRelationId() {
		return relationId;
	}
	public void setRelationId (Integer relationId) {
		this.relationId = relationId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}
}