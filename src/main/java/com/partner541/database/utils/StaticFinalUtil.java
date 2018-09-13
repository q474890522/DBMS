package com.partner541.database.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class StaticFinalUtil {
    public static final String EXCEL_XLS = "xls";
    public static final String EXCEL_XLSX = "xlsx";

    //判断文件是否是excel
    public static boolean checkExcelVaild(MultipartFile file) throws Exception {
        if (!(file.getOriginalFilename().endsWith(EXCEL_XLS) || file.getOriginalFilename().endsWith(EXCEL_XLSX))) {
            throw new Exception("文件不是Excel");
        }
        return true;
    }
}
