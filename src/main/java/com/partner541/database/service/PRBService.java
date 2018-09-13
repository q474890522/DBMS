package com.partner541.database.service;

import com.partner541.database.dao.PRBDao;
import com.partner541.database.utils.ImportExcelBig;
import com.partner541.database.utils.StaticFinalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PRBService {
    @Autowired
    ImportExcelBig importExcelBig;

    @Autowired
    PRBDao prbDao;

    private Logger logger = LoggerFactory.getLogger(CellService.class);

    /**
     * 导入数据到PRB表
     * @param file 上传的文件
     * @return
     */
    public boolean importPRB(MultipartFile file) {
        try {
            StaticFinalUtil.checkExcelVaild(file);
        } catch (Exception e) {
            logger.error("该文件不是Excel");
            return false;
        }
        int succCount = 0;
        try {
            succCount = importExcelBig.readOneSheet(file.getInputStream());
        } catch (Exception e) {
            logger.error("导入PRB Excel失败");
            return false;
        }
        return true;
    }

    public int cleanPRB() {
        return prbDao.deletePRB();
    }
}
