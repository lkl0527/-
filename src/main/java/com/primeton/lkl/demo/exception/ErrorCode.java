package com.primeton.lkl.demo.exception;

/*
 * 通用异常
 */
public enum ErrorCode {
	SUCCESS("10000", null), // 返回正常数据
	SYSTEM_ERROR("00000", "系统错误异常码"), // 系统错误异常码
	ILLEGAL_PARAMETER("00001", "非法参数错误异常码"), // 非法参数错误异常码
	UNAUTHORIZED_ERROR("00002", "未授权错误异常码"), // 未授权错误异常码
	NOT_LOGIN("00003", "请登录"), // 请登录
	LOCK_ACQUIRED_TIMEOUT("00004", "锁获取超时错误异常码"), // 锁获取超时错误异常码
	OUT_OF_USER_COUNT("00005", "锁获取超时错误异常码"), // 锁获取超时错误异常码
	REFRESH_TOKEN("00006", "TOKEN刷新失败"), // TOKEN刷新失败
	USERNAME_NOT_VALIDITY("00007", "账号长度为3-5位的字符"), // 用户名不合法
	PASSWORD_NOT_VALIDITY("00008", "密码长度为6-10位的字符"), // 密码不合法
	PASSWORD_ERROR("00009", "密码错误"), // 密码错误
	PASSWORD_IS_SAME("00010", "密码相同"), // 密码相同
	USERID_IS_NULL("00011", "用户Id不存在"), // 用户Id不存在
	USER_IS_NULL("00012", "用户不存在"), // 用户不存在
	USERNAME_ALREADY_EXISTS("00013", "用户名已存在"), // 用户名已存在
	USERNAME_PASSWORD_ERROR("00014", "帐号密码不匹配"), // 帐号密码不匹配
	PARAMS_IS_ERROR("00015", "请传入正确数据"), // 请传入正确数据
	ORGANAME_IS_NULL("00016", "组织名不能为空"), // 组织名不能为空
	ORGAID_IS_NULL("00017", "组织不存在"), // 组织Id不存在
	ORGA_IS_NULL("00018", "组织不存在"), // 组织不存在
	ORGANAME_IS_SAME("00019", "组织名重复"), // 组织名重复
	DATABASE_RESULT_EMPTY("00020", "组织下有没有信息"), // 组织下有没有信息
	ORGA_USER_NOT_NULL("00021", "该组织下有用户,不能删除"), // 该组织下有用户,不能删除
	ORGA_NOT_NULL("00021", "该组织下有组织"), // 该组织下有组织
	;

	private String errorCode;
	private String errorMessage;

	private ErrorCode(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private ErrorCode(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String toString() {
		return "DEMO_COMMON_" + this.name();
	}
}
