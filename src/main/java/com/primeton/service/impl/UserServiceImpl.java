package com.primeton.service.impl;

import org.mockito.internal.stubbing.answers.ThrowsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeton.mapper.IUserDao;
import com.primeton.pojo.User;
import com.primeton.service.IUserService;
import com.primeton.transactional.Transactional;
import com.primeton.utils.Md5Util;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	/**
	 * 用户登录
	 */
	@Override
	public User login(User user) {
		// 将密码加密传入
		String encode = user.getUserPassword();
		String userPassword = Md5Util.encode(encode);
		return userDao.login(user.getUserName(), userPassword);
	}

	/**
	 * 新增用户
	 */
	@Override
	public User addUser(User user) {
		// 判断用户新增名称是否重复
		// 如果用户输入的name在数据库查询为空,证明这个name可以使用
		try {
			if (userDao.getUserByName(user.getUserName()) == null) {
				String encode = Md5Util.encode(user.getUserPassword());
				user.setUserPassword(encode);
				userDao.insertUser(user);
			}
		} catch (Exception e) {
			// 用户名重复,请更换
			e.printStackTrace();
		} finally {
			return user;
		}

	}

	/**
	 * 根据用户名查询用户
	 */
	@Override
	public User seletByName(String userName) {
		return userDao.getUserByName(userName);
	}

	/**
	 * 修改用户信息
	 */
	@Override
	public User modifyUser(User user) {
		// 更新成功
		if (userDao.insertSelective(user) > 1) {
			return userDao.selectByPrimaryKey(user.getUserId());
		}
		return user;
	}

	@Override
	public Object getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean removeUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
