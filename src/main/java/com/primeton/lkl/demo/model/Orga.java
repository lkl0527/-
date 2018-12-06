package com.primeton.lkl.demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Orga", description = "组织信息")
public class Orga implements Serializable {

	/**
	 * 组织Id
	 */
	private Integer orgaId;

	/**
	 * 组织名
	 */
	private String orgaName;

	/**
	 * 组织
	 */
	private String orgaDesc;

	/**
	 * 组织父Id
	 */
	private Integer orgaParent;

	private static final long serialVersionUID = 1L;

	public Integer getOrgaId() {
		return orgaId;
	}

	public void setOrgaId(Integer orgaId) {
		this.orgaId = orgaId;
	}

	public String getOrgaName() {
		return orgaName;
	}

	public void setOrgaName(String orgaName) {
		this.orgaName = orgaName == null ? null : orgaName.trim();
	}

	public String getOrgaDesc() {
		return orgaDesc;
	}

	public void setOrgaDesc(String orgaDesc) {
		this.orgaDesc = orgaDesc == null ? null : orgaDesc.trim();
	}

	public Integer getOrgaParent() {
		return orgaParent;
	}

	public void setOrgaParent(Integer orgaParent) {
		this.orgaParent = orgaParent;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", orgaId=").append(orgaId);
		sb.append(", orgaName=").append(orgaName);
		sb.append(", orgaDesc=").append(orgaDesc);
		sb.append(", orgaParent=").append(orgaParent);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Orga other = (Orga) that;
		return (this.getOrgaId() == null ? other.getOrgaId() == null : this.getOrgaId().equals(other.getOrgaId()))
				&& (this.getOrgaName() == null ? other.getOrgaName() == null
						: this.getOrgaName().equals(other.getOrgaName()))
				&& (this.getOrgaDesc() == null ? other.getOrgaDesc() == null
						: this.getOrgaDesc().equals(other.getOrgaDesc()))
				&& (this.getOrgaParent() == null ? other.getOrgaParent() == null
						: this.getOrgaParent().equals(other.getOrgaParent()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getOrgaId() == null) ? 0 : getOrgaId().hashCode());
		result = prime * result + ((getOrgaName() == null) ? 0 : getOrgaName().hashCode());
		result = prime * result + ((getOrgaDesc() == null) ? 0 : getOrgaDesc().hashCode());
		result = prime * result + ((getOrgaParent() == null) ? 0 : getOrgaParent().hashCode());
		return result;
	}
}