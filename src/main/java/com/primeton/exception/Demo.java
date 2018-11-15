package com.primeton.exception;

/**
 * 系统异常码定义。
 *
 *
 */
public enum Demo {
	;

	/*
	 * 通用异常
	 */
	public enum Common {
		SYSTEM_ERROR("00000"), // 系统错误异常码
		ILLEGAL_PARAMETER("00001"), // 非法参数错误异常码
		UNAUTHORIZED_ERROR("00002"), // 未授权错误异常码
		NOT_LOGIN("00003"), // 未登录错误异常码
		LOCK_ACQUIRED_TIMEOUT("00004"), // 锁获取超时错误异常码
		OUT_OF_USER_COUNT("00005"), // 锁获取超时错误异常码
		REFRESH_TOKEN("00006"),// TOKEN刷新失败
		;
		private String value;

		private Common(String value) {
			this.value = value;
		}

		public String toString() {
			return "DEMO_COMMON_" + this.name();
		}
	}
}