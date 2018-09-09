package com.partner541.database;

import com.partner541.database.model.TbCell;
import com.partner541.database.service.CellService;
import com.partner541.database.service.ZuoYaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseApplicationTests {

	@Autowired
	CellService cellService;

	@Test
	public void contextLoads() {
//		try {
//			cellService.exportListFromExcel();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		List<Object> list = ZuoYaoService.readExcel("G:\\大四上作业\\数据库系统原理课程设计\\数据库系统原理课程设计-18\\三门峡地区TD-LTE网络数据-2017-03\\表13 优化区17日-19日每PRB干扰 查询-15分钟.xlsx");
		for(Object obj : list) {
			System.out.println(obj.toString());
		}
	}

}
