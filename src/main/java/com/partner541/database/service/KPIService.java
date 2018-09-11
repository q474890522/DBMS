package com.partner541.database.service;

import com.partner541.database.dao.KPIDao;
import com.partner541.database.utils.ImportExcelSmall;
import com.partner541.database.utils.StaticFinalUtil;
import com.partner541.database.utils.TableType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class KPIService {
    @Autowired
    ImportExcelSmall importExcelSmall;

    @Autowired
    KPIDao kpiDao;

    private Logger logger = LoggerFactory.getLogger(CellService.class);

    /**
     * 导入数据到KPI表
     * @param file 上传的文件
     * @return
     */
    public boolean importTbKPI(MultipartFile file) {
        try {
            StaticFinalUtil.checkExcelVaild(file);
        } catch (Exception e) {
            logger.error("该文件不是Excel");
            return false;
        }
        int succCount = 0;
        try {
            succCount = importExcelSmall.exportListFromExcel(TableType.KPI.getValue(), file);
        } catch (Exception e) {
            logger.error("导入KPI Excel时失败");
            return false;
        }
        return true;
    }

    /**
     * 清空KPI表
     * @return 清空几条数据
     */
    public int cleanTbKPI() {
        return kpiDao.deleteKPI();
    }
}
