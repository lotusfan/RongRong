package com.rongrong.model;

import java.sql.Timestamp;

public class LogInfo extends ParentModel{

	private Integer id; //
	private Integer userId; //
	private String ip; //
	private String longitude; //
	private String latitude; //
	private Integer type; //登入1登出2
	private String uuid; //
	private Timestamp createTime; //

	public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId (Integer userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp (String ip) {
		this.ip = ip;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude (String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude (String latitude) {
		this.latitude = latitude;
	}
	public Integer getType() {
		return type;
	}
	public void setType (Integer type) {
		this.type = type;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid (String uuid) {
		this.uuid = uuid;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}
}