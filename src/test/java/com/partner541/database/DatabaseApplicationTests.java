package com.partner541.database;

import com.partner541.database.model.MROData;
import com.partner541.database.model.TbCell;
import com.partner541.database.service.C2Iservice;
import com.partner541.database.service.CellService;
import com.partner541.database.service.MROService;
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
	MROService mroService;

	@Autowired
	C2Iservice c2Iservice;

	@Test
	public void contextLoads() {
//		try {
//			cellService.exportListFromExcel();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		mroService.comC2I();
		//c2Iservice.re_tri(50);
	}

}
