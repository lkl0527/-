package com.primeton.lkl.demo.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.primeton.lkl.demo.handler.WebHandlerInterceptor;

/**
 * 注册拦截器
 * 
 * 定义拦截规则
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 * 
 */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		/**
		 * 定义拦截器拦截的路径: "/*//**" 表示拦截所有。
		 */
		String pathPatten = "/*/**";
		// 注册自定义拦截器
		registry.addInterceptor(new WebHandlerInterceptor()).addPathPatterns(pathPatten);
		super.addInterceptors(registry);
	}

}
