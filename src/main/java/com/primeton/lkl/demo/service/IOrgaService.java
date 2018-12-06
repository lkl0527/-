package com.primeton.lkl.demo.service;

import java.util.List;
import java.util.Map;

import com.primeton.lkl.demo.model.Orga;

/**
 * 组织管理服务接口
 * 
 * 定义组织的增删改查等接口
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 * 
 */
public interface IOrgaService {

	/**
	 * 添加组织
	 * 
	 * @param orga 组织数据
	 * @return 添加结果
	 * @throws Exception 异常信息
	 * 
	 */
	Boolean createOrga(Orga orga) throws Exception;

	/**
	 * 删除组织
	 * 
	 * @param orgaId 组织Id
	 * @return 删除结果
	 * @throws Exception
	 * 
	 */
	Boolean removeOrga(Integer orgaId) throws Exception;

	/**
	 * 修改组织
	 * 
	 * @param orga 组织信息
	 * @return 修改之后组织信息
	 * @throws Exception 异常信息
	 * 
	 */
	Orga modifyUser(Orga orga) throws Exception;

	/**
	 * 查询所有组织
	 * 
	 * @return 组织集合
	 * @throws Exception 异常信息
	 * 
	 */
	List<Orga> queryOrgas() throws Exception;

	/**
	 * 根据orgaId获取组织
	 * 
	 * @param orgaId 组织Id
	 * @return 组织信息
	 * @throws Exception 异常信息
	 * 
	 */
	Orga getOrga(Integer orgaId) throws Exception;
	
	/**
	 * 根据获取所有组织数据
	 * @return
	 */
	List<Map<String, Object>> getOrgasWithNested();


}