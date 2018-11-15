package com.primeton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primeton.pojo.User;
import com.primeton.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * 环境搭建测试
	 * 
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@Autowired
	private IUserService userService;

	/**
	 * 用户的登录功能
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(User user) {
		User userExist = userService.login(user);
		if (userExist != null) {
			return "redirect:/success.html";
		}
		return "redirect:/fail.html";
	}

	/**
	 * 新增用户
	 * 
	 * @param user 新增的用户信息
	 * @return 添加成功,返回添加的用户信息,添加失败,返回添加失败的用户信息
	 */
	@RequestMapping(value = "/addUser")
	public User createUser(User user) {
		 User addUser = userService.addUser(user);
		 if (addUser!=null) {
			return addUser;
		}
		 return user;
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/modifyUser")
	public User modifyUser(User user) {
		//
		return userService.modifyUser(user);
	}

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @return
	 */
	public Boolean removeUser(Integer userId) {
		return userService.removeUser(userId);
	}

	/**
	 * 获取用户
	 * 
	 * @param user
	 * @return
	 */
	public Object getUser(Integer userId) {
		return userService.getUser();
	}

}