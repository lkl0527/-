package com.primeton.lkl.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.primeton.lkl.demo.model.JsonResponse;
import com.primeton.lkl.demo.model.Orga;
import com.primeton.lkl.demo.service.IOrgaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 组织管理控制器
 * 
 * 提供组织的增删改查等接口
 * 
 * @author 李康林
 * @version 1.0
 * @date 2018.11.26
 * 
 */
@RestController
@RequestMapping("/api/orgas")
@Api(value = "组织管理api", tags = "组织管理接口")
public class OrgaController {

	@Autowired
	private IOrgaService orgaService;

	/**
	 * 添加组织
	 * 
	 * @param orga 需要添加组织的信息
	 * @return 保存信息
	 * @throws Exception 抛出异常
	 * 
	 */
	@PostMapping
	@ApiOperation(value = "添加组织", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse createOrga(@RequestBody @ApiParam("需要添加组织数据") Orga orga) throws Exception {
		if (orgaService.createOrga(orga)) {
			return new JsonResponse("保存成功");
		}
		return null;
	}

	/**
	 * 删除组织
	 * 
	 * @param orgaId 组织Id
	 * @return 删除信息
	 * @throws Exception 抛出异常
	 * 
	 */
	@DeleteMapping(value = "/{orgaId}")
	@ApiOperation(value = "根据组织Id删除", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse removeOrga(@PathVariable("orgaId") @ApiParam("组织Id") Integer orgaId) throws Exception {
		if (orgaService.removeOrga(orgaId)) {
			return new JsonResponse("删除成功");
		}
		return null;
	}

	/**
	 * 修改组织
	 * 
	 * @param orga 组织信息
	 * @return 修改之后的组织信息
	 * @throws Exception 抛出异常
	 * 
	 */
	@PutMapping(value = "/{orgaId}")
	@ApiOperation(value = "根据组织Id更新组织字段", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse modifyOrga(@RequestBody @ApiParam("修改组织信息数据") Orga orga) throws Exception {
		return new JsonResponse(orgaService.modifyUser(orga));
	}

	/**
	 * 获取组织
	 * 
	 * @param orgaId 组织Id
	 * @return 组织信息
	 * @throws Exception 抛出异常
	 * 
	 */
	@GetMapping(value = "/{orgaId}")
	@ApiOperation(value = "根据组织Id查询组织数据", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse getOrga(@PathVariable("orgaId") @ApiParam("组织Id") Integer orgaId) throws Exception {
		return new JsonResponse(orgaService.getOrga(orgaId));
	}

	/**
	 * 查询所有组织信息
	 * 
	 * @return 组织信息集合
	 * @throws Exception 抛出异常
	 * 
	 */
	@GetMapping
	@ApiOperation(value = "查询所有组织信息", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse queryOrgas() throws Exception {
		return new JsonResponse(orgaService.queryOrgas());
	}

	/**
	 * 递归查询所有组织信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/actions/nested")
	@ApiOperation(value = "递归查询所有组织信息", response = JsonResponse.class)
	@ResponseBody
	public JsonResponse queryOrgasNested() throws Exception {
		return new JsonResponse(orgaService.getOrgasWithNested());
	}
}
