package com.partner541.database.dao;

import com.partner541.database.model.Cell;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CellDao {

    String SELECT_FIELDS = " CITY, SECTOR_ID, SECTOR_NAME, ENODEBID, ENODEB_NAME, EARFCN, " +
            "PCI, PSS, SSS, TAC, VENDOR, LONGITUDE, LATITUDE, STYLE, AZIMUTH, HEIGHT, ELECTTILT, " +
            "MECHTILT, TOTLETILT ";

    @Insert({"insert into tbCell (CITY, SECTOR_ID, SECTOR_NAME, ENODEBID, ENODEB_NAME, EARFCN, " +
            "PCI, PSS, SSS, TAC, VENDOR, LONGITUDE, LATITUDE, STYLE, AZIMUTH, HEIGHT, ELECTTILT, " +
            "MECHTILT, TOTLETILT) " +
            "values(#{CITY}, #{SECTORID}, #{SECTORNAME}, #{ENODEBID}, #{ENODEBNAME}, " +
            "#{EARFCN}, #{PCI}, #{PSS}, #{SSS}, #{TAC}, #{VENDOR}, #{LONGITUDE}, #{LATITUDE}, #{STYLE}, " +
            "#{AZIMUTH}, #{HEIGHT}, #{ELECTTILT}, #{MECHTILT}, #{TOTLETILT})"})
    int insertCell(Cell cell);

    @Delete({"delete from tbCell"})
    int deleteCell();

    @Select({"select ", SELECT_FIELDS, " from tbCell" })
    List<Cell> selectCellAll();

    @Select("select * from tbCell where SECTOR_ID = '1246720'")
    List<Cell> select();
}
