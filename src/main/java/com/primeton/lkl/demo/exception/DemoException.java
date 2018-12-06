package com.primeton.lkl.demo.exception;

public class DemoException extends Exception {

	/**
	 * 错误码
	 */
	private String errorCode;

	/**
	 * 错误信息
	 */
	private String errorMessage;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DemoException() {
	}

	/**
	 * 定义构造方法
	 * 
	 * @param common
	 *            异常码与异常信息
	 */
	public DemoException(ErrorCode common) {
		this.errorCode = common.getErrorCode();
		this.errorMessage = common.getErrorMessage();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
