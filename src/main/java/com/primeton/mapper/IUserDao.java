package com.primeton.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.primeton.pojo.User;

@Mapper
@Repository
public interface IUserDao {

	// 用户登录功能
	public User login(@Param("userName") String userName, @Param("userPassword") String userPassword);

	// 根据名字查询
	public User getUserByName(String name);

	// 新增用户
	int insertUser(User user);

	// 新增用户
	int insertSelective(User user);

	// 根据主键删除
	int deleteByPrimaryKey(Integer userId);

	// 根据用户id查询
	User getUserById(Integer userId);
	
	//根据id更新用户信息
	int updateUser(User user);
	
	
}