package com.primeton.lkl.demo.handler;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.primeton.lkl.demo.exception.ErrorCode;
import com.primeton.lkl.demo.exception.DemoException;
import com.primeton.lkl.demo.model.JsonResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);// 初始化日志对象

	// 声明要捕获的异常
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Object defultExcepitonHandler(HttpServletRequest request, HttpServletResponse response, Exception e) {
		if (e instanceof DemoException) {
			DemoException ex = (DemoException) e;
			logger.error(ex.getMessage(), ex);
			return new ResponseEntity<JsonResponse>(new JsonResponse(ex.getErrorCode(), ex.getErrorMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.error("系统错误:", e);
		return new ResponseEntity<JsonResponse>(
				new JsonResponse(ErrorCode.SYSTEM_ERROR.getErrorCode(), "发现错误:请联系管理员qq:88888888"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}