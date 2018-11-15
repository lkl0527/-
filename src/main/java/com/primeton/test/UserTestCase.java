package com.primeton.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.controller.UserController;
import com.primeton.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestCase {

	@Autowired
	private UserController userController;

	@Test
	public void testUser() throws Exception {
		User user = new User();
		user.setUserName("test_demo");
		user.setUserPassword("000000");
		user = userController.createUser(user);

		assertNotNull(user.getUserId());
		assertEquals(user.getUserPassword(), "000000");

		user.setUserPassword("123456");
		user = userController.modifyUser(user);
		assertEquals(user.getUserPassword(), "123456");

		assertNotNull(userController.removeUser(user.getUserId()));
		assertNull(userController.getUser(user.getUserId()));
	}

}