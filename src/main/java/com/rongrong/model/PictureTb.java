package com.rongrong.model;

import java.sql.Timestamp;

public class PictureTb extends ParentModel{

	private Integer id; //
	private Integer type; //
	private String url; //
	private Integer relationId; //
	private Integer status; //
	private Timestamp createTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType (Integer type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl (String url) {
		this.url = url;
	}
	public Integer getRelationId() {
		return relationId;
	}
	public void setRelationId (Integer relationId) {
		this.relationId = relationId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus (Integer status) {
		this.status = status;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}
}