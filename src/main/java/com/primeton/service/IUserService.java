package com.primeton.service;

import com.primeton.pojo.User;

public interface IUserService {

	// 用户登录
	User login(User user);

	// 新增用户
	User addUser(User user);

	// 根据用户名查询用户是否存在
	User seletByName(String userName);

	// 修改用户
	User modifyUser(User user);

	// 获取用户
	Object getUser();
	
	// 删除用户
	Boolean removeUser(Integer userId);

}
