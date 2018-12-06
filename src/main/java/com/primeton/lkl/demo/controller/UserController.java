package com.primeton.lkl.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.primeton.lkl.demo.exception.DemoException;
import com.primeton.lkl.demo.exception.ErrorCode;
import com.primeton.lkl.demo.model.JsonResponse;
import com.primeton.lkl.demo.model.User;
import com.primeton.lkl.demo.model.UserAndNewPassword;
import com.primeton.lkl.demo.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户管理控制器
 * 
 * 提供用户的增删改查和用户的登录功能
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 *
 */
@RestController
@RequestMapping("/api/users")
@Api(value = "用户管理api", tags = "用户管理接口")
public class UserController {

	@Autowired
	private IUserService userService;

	/**
	 * 新增用户
	 * 
	 * @param user 添加的用户数据
	 * @return 用户信息
	 * @throws Exception 异常信息
	 * 
	 */
	@PostMapping
	@ApiOperation(value = "用户添加", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse createUser(@RequestBody @ApiParam("需要保存的用户信息") User user) throws Exception {
		userService.createUser(user);
		return new JsonResponse("添加成功");
	}

	/**
	 * 登出功能
	 *
	 * @param session 用户退出请求
	 * @return 退出成功
	 * @throws Exception 异常信息
	 * 
	 */
	@DeleteMapping(value = "actions/logout")
	@ApiOperation(value = "用户退出", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse logout(HttpSession session) {
		// 清除session中的所用信息
		session.invalidate();
		return new JsonResponse("退出成功");
	}

	/**
	 * 删除用户
	 * 
	 * @param userId 用户Id
	 * @return 删除成功
	 * @throws Exception 异常信息
	 * 
	 */
	@DeleteMapping(value = "/{userId}")
	@ApiOperation(value = "根据用户Id删除用户数据", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse removeUser(@PathVariable("userId") @ApiParam("userId") Integer userId) throws Exception {
		if (userService.removeUser(userId)) {
			return new JsonResponse("删除成功");
		}
		return null;
	}

	/**
	 * 修改用户
	 * 
	 * @param user 要修改的用户数据
	 * @return 用户信息
	 * @throws Exception 异常信息
	 * 
	 */
	@PutMapping(value = "/{userId}")
	@ApiOperation(value = "修改用户数据", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse modifyUser(@RequestBody @ApiParam("修改用户信息数据") User user) throws Exception {
		return new JsonResponse(userService.modifyUser(user));
	}

	/**
	 * 根据用户正确密码更改新密码
	 * 
	 * @param user 需要修改密码的用户数据
	 * @return 用户数据
	 * @throws Exception 异常信息
	 * 
	 */
	@PutMapping(value = "/actions/modify-password")
	@ApiOperation(value = "根据用户正确密码更改新密码", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse modifyPassword(@RequestBody @ApiParam("用户数据和需要更新的密码") UserAndNewPassword userPwd)
			throws Exception {
		return new JsonResponse(userService.modifyPassword(userPwd));
	}

	/**
	 * 登录功能
	 * 
	 * @param user 用户数据
	 * @param session 保存当前用户登录状态
	 * @return 用户数据
	 * @throws Exception 异常信息
	 * 
	 */
	@PostMapping(value = "actions/login")
	@ApiOperation(value = "用户登录", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse login(@RequestBody @ApiParam("登录的用户数据") User user, HttpSession session) throws Exception {
		User userExist = userService.login(user);
		if (userExist == null) {
			throw new DemoException(ErrorCode.USERNAME_PASSWORD_ERROR);
		}
		session.setAttribute("userId", userExist.getUserId());
		return new JsonResponse(userExist);
	}

	/**
	 * 根据用户Id获取用户数据
	 * 
	 * @param userId 需要获取用户的Id
	 * @return 用户信息
	 * @throws Exception 异常信息
	 * 
	 */
	@GetMapping(value = "/{userId}")
	@ApiOperation(value = "获取用户数据", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse getUser(@PathVariable("userId") @ApiParam("用户Id") Integer userId) throws Exception {
		return new JsonResponse(userService.getUser(userId));
	}

	/**
	 * 查询用户列表
	 * 
	 * @param pageNum 起始页数
	 * @param pageSize 每页显示条数
	 * @param userName 用户名
	 * @param orgaId 组织Id
	 * @return 用户列表
	 * @throws Exception 
	 * 
	 */
	@GetMapping
	@ApiOperation(value = "查询用户信息列表", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse queryUsers(@RequestParam(value = "pageNum", required = true) @ApiParam("起始页数") Integer pageNum,
			@RequestParam(value = "pageSize", required = true) @ApiParam("每页显示条数,为零查询所有，默认10") Integer pageSize,
			@RequestParam(value = "userName", required = false) @ApiParam("用户名,模糊查询") String userName,
			@RequestParam(value = "orgaId", required = false) @ApiParam("组织Id,精确查找") Integer orgaId) throws Exception {
		return new JsonResponse(userService.queryUsers(pageNum, pageSize, userName, orgaId));
	}

}