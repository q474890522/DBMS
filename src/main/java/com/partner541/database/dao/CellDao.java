package com.partner541.database.dao;

import com.partner541.database.model.Cell;
import org.apache.ibatis.annotations.*;

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
    int insertCell(@Param("list") Cell cell);

    void insertCellBatch(List<Cell> list);

    @Delete({"delete from tbCell"})
    int deleteCell();

    @Select({"select ", SELECT_FIELDS, " from tbCell" })
    List<Cell> selectCellAll();

    @Select("select * from tbCell where SECTOR_ID = #{sectorId} and SECTOR_NAME = #{sectorName} and ENODEB_ID = #{enodebId} and ENODEB_NAME = #{enodebName}")
    List<Cell> selectCellByIdNameIdName(@Param("sectorId") String sectorId, @Param("sectorName") String sectorName,
                                        @Param("enodebId") int enodebId, @Param("enodebName") String enodebName);

    @Select("select * from tbCell where SECTOR_NAME = #{sectorName} and ENODEB_ID = #{enodebId} and ENODEB_NAME = #{enodebName}")
    List<Cell> selectCellByNameIdName(@Param("sectorName") String sectorName, @Param("enodebId") int enodebId, @Param("enodebName") String enodebName);

    @Select("select * from tbCell where SECTOR_ID = #{sectorId} and ENODEB_ID = #{enodebId} and ENODEB_NAME = #{enodebName}")
    List<Cell> selectCellByIdIdName(@Param("sectorId") String sectorId, @Param("enodebId") int enodebId, @Param("enodebName") String enodebName);

    @Select("select * from tbCell where SECTOR_ID = #{sectorId} and SECTOR_NAME = #{sectorName} and ENODEB_NAME = #{enodebName}")
    List<Cell> selectCellByIdNameName(@Param("sectorId") String sectorId, @Param("sectorName") String sectorName, @Param("enodebName") String enodebName);

    @Select("select * from tbCell where SECTOR_ID = #{sectorId} and SECTOR_NAME = #{sectorName} and ENODEB_ID = #{enodebId}")
    List<Cell> selectCellByIdNameId(@Param("sectorId") String sectorId, @Param("sectorName") String sectorName, @Param("enodebId") int enodebId);

    @Select("select * from tbCell where ENODEB_ID = #{enodebId} and ENODEB_NAME = #{enodebName}")
    List<Cell> selectCellByIdNameBack(@Param("enodebId") int enodebId, @Param("enodebName") String enodebName);

    @Select("select * from tbCell where SECTOR_ID = #{sectorId} and SECTOR_NAME = #{sectorName}")
    List<Cell> selectCellByIdNameFront(@Param("sectorId") String sectorId, @Param("sectorName") String sectorName);

    @Select("select * from tbCell where SECTOR_NAME = #{sectorName} and ENODEB_NAME = #{enodebName}")
    List<Cell> selectCellByNameName(@Param("sectorName") String sectorName, @Param("enodebName") String enodebName);

    @Select("select * from tbCell where SECTOR_ID = #{sectorId} and ENODEB_ID = #{enodebId}")
    List<Cell> selectCellByIdId(@Param("sectorId") String sectorId,
                                        @Param("enodebId") int enodebId);
    @Select("select * from tbCell where SECTOR_ID = #{sectorId} and ENODEB_NAME = #{enodebName}")
    List<Cell> selectCellByIdName(@Param("sectorId") String sectorId, @Param("enodebName") String enodebName);

    @Select("select * from tbCell where SECTOR_NAME = #{sectorName} and ENODEB_ID = #{enodebId}")
    List<Cell> selectCellByNameId( @Param("sectorName") String sectorName,
                                        @Param("enodebId") int enodebId);

    @Select("select * from tbCell where SECTOR_ID = #{sectorId}")
    List<Cell> selectCellByIdFront(@Param("sectorId") String sectorId);

    @Select("select * from tbCell where SECTOR_NAME = #{sectorName}")
    List<Cell> selectCellByNameFront(@Param("sectorName") String sectorName);

    @Select("select * from tbCell where ENODEB_ID = #{enodebId}")
    List<Cell> selectCellByIdBack(@Param("enodebId") int enodebId);

    @Select("select * from tbCell where ENODEB_NAME = #{enodebName}")
    List<Cell> selectCellByNameBack(@Param("enodebName") String enodebName);

}
