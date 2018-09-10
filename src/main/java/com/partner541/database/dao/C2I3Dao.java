package com.partner541.database.dao;

import com.partner541.database.model.C2I3;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface C2I3Dao {
    @Insert("insert into tbC2I3 values (#{CELLa},#{CELLb},#{CELLc})")
    void addC2I3(C2I3 c2I3);

    @Delete("delete from tbC2I3")
    void deleteC2I3();
}
