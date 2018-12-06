package com.primeton.lkl.demo.model;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "User", description = "用户信息")
public class User implements Serializable {

	/**
	 * 用户Id
	 */
	private Integer userId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 用户密码
	 */
	private String userPassword;

	/**
	 * 用户生日
	 */
	private Date userBirthday;

	/**
	 * 用户性别
	 */
	private String userGender;

	/**
	 * 用户状态
	 */
	private String userRemart;

	/**
	 * 组织Id
	 */
	private Integer orgaId;

	private static final long serialVersionUID = 1L;

	public User() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword == null ? null : userPassword.trim();
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender == null ? null : userGender.trim();
	}

	public String getUserRemart() {
		return userRemart;
	}

	public void setUserRemart(String userRemart) {
		this.userRemart = userRemart == null ? null : userRemart.trim();
	}

	public Integer getOrgaId() {
		return orgaId;
	}

	public void setOrgaId(Integer orgaId) {
		this.orgaId = orgaId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", userId=").append(userId);
		sb.append(", userName=").append(userName);
		sb.append(", userPassword=").append(userPassword);
		sb.append(", userBirthday=").append(userBirthday);
		sb.append(", userGender=").append(userGender);
		sb.append(", userRemart=").append(userRemart);
		sb.append(", orgaId=").append(orgaId);
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
		User other = (User) that;
		return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
				&& (this.getUserName() == null ? other.getUserName() == null
						: this.getUserName().equals(other.getUserName()))
				&& (this.getUserPassword() == null ? other.getUserPassword() == null
						: this.getUserPassword().equals(other.getUserPassword()))
				&& (this.getUserBirthday() == null ? other.getUserBirthday() == null
						: this.getUserBirthday().equals(other.getUserBirthday()))
				&& (this.getUserGender() == null ? other.getUserGender() == null
						: this.getUserGender().equals(other.getUserGender()))
				&& (this.getUserRemart() == null ? other.getUserRemart() == null
						: this.getUserRemart().equals(other.getUserRemart()))
				&& (this.getOrgaId() == null ? other.getOrgaId() == null : this.getOrgaId().equals(other.getOrgaId()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
		result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
		result = prime * result + ((getUserBirthday() == null) ? 0 : getUserBirthday().hashCode());
		result = prime * result + ((getUserGender() == null) ? 0 : getUserGender().hashCode());
		result = prime * result + ((getUserRemart() == null) ? 0 : getUserRemart().hashCode());
		result = prime * result + ((getOrgaId() == null) ? 0 : getOrgaId().hashCode());
		return result;
	}
}