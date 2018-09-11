package com.partner541.database.service;

import com.partner541.database.dao.CellDao;
import com.partner541.database.utils.ImportExcelSmall;
import com.partner541.database.utils.StaticFinalUtil;
import com.partner541.database.utils.TableType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CellService {
    @Autowired
    ImportExcelSmall importExcelSmall;

    @Autowired
    CellDao cellDao;

    private Logger logger = LoggerFactory.getLogger(CellService.class);

    /**
     * 导tbCell表
     * @param file 上传的文件
     * @return
     */
    public boolean importTbCell(MultipartFile file) {
        try {
            StaticFinalUtil.checkExcelVaild(file);
        } catch (Exception e) {
            logger.error("该文件不是Excel");
            return false;
        }
        int succCount = 0;
        try {
            succCount = importExcelSmall.exportListFromExcel(TableType.Cell.getValue(), file);
        } catch (Exception e) {
            logger.error("导入Cell Excel时失败");
            return false;
        }
        return true;
    }

    /**
     * 清空tbCell
     * @return 清空多少条数据
     */
    public int cleanTbCell() {
        return cellDao.deleteCell();
    }
}
