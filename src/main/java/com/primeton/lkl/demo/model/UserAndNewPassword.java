package com.primeton.lkl.demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "UserAndNewPassword", description = "用户原密码和新密码")
public class UserAndNewPassword implements Serializable {

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 用户密码
	 */
	private String userPassword;

	/**
	 * 用户新密码
	 */
	private String newPassword;

	private static final long serialVersionUID = 1L;

	public UserAndNewPassword() {
	}

	public UserAndNewPassword(String userName, String userPassword, String newPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.newPassword = newPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
