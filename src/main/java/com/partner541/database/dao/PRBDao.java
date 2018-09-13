package com.partner541.database.dao;

import com.partner541.database.model.PRB;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PRBDao {
    String INSERT_FIELDS = " START_TIME, CYCLE, NE_NAME, SECTOR, SECTOR_NAME, P0, P1, P2, P3, P4, P5, P6, P7, P8, " +
            "P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25, P26, P27, P28, P29, " +
            "P30, P31, P32, P33, P34, P35, P36, P37, P38, P39, P40, P41, P42, P43, P44, P45, P46, P47, P48, P49, P50, " +
            "P51, P52, P53, P54, P55, P56, P57, P58, P59, P60, P61, P62, P63, P64, P65, P66, P67, P68, P69, P70, P71, " +
            "P72, P73, P74, P75, P76, P77, P78, P79, P80, P81, P82, P83, P84, P85, P86, P87, P88, P89, P90, P91, P92, " +
            "P93, P94, P95, P96, P97, P98, P99 ";

    String INSERT_VALUES = " #{STARTTIME}, #{CYCLE}, #{NENAME}, #{SECTOR}, #{SECTORNAME}, #{P0}, #{P1}, #{P2}, #{P3}, #{P4}, #{P5}, #{P6}, #{P7}, #{P8}, " +
            "#{P9}, #{P10}, #{P11}, #{P12}, #{P13}, #{P14}, #{P15}, #{P16}, #{P17}, #{P18}, #{P19}, #{P20}, #{P21}, #{P22}, #{P23}, #{P24}, #{P25}, #{P26}, #{P27}, #{P28}, #{P29}, " +
            "#{P30}, #{P31}, #{P32}, #{P33}, #{P34}, #{P35}, #{P36}, #{P37}, #{P38}, #{P39}, #{P40}, #{P41}, #{P42}, #{P43}, #{P44}, #{P45}, #{P46}, #{P47}, #{P48}, #{P49}, #{P50}, " +
            "#{P51}, #{P52}, #{P53}, #{P54}, #{P55}, #{P56}, #{P57}, #{P58}, #{P59}, #{P60}, #{P61}, #{P62}, #{P63}, #{P64}, #{P65}, #{P66}, #{P67}, #{P68}, #{P69}, #{P70}, #{P71}, " +
            "#{P72}, #{P73}, #{P74}, #{P75}, #{P76}, #{P77}, #{P78}, #{P79}, #{P80}, #{P81}, #{P82}, #{P83}, #{P84}, #{P85}, #{P86}, #{P87}, #{P88}, #{P89}, #{P90}, #{P91}, #{P92}, " +
            "#{P93}, #{P94}, #{P95}, #{P96}, #{P97}, #{P98}, #{P99} ";

    @Insert({"insert into tbPRB ( ", INSERT_FIELDS, " ) values ( ", INSERT_VALUES, " )"})
    int insertPRB(PRB prb);

    @Insert({"insert into tbPRBnew ( ", INSERT_FIELDS, " ,ave ) values ( ", INSERT_VALUES, " ,#{ave} )"})
    int insertPRBnew(PRB prb);

    @Delete({"delete from tbPRB"})
    int deletePRB();

    @Select("select * from tbPRB")
    List<PRB> getPRB();
}
