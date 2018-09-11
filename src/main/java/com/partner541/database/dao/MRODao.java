package com.partner541.database.dao;

import com.partner541.database.model.MROData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import sun.plugin2.message.Message;

import java.util.List;

@Mapper
public interface MRODao {
    @Select({"select ServingSector,InterferingSector,LteScRSRP,LteNcRSRP " +
        "from tbMROData where LteScRSRP - LteNcRSRP < 23"}) //
    List<MROData> getC2I();
}
