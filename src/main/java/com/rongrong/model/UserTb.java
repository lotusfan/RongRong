package com.rongrong.model;

import java.sql.Timestamp;

public class UserTb extends ParentModel{

	private Integer id; //
	private String nameReal; //
	private String rrId; //
	private Integer sex; //
	private String loginName; //
	private String loginPs; //
	private String job; //
	private String position; //
	private String company; //
	private String companyAddress; //
	private String eMail; //
	private String qq; //
	private String weixin; //
	private Timestamp createTime; //
	private Timestamp updateTime; //

    //个人详情View
    private int projectNum; //项目总数

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(int projectNum) {
        this.projectNum = projectNum;
    }

    public Integer getId() {
		return id;
	}
	public void setId (Integer id) {
		this.id = id;
	}
	public String getNameReal() {
		return nameReal;
	}
	public void setNameReal (String nameReal) {
		this.nameReal = nameReal;
	}
	public String getRrId() {
		return rrId;
	}
	public void setRrId (String rrId) {
		this.rrId = rrId;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex (Integer sex) {
		this.sex = sex;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName (String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPs() {
		return loginPs;
	}
	public void setLoginPs (String loginPs) {
		this.loginPs = loginPs;
	}
	public String getJob() {
		return job;
	}
	public void setJob (String job) {
		this.job = job;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition (String position) {
		this.position = position;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany (String company) {
		this.company = company;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress (String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getEMail() {
		return eMail;
	}
	public void setEMail (String eMail) {
		this.eMail = eMail;
	}
	public String getQq() {
		return qq;
	}
	public void setQq (String qq) {
		this.qq = qq;
	}
	public String getWeixin() {
		return weixin;
	}
	public void setWeixin (String weixin) {
		this.weixin = weixin;
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
}