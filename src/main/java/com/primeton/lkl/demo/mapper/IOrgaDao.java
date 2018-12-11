package com.primeton.lkl.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.primeton.lkl.demo.model.Orga;
import com.primeton.lkl.demo.model.OrgaQuery;

/**
 * 组织管理dao接口
 * 
 * 组织的增删改查等接口
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 * 
 */
@Mapper
@Repository
public interface IOrgaDao {

	/**
	 * 新增组织
	 * 
	 * @param record 组织数据
	 * @return 添加行数
	 * 
	 */
	int insertSelective(Orga record);

	/**
	 * 删除组织
	 * 
	 * @param orgaId 组织Id
	 * @return
	 */
	int deleteByPrimaryKey(Integer orgaId);

	/**
	 * 修改组织
	 * 
	 * @param orga 组织信息
	 * @return 修改之后组织信息
	 * 
	 */
	int updateByPrimaryKeySelective(Orga record);

	/**
	 * 查询所有组织
	 * 
	 * @param example
	 * @return 组织数据
	 */
	List<Orga> selectByExample(OrgaQuery example);

	/**
	 * 根据orgaId获取组织
	 * 
	 * @param orgaId 组织Id
	 * @return 组织信息
	 * 
	 */
	Orga getOrga(@Param(value = "orgaId") Integer orgaId);

	/**
	 * 获取所有父节点组织
	 * 
	 * @return 父节点组织集合
	 * 
	 */
	List<Orga> getParentOrga();

	/**
	 * 根据父节点组织Id获取子组织信息
	 * 
	 * @param orgaParent 组织父节点Id
	 * @return 组织信息
	 * 
	 */
	List<Orga> getChildrenOrga(Integer orgaParent);

	/**
	 * 查询组织下的组织
	 * 
	 * @param orgaId 组织Id
	 * @return
	 */
	int selectOrgaNotOrgas(Integer orgaId);

	/**
	 * 查询组织下是否有用户
	 * 
	 * @param orgaId 组织Id
	 * @return
	 */
	int selectOrgaNotUsers(Integer orgaId);

}