package com.primeton.lkl.demo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.primeton.lkl.demo.exception.ErrorCode;
import com.primeton.lkl.demo.exception.DemoException;

@Component
public class WebHandlerInterceptor implements org.springframework.web.servlet.HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {

		HttpSession session = request.getSession();
		// 定义一个数组,对其中的路径直接放行
		String[] list = new String[] { "/test", "/api/users/actions/login", "/valid_code","/api/orgas/actions/nested"
				// 登录或者注册时候的图片验证码,
		};
		for (int i = 0; i < list.length; i++) {
			if (request.getRequestURI().equals(list[i])) {
				// 存在直接放行
				return true;
			}
		}
		// 判断一些其他的需要放行的逻辑,录入用户没有登录的情况下,就拦截
		// 查询token 找到用户,从缓存中查找
		if (session.getAttribute("userId") == null) {
//			throw new DemoException(ErrorCode.NOT_LOGIN);
			return true;
		}
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception exception) throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
			ModelAndView modelAndView) throws Exception {

	}

}