package com.primeton.lkl.demo.utils;

import com.primeton.lkl.demo.exception.DemoException;
import com.primeton.lkl.demo.exception.ErrorCode;

/**
 * 定义参数验证工具类
 * 
 * 验证数据
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 * 
 */
public class ValidateUtil {

	/**
	 * 传入参数不能为空,如果为空,就抛异常
	 * 
	 * @param param
	 *            需要验证的参数
	 * @param common
	 * @throws Exception
	 *             异常信息
	 * 
	 */
	public static void paramIsNotEmpty(Object param, ErrorCode common) throws Exception {
		if (null == param) {
			throw new DemoException(common);
		}

		if (param instanceof String && ((String) param).length() == 0) {
			throw new DemoException(common);
		}

	}

	/**
	 * 判断用户名是否合法
	 * 
	 * @param param
	 *            需要验证的参数
	 * @param common
	 * @throws Exception
	 *             异常信息
	 * 
	 */
	public static void userNameIsNotValid(String userName) throws Exception {
		if (userName.length() < 3 || userName.length() > 5)
			throw new DemoException(ErrorCode.USERNAME_NOT_VALIDITY);

	}

	/**
	 * 判断密码的合法性
	 * 
	 * @param param
	 *            需要验证的数据
	 * @param common
	 * @throws Exception
	 *             异常处理
	 * 
	 */
	public static void userPasswordIsNotValid(String password) throws Exception {
		if (password.length() < 3 || password.length() > 10)
			throw new DemoException(ErrorCode.PASSWORD_NOT_VALIDITY);
	}
}
