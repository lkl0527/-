package com.primeton.lkl.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.primeton.lkl.demo.exception.ErrorCode;

/**
 * 统一返回值处理
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 * 
 */
public class JsonResponse {

	/**
	 * code 属性
	 */
	private String code = ErrorCode.SUCCESS.getErrorCode();

	/**
	 * 错误信息,如果有显示
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String error = null;

	/**
	 * 数据返回 如果有显示
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data = null;

	public JsonResponse() {
	}

	public JsonResponse(String code, String error, Object data) {
		this.code = code;
		this.error = error;
		this.data = data;
	}

	public JsonResponse(String code, String error) {
		super();
		this.code = code;
		this.error = error;
	}

	public JsonResponse(Object data) {
		super();
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}