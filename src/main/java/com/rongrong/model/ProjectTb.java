package com.rongrong.model;

import java.sql.Timestamp;
import java.math.BigDecimal;

public class ProjectTb extends ParentModel{

	private Integer id; //
    private Integer userId;
	private String title; //
	private Float acceptCost; //
	private String mainBody; //
	private BigDecimal ammount; //
	private String timeLimit; //
	private String measure; //
	private String define; //
	private String summary; //
    private int status;
	private Timestamp createTime; //
	private Timestamp updateTime; //

    public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
		return title;
	}
	public void setTitle (String title) {
		this.title = title;
	}
	public Float getAcceptCost() {
		return acceptCost;
	}
	public void setAcceptCost (Float acceptCost) {
		this.acceptCost = acceptCost;
	}
	public String getMainBody() {
		return mainBody;
	}
	public void setMainBody (String mainBody) {
		this.mainBody = mainBody;
	}
	public BigDecimal getAmmount() {
		return ammount;
	}
	public void setAmmount (BigDecimal ammount) {
		this.ammount = ammount;
	}
	public String getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit (String timeLimit) {
		this.timeLimit = timeLimit;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure (String measure) {
		this.measure = measure;
	}
	public String getDefine() {
		return define;
	}
	public void setDefine (String define) {
		this.define = define;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary (String summary) {
		this.summary = summary;
	}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime (Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime (Timestamp updateTime) {
		this.updateTime = updateTime;
	}


    @Override
    public String toString() {
        return "ProjectTb{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", acceptCost=" + acceptCost +
                ", mainBody='" + mainBody + '\'' +
                ", ammount=" + ammount +
                ", timeLimit='" + timeLimit + '\'' +
                ", measure='" + measure + '\'' +
                ", define='" + define + '\'' +
                ", summary='" + summary + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}