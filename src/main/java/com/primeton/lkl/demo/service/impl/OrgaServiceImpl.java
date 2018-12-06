package com.primeton.lkl.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.primeton.lkl.demo.exception.DemoException;
import com.primeton.lkl.demo.exception.ErrorCode;
import com.primeton.lkl.demo.mapper.IOrgaDao;
import com.primeton.lkl.demo.model.Orga;
import com.primeton.lkl.demo.model.OrgaQuery;
import com.primeton.lkl.demo.model.OrgaQuery.Criteria;
import com.primeton.lkl.demo.service.IOrgaService;
import com.primeton.lkl.demo.transactional.Transactional;
import com.primeton.lkl.demo.utils.ValidateUtil;

/**
 * 组织管理服务接口实现类
 * 
 * 实现组织的增删改查等接口
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 * 
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrgaServiceImpl implements IOrgaService {

	@Autowired
	private IOrgaDao orgaDao;

	/**
	 * 添加组织
	 * 
	 * @param orga 组织数据
	 * @return 添加结果
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public Boolean createOrga(Orga orga) throws Exception {
		// 组织名为空抛异常
		ValidateUtil.paramIsNotEmpty(orga.getOrgaName(), ErrorCode.ORGANAME_IS_NULL);
		// 组织名重复抛异常
		orgaNameIsExist(orga);
		// 插入数据
		if (orgaDao.insertSelective(orga) > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 删除组织
	 * 
	 * @param orgaId 组织Id
	 * @return 删除结果
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public Boolean removeOrga(Integer orgaId) throws Exception {
		// 组织Id为空抛异常
		ValidateUtil.paramIsNotEmpty(orgaId, ErrorCode.ORGAID_IS_NULL);
		// 判断组织下是否有组织
		if (orgaDao.selectOrgaNotOrgas(orgaId) != 1) {
			throw new DemoException(ErrorCode.ORGA_NOT_NULL);
		}
		// 组织下有用户抛异常
		if (orgaDao.selectOrgaNotUsers(orgaId) != 0) {
			throw new DemoException(ErrorCode.ORGA_USER_NOT_NULL);
		}
		// 根据orgaId删除组织信息
		if (orgaDao.deleteByPrimaryKey(orgaId) == 1) {
			return true;
		}
		return false;
	}

	/**
	 * 修改组织
	 * 
	 * @param orga 组织信息
	 * @return 修改之后组织信息
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public Orga modifyUser(Orga orga) throws Exception {
		// 组织Id为空抛异常
		ValidateUtil.paramIsNotEmpty(orga.getOrgaId(), ErrorCode.ORGAID_IS_NULL);
		// 组织名为空抛异常
		ValidateUtil.paramIsNotEmpty(orga.getOrgaName(), ErrorCode.ORGANAME_IS_NULL);
		// 组织名重复抛异常
		orgaNameIsExist(orga);
		// 根据orgaId更新其他字段
		orgaDao.updateByPrimaryKeySelective(orga);
		// 根据orgaId查询组织信息
		return orgaDao.getOrga(orga.getOrgaId());
	}

	/**
	 * 查询所有组织
	 * 
	 * @return 组织集合
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public List<Orga> queryOrgas() {
		// 创建查询对象
		OrgaQuery orgaQuery = new OrgaQuery();
		// 无条件查询
		List<Orga> orgaList = orgaDao.selectByExample(orgaQuery);
		// 返回组织集合
		return orgaList;
	}

	/**
	 * 根据orgaId获取组织
	 * 
	 * @param orgaId 组织Id
	 * @return 组织信息
	 * @throws Exception 异常信息
	 * 
	 */
	@Override
	public Orga getOrga(Integer orgaId) throws Exception {
		// 传入的组织Id为空
		ValidateUtil.paramIsNotEmpty(orgaId, ErrorCode.ORGAID_IS_NULL);
		// 根据orgaId查询用户
		return orgaDao.getOrga(orgaId);
	}

	/**
	 * 判断组织名是否重复
	 * 
	 * @param orga 组织数据
	 * @throws Exception 异常信息
	 * 
	 */
	private void orgaNameIsExist(Orga orga) throws Exception {
		// 创建查询对象
		OrgaQuery orgaQuery = new OrgaQuery();
		Criteria criteria = orgaQuery.createCriteria();
		// 传入需要匹配的参数
		criteria.andOrgaNameEqualTo(orga.getOrgaName());
		// 执行查询
		List<Orga> orgaList = orgaDao.selectByExample(orgaQuery);
		// 如果orgaName不存在,那么可以插入数据
		if (orgaList.size() != 0) {
			throw new DemoException(ErrorCode.ORGANAME_IS_SAME);
		}
	}

	/**
	 * 递归查询所有的组织结构
	 */
	public List<Map<String, Object>> getOrgasWithNested() {
		// 定义最外层的数组存的是对象,以键值对的形式存储
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 调用dao查询所有的父节点
		List<Orga> parent = this.orgaDao.getParentOrga();
		// 循环每一个父节点
		for (int i = 0; i < parent.size(); i++) {
			// 创建map,用来存储children
			Map<String, Object> map = new HashMap<String, Object>();
			// 调用递归将顶级节点的子节点放入children中
			List<Map<String, Object>> children = this.fillChildren(parent.get(i));
			// 键是orga值是顶级节点对象
			map.put("orga", parent.get(i));
			// 键是children,值是2级节点数据
			map.put("children", children);
			// 将顶级节点存入list集合
			list.add(map);
		}
		return list;
	}

	/**
	 * 填充一个节点的子节点
	 * 
	 * @param orga 组织Id
	 * @return 返回填充好的子节点列表
	 * 
	 */
	private List<Map<String, Object>> fillChildren(Orga orga) {
		// 调用根据父节点查询子节点的方法,将查出来的每一个对象存入list集合
		List<Orga> children = this.orgaDao.getChildrenOrga(orga.getOrgaId());
		// 创建一个数组,存储map集合
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 遍历每一个子节点
		for (int i = 0; i < children.size(); i++) {
			// 创建map集合,用来存子节点和孙节点
			Map<String, Object> map = new HashMap<String, Object>();
			// 拿到每一个子节点
			Orga child = children.get(i);
			// 调用自己,将自己传进去,将查出来的数据,按照键值对的形式存入map集合
			List<Map<String, Object>> nodes = this.fillChildren(child);
			map.put("orga", child);
			map.put("children", nodes);
			// 最后将一个子节点存入
			list.add(map);
		}
		// 返回这个list
		return list;
	}

}
