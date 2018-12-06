package com.primeton.lkl.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.primeton.lkl.demo.model.User;
import com.primeton.lkl.demo.model.UserQuery;

/**
 * 用户管理dao接口
 * 
 * 用户的增删改查和用户的登录接口
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 *
 */
@Mapper
@Repository
public interface IUserDao {
	/**
	 * 新增用户
	 * 
	 * @param user 用户信息
	 * @return 增加条数
	 * 
	 */
	int insertSelectiveAndGetKey(User user);

	/**
	 * 删除用户
	 * 
	 * @param userId 用户Id
	 * @return 删除条数
	 * 
	 */
	int deleteUserById(@Param(value = "userId") Integer userId);

	/**
	 * 修改用户
	 * 
	 * @param user 用户信息
	 * @return 更改条数
	 * 
	 */
	int modifyUser(User user);

	/**
	 * 登录功能
	 * 
	 * @param userName 用户名
	 * @param userPassword 用户密码
	 * @return 用户信息
	 * 
	 */
	public User login(@Param(value = "userName") String userName, @Param(value = "userPassword") String userPassword);

	/**
	 * 根据userId查询返回用户
	 * 
	 * @param userId 用户Id
	 * @return 用户信息
	 * 
	 */
	User getUserById(@Param(value = "userId") Integer userId);

	/**
	 * 根据userName查询返回用户
	 * 
	 * @param userName 用户名
	 * @return 用户信息
	 * 
	 */
	User getUserByName(@Param(value = "userName") String userName);

	/**
	 * 查询用户列表
	 * 
	 * @param userName 用户名
	 * @param orgaId 组织Id
	 * @return 用户数据
	 */
	List<User> queryUsers(@Param("userName") String userName, @Param("orgaId") Integer orgaId);
	
	/**
	 * 根据组织Id查询用户
	 * 
	 * @param userName
	 * @param orgaId
	 * @return
	 */
	List<User> selectOrgaUsers(@Param("userName") String userName, @Param("orgaId") Integer orgaId);

	int countByExample(UserQuery example);

	int deleteByExample(UserQuery example);

	int deleteByPrimaryKey(Integer userId);

	int insert(User record);

	User selectByPrimaryKey(Integer userId);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserQuery example);

	int updateByExample(@Param("record") User record, @Param("example") UserQuery example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

}