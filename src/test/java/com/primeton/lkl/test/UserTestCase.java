package com.primeton.lkl.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.lkl.demo.LikanglinDemoApplication;
import com.primeton.lkl.demo.controller.UserController;
import com.primeton.lkl.demo.mapper.IUserDao;
import com.primeton.lkl.demo.model.JsonResponse;
import com.primeton.lkl.demo.model.User;
import com.primeton.lkl.demo.model.UserAndNewPassword;
import com.primeton.lkl.demo.model.UserQuery;
import com.primeton.lkl.demo.model.UserQuery.Criteria;
import com.primeton.lkl.demo.utils.Md5Util;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LikanglinDemoApplication.class)
public class UserTestCase {

	@Autowired
	private UserController userController;

	@Autowired
	private IUserDao userDao;

	@Test
	public void testUser() throws Exception {

		User user = new User();
		user.setUserName("demo");
		user.setUserPassword("000000");

		// 创建用户
		testCreateUser(user);
		// 更新密码
		testModifyPassword(user);
		// 更新用户
		testModifyUser(user);
		// 获取用户
		testGetUser(user);
		// 获取所有用户
		testQueryUsers();
		// 删除用户
		testRemoveUser(user);
	}

	private void testCreateUser(User user) throws Exception {
		UserQuery userQuery = new UserQuery();
		Criteria criteria = userQuery.createCriteria();
		criteria.andUserNameEqualTo("demo");
		userDao.deleteByExample(userQuery);
		userController.createUser(user);
		Assert.assertNotNull("测试用户创建", user.getUserId());
	}

	private void testModifyPassword(User user) throws Exception {
		UserAndNewPassword userPwd = new UserAndNewPassword(user.getUserName(), "000000", "123456");
		JsonResponse modifyPassword = userController.modifyPassword(userPwd);
		Object data = modifyPassword.getData();
		if (data instanceof User) {
			User user2 = (User) data;
			Assert.assertEquals("测试用户更新密码", user2.getUserPassword(), Md5Util.encode("123456"));
		}
	}

	private void testModifyUser(User user) throws Exception {
		UserQuery userQuery = new UserQuery();
		Criteria criteria = userQuery.createCriteria();
		criteria.andUserNameEqualTo("demo2");
		userDao.deleteByExample(userQuery);
		String name = "demo2";
		user.setUserName(name);
		user.setUserPassword(null);
		JsonResponse modifyUser = userController.modifyUser(user);
		Object data = modifyUser.getData();
		if (data instanceof User) {
			User user2 = (User) data;
			Assert.assertEquals("测试用户更新", user2, user);
		}
	}

	private void testGetUser(User user) throws Exception {
		Integer userId = user.getUserId();
		JsonResponse getUser = userController.getUser(userId);
		Object data = getUser.getData();
		if (data instanceof User) {
			User user2 = (User) data;
			Assert.assertNotNull("测试获取用户", user2);
		}
	}

	private void testQueryUsers() throws Exception {
		JsonResponse queryusers = userController.queryUsers(1, 10, null, null);
		Object data = queryusers.getData();
		Assert.assertNotNull("测试获取所有用户", data);
	}

	private void testRemoveUser(User user) throws Exception {
		Integer userId = user.getUserId();
		JsonResponse removeUser = userController.removeUser(userId);
		Object data = removeUser.getData();
		if (data instanceof String) {
			String str = (String) data;
			Assert.assertEquals("测试删除组织", "删除成功", str);
		}
	}
}