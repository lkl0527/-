package com.primeton.lkl.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.primeton.lkl.demo.exception.DemoException;
import com.primeton.lkl.demo.exception.ErrorCode;
import com.primeton.lkl.demo.mapper.IUserDao;
import com.primeton.lkl.demo.model.User;
import com.primeton.lkl.demo.model.UserAndNewPassword;
import com.primeton.lkl.demo.service.IUserService;
import com.primeton.lkl.demo.utils.Md5Util;
import com.primeton.lkl.demo.utils.ValidateUtil;

/**
 * 用户管理服务接口实现类
 * 
 * 提供用户的增删改查和用户的登录功能
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 *
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	/**
	 * 新增用户
	 * 
	 * @param 用户信息
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public void createUser(User user) throws Exception {
		// 用户名不合法抛异常
		ValidateUtil.userNameIsNotValid(user.getUserName());

		// 用户名重复抛异常
		userNameIsExist(user.getUserName());

		// 密码不合法抛异常
		ValidateUtil.userPasswordIsNotValid(user.getUserPassword());

		// 密码加密传入
		user.setUserPassword(Md5Util.encode(user.getUserPassword()));

		// 插入数据
		userDao.insertSelectiveAndGetKey(user);

	}

	/**
	 * 删除用户
	 * 
	 * @param userId 用户Id
	 * @return 成功失败
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public Boolean removeUser(Integer userId) throws Exception {
		// 未传入用户Id抛异常
		ValidateUtil.paramIsNotEmpty(userId, ErrorCode.USERID_IS_NULL);
		// 根据userId删除用户
		if (userDao.deleteUserById(userId) == 1) {
			// 成功
			return true;
		}
		// 失败
		return false;
	}

	/**
	 * 修改用户信息
	 * 
	 * @param 用户信息
	 * @return 修改之后用户信息
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public User modifyUser(User user) throws Exception {
		// 未传入用户Id抛异常
		ValidateUtil.paramIsNotEmpty(user.getUserId(), ErrorCode.USERID_IS_NULL);

		// 传入的用户Id不存在抛异常
		User userByKey = userDao.selectByPrimaryKey(user.getUserId());
		if (userByKey == null) {
			throw new DemoException(ErrorCode.USER_IS_NULL);
		}

		// 用户名不合法抛异常
		ValidateUtil.userNameIsNotValid(user.getUserName());
		
		//用户名存在抛异常
		if (!user.getUserName().equals(userByKey.getUserName())) {
			// 用户名存在抛异常
			userNameIsExist(user.getUserName());
		}

		// 如果在这个地方传入的用户密码,就是非法更改数据
		if (user.getUserPassword() != null) {
			throw new DemoException(ErrorCode.USERNAME_NOT_VALIDITY);
		}

		// 更新字段
		int updateUser = userDao.modifyUser(user);
		if (updateUser == 0) {
			return null;
		}
		return userDao.getUserById(user.getUserId());
	}

	/**
	 * 根据用户原密码修改新密码
	 * 
	 * @param userPwd 用户名,用户原密码,用户新密码
	 * @return 用户信息
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public User modifyPassword(UserAndNewPassword userPwd) throws Exception {
		// 原密码不合法抛异常
		ValidateUtil.userPasswordIsNotValid(userPwd.getUserPassword());

		// 新密码不合法抛异常
		ValidateUtil.userPasswordIsNotValid(userPwd.getNewPassword());

		// 用户不存在抛异常
		if (userDao.getUserByName(userPwd.getUserName()) == null) {
			throw new DemoException(ErrorCode.USER_IS_NULL);
		}

		// 判断原密码是否正确和密码是否正确
		User user = matchPassword(userPwd);
		// 将密码加密进行判断
		user.setUserPassword(Md5Util.encode(userPwd.getNewPassword()));
		// 更新密码字段
		userDao.modifyUser(user);
		return user;
	}

	/**
	 * 用户登录
	 * 
	 * @param 用户信息
	 * @return 用户信息
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public User login(User user) throws Exception {
		String userPassword = Md5Util.encode(user.getUserPassword());
		return userDao.login(user.getUserName(), userPassword);
	}

	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName 用户名
	 * @return 用户信息
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public User getUserByName(String userName) throws Exception {
		// 用户名不合法抛异常
		ValidateUtil.userNameIsNotValid(userName);

		// 根据用户名查询用户
		return userDao.getUserByName(userName);

	}

	/**
	 * 根据用户Id查询用户
	 * 
	 * @param userId 用户Id
	 * @return 用户信息
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public User getUser(Integer userId) throws Exception {

		// 查询用户的id为空抛异常
		ValidateUtil.paramIsNotEmpty(userId, ErrorCode.USERID_IS_NULL);

		// 根据userId查询用户信息
		User userById = userDao.getUserById(userId);
		if (userById == null) {
			throw new DemoException(ErrorCode.USER_IS_NULL);
		}
		return userById;
	}

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
	@Override
	@Transactional(readOnly = true)
	public PageInfo<User> queryUsers(Integer pageNum, Integer pageSize, String userName, Integer orgaId) {
		// 默认10页
		if (pageSize == null) {
			pageSize = 10;
		}
		// 为0或为负时查询所有
		if (pageSize < 0) {
			pageSize = 0;
		}
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = null;
		if (orgaId == null) {
			users = userDao.queryUsers(userName, orgaId);
		} else {
			users = userDao.selectOrgaUsers(userName, orgaId);
		}

		PageInfo<User> pageInfo = new PageInfo<>(users, pageSize);
		return pageInfo;
	}

	/**
	 * 判断新旧密码是否相同,判断原密码是否错误
	 * 
	 * @param userPwd 用户名,用户原密码,用户新密码
	 * @return 用户信息
	 * @throws Exception 异常信息
	 * 
	 */
	private User matchPassword(UserAndNewPassword userPwd) throws Exception {
		String oldEncode = Md5Util.encode(userPwd.getUserPassword());
		String newEncode = Md5Util.encode(userPwd.getNewPassword());
		// 原密码与新密码相同抛异常
		if (oldEncode.equals(newEncode)) {
			throw new DemoException(ErrorCode.PASSWORD_IS_SAME);
		}
		User user = userDao.login(userPwd.getUserName(), oldEncode);
		if (user == null) {
			// 原密码不匹配
			throw new DemoException(ErrorCode.PASSWORD_ERROR);
		}
		return user;
	}

	/**
	 * 用户名存在抛异常
	 * 
	 * @param userName 用户名
	 * @throws Exception 异常信息
	 * 
	 */
	private void userNameIsExist(String userName) throws Exception {
		User user = userDao.getUserByName(userName);
		if (user != null) {
			throw new DemoException(ErrorCode.USERNAME_ALREADY_EXISTS);
		}
	}

}
