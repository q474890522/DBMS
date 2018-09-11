package com.partner541.database.dao;

import com.partner541.database.model.C2Inew;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface C2InewDao {

    @Insert("insert into tbC2Inew values(#{SCELL},#{NCELL},#{C2I_Mean},#{std},#{Prb9},#{PrbABS6})")
    void addC2Inew(C2Inew c2Inew);

    @Select("select * from tbC2Inew")
    List<C2Inew> getC2Inew();

}
