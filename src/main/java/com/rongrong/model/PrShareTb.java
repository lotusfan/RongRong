package com.rongrong.model;

import java.sql.Timestamp;

public class PrShareTb extends ParentModel{

	private Integer id; //
	private Integer projectId; //
	private Integer shareUserId; //
	private Timestamp createTime; //

    //用户
    private String nameReal; //真实姓名
    private String headUrl; //头像路径
    private String companyAddress; //地址
    private String position; //职位
    private String company; //公司名

    public String getNameReal() {
        return nameReal;
    }

    public void setNameReal(String nameReal) {
        this.nameReal = nameReal;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    @Override
    public String toString() {
        return "PrShareTb{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", shareUserId=" + shareUserId +
                ", createTime=" + createTime +
                ", nameReal='" + nameReal + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}