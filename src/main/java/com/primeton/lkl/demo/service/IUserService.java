package com.primeton.lkl.demo.service;

import com.github.pagehelper.PageInfo;
import com.primeton.lkl.demo.model.User;
import com.primeton.lkl.demo.model.UserAndNewPassword;

/**
 * 用户管理服务接口
 * 
 * 提供用户的增删改查和用户的登录功能
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 *
 */
public interface IUserService {

	/**
	 * 新增用户
	 * 
	 * @param user 用户数据
	 * @throws Exception 异常信息
	 * 
	 */
	void createUser(User user) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param userId 用户Id
	 * @return 成功或失败
	 * @throws Exception 异常信息
	 * 
	 */
	Boolean removeUser(Integer userId) throws Exception;

	/**
	 * 修改用户
	 * 
	 * @param user 修改之后用户数据
	 * @return 修改之后用户数据
	 * @throws Exception 异常信息
	 * 
	 */
	User modifyUser(User user) throws Exception;

	/**
	 * 修改用户密码
	 * 
	 * @param userPwd 用户名,原密码,新密码
	 * @return 用户数据
	 * @throws Exception 异常信息
	 * 
	 */
	User modifyPassword(UserAndNewPassword userPwd) throws Exception;

	/**
	 * 登录功能
	 * 
	 * @param user 需要登陆的用户数据
	 * @return 用户数据
	 * @throws Exception 异常信息
	 * 
	 */
	User login(User user) throws Exception;

	/**
	 * 获取一个用户
	 * 
	 * @param userId 用户Id
	 * @return 用户数据
	 * @throws Exception 异常信息
	 * 
	 */
	User getUser(Integer userId) throws Exception;

	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName 用户名
	 * @return 用户数据
	 * @throws Exception 异常信息
	 * 
	 */
	User getUserByName(String userName) throws Exception;

	/**
	 * 查询用户列表
	 * 
	 * @param pageNum 起始页数
	 * @param pageSize 每页显示条数
	 * @param userName 用户名
	 * @param orgaId 组织Id
	 * @return 用户列表
	 * 
	 */
	PageInfo<User> queryUsers(Integer pageNum, Integer pageSize, String userName, Integer orgaId);

}
