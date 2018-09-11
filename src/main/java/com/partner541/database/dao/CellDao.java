package com.partner541.database.dao;

import com.partner541.database.model.Cell;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CellDao {

    @Insert({"insert into tbCell (CITY, SECTOR_ID, SECTOR_NAME, ENODEBID, ENODEB_NAME, EARFCN, " +
            "PCI, PSS, SSS, TAC, VENDOR, LONGITUDE, LATITUDE, STYLE, AZIMUTH, HEIGHT, ELECTTILT, " +
            "MECHTILT, TOTLETILT) " +
            "values(#{CITY}, #{SECTOR_ID}, #{SECTOR_NAME}, #{ENODEBID}, #{ENODEB_NAME}, " +
            "#{EARFCN}, #{PCI}, #{PSS}, #{SSS}, #{TAC}, #{VENDOR}, #{LONGITUDE}, #{LATITUDE}, #{STYLE}, " +
            "#{AZIMUTH}, #{HEIGHT}, #{ELECTTILT}, #{MECHTILT}, #{TOTLETILT})"})
    int insertCell(Cell cell);

    @Delete({"delete from tbCell"})
    int deleteCell();
}
