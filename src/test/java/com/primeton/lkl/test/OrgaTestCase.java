package com.primeton.lkl.test;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.primeton.lkl.demo.LiKangLinDemoTestCase;
import com.primeton.lkl.demo.controller.OrgaController;
import com.primeton.lkl.demo.model.JsonResponse;
import com.primeton.lkl.demo.model.Orga;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LiKangLinDemoTestCase.class)
public class OrgaTestCase {

	@Autowired
	private OrgaController orgaController;

	@Test
	public void testOrga() throws Exception {

		Orga orga = new Orga();
		orga.setOrgaName(UUID.randomUUID().toString());

		// 创建组织
		testCreateOrga(orga);
		// 修改组织
		testModifyOrga(orga);
		// 获取组织
		testGetOrga(orga);
		// 删除组织
		testRemoveOrga(orga);

	}

	private void testCreateOrga(Orga orga) throws Exception {
		JsonResponse createOrga = orgaController.createOrga(orga);
		Object data = createOrga.getData();
		if (data instanceof Orga) {
			Orga orga2 = (Orga) data;
			Assert.assertNotNull("测试创建组织", orga2);
		}
	}

	private void testModifyOrga(Orga orga) throws Exception {
		String name = UUID.randomUUID().toString();
		orga.setOrgaName(name);
		JsonResponse modifyorga = orgaController.modifyOrga(orga);
		Object data = modifyorga.getData();
		if (data instanceof Orga) {
			Orga orga2 = (Orga) data;
			Assert.assertEquals("测试组织更新", orga2, orga);
		}
	}

	private void testGetOrga(Orga orga) throws Exception {
		Integer orgaId = orga.getOrgaId();
		JsonResponse getOrga = orgaController.getOrga(orgaId);
		Object data = getOrga.getData();
		if (data instanceof Orga) {
			Orga orga2 = (Orga) data;
			Assert.assertNotNull("测试获取组织", orga2);
		}
	}

	private void testRemoveOrga(Orga orga) throws Exception {
		Integer orgaId = orga.getOrgaId();
		JsonResponse removeOrga = orgaController.removeOrga(orgaId);
		Object data = removeOrga.getData();
		if (data instanceof String) {
			String str = (String) data;
			Assert.assertEquals("测试删除组织", "删除成功", str);
		}
	}

}