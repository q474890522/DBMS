package com.partner541.database.dao;

import com.partner541.database.model.Cell;
import com.partner541.database.model.KPI;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface KPIDao {
    String INSERT_FIELDS = " START_TIME, CYCLE, NE_NAME, SECTOR, SECTOR_NAME, RRC_CONNECT_COMPLETE_TIME, RRC_CONNECT_REQUEST_TIME, " +
            "RRC_SET_SUCC_RATE, ERAB_SET_SUCCESS_TIME, ERAB_TRY_CONNECT_TIME, ERAB_SET_SUCCESS_TWO, eNodeB_TRYGGER_EXCEP_RELE_TIME, " +
            "SECTOR_SWITCH_ERAB_EXCEP_RELE_TIME, ERAB_DROP_RATE, WIRELESS_CONN_RATE, eNodeB_INIT_S1, UE_Context_EXCEP_RELE_TIME, " +
            "UE_Context_SET_SUCCESS_TIME, WIRELESS_DROP_RATE, eNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME, eNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME, " +
            "eNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME, eNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME, eNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME, " +
            "eNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME, eNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME, eNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME, " +
            "eNB_IN_SWITCH_SUCC_RATE, eNB_BETWEEN_SWITCH_SUCC_RATE, SAME_FREQ_SWITCH_SUCC_ZSP, DIFF_FREQ_SWITCH_SUCC_ZSP, SWITCH_SUCC_RATE, " +
            "SECTOR_DPCP_RECV_UP_DATE_THROUGHPUT, SECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT, RPC_RESET_REQUEST_TIME, RPC_CONN_RESET_RATE, " +
            "TO_ONE, TO_TWO, TO_THREE, TO_FOUR, eNB_IN_SWITCH_SUCC_TIME, eNB_IN_SWITCH_REQUEST_TIME ";

    String VALUES_FIELDS = " #{STARTTIME}, #{CYCLE}, #{NENAME}, #{SECTOR}, #{SECTORNAME}, #{RRCCONNECTCOMPLETETIME}, #{RRCCONNECTREQUESTTIME}, " +
            "#{RRCSETSUCCRATE}, #{ERABSETSUCCESSTIME}, #{ERABTRYCONNECTTIME}, #{ERABSETSUCCESSTWO}, #{eNodeBTRYGGEREXCEPRELETIME}, " +
            "#{SECTORSWITCHERABEXCEPRELETIME}, #{ERABDROPRATE}, #{WIRELESSCONNRATE}, #{eNodeBINITS1}, #{UEContextEXCEPRELETIME}, " +
            "#{UEContextSETSUCCESSTIME}, #{WIRELESSDROPRATE}, #{eNodeBINDIFFFREQSWITCHSUCCTIME}, #{eNodeBINDIFFFREQSWITCHTRYTIME}, " +
            "#{eNodeBINSAMEFREQSWITCHSUCCTIME}, #{eNodeBINSAMEFREQSWITCHTRYTIME}, #{eNodeBBETWEENDIFFFREQSWITCHSUCCTIME}, " +
            "#{eNodeBBETWEENDIFFFREQSWITCHTRYTIME}, #{eNodeBBETWEENSAMEFREQSWITCHSUCCTIME}, #{eNodeBBETWEENSAMEFREQSWITCHTRYTIME}, " +
            "#{eNBINSWITCHSUCCRATE}, #{eNBBETWEENSWITCHSUCCRATE}, #{SAMEFREQSWITCHSUCCZSP}, #{DIFFFREQSWITCHSUCCZSP}, #{SWITCHSUCCRATE}, " +
            "#{SECTORDPCPRECVUPDATETHROUGHPUT}, #{SECTORDPCPRECVDOWNDATETHROUGHPUT}, #{RPCRESETREQUESTTIME}, #{RPCCONNRESETRATE}, " +
            "#{TOONE}, #{TOTWO}, #{TOTHREE}, #{TOFOUR}, #{eNBINSWITCHSUCCTIME}, #{eNBINSWITCHREQUESTTIME} ";
    @Insert({"insert into tbKPI (", INSERT_FIELDS, ") values( ", VALUES_FIELDS, " )"})
    int insertKPI(KPI kpi);

    void insertKPIBatch(List<KPI> list);

    @Delete({"delete from tbKPI"})
    int deleteKPI();

    @Select({"select * from tbKPI"})
    List<KPI> selectKPIAll();

    @Select("select START_TIME from tbKPI") //1
    List<Date> selectSTART_TIME();

    @Select("select CYCLE from tbKPI") //2
    List<Integer> selectCYCLE();

    @Select("select NE_NAME from tbKPI")//3
    List<String> selectNE_NAME();

    @Select("select SECTOR from tbKPI")//4
    List<String> selectSECTOR();

    @Select("select SECTOR_NAME from tbKPI")//5
    List<String> selectSECTOR_NAME();

    @Select("select RRC_CONNECT_COMPLETE_TIME from tbKPI")//6
    List<Integer> selectRRC_CONNECT_COMPLETE_TIME();

    @Select("select RRC_CONNECT_REQUEST_TIME from tbKPI")//7
    List<Integer> selectRRC_CONNECT_REQUEST_TIME();

    @Select("select RRC_SET_SUCC_RATE from tbKPI")//8
    List<Double> selectRRC_SET_SUCC_RATE();

    @Select("select ERAB_SET_SUCCESS_TIME from tbKPI")//9
    List<Integer> selectERAB_SET_SUCCESS_TIME();

    @Select("select ERAB_TRY_CONNECT_TIME from tbKPI")//10
    List<Double> selectERAB_TRY_CONNECT_TIME();

    @Select("select ERAB_SET_SUCCESS_TWO from tbKPI")//11
    List<Integer> selectERAB_SET_SUCCESS_TWO();

    @Select("select eNodeB_TRYGGER_EXCEP_RELE_TIME from tbKPI")//12
    List<Integer> selecteNodeB_TRYGGER_EXCEP_RELE_TIME();

    @Select("select SECTOR_SWITCH_ERAB_EXCEP_RELE_TIME from tbKPI")//13
    List<Double> selectSECTOR_SWITCH_ERAB_EXCEP_RELE_TIME();

    @Select("select ERAB_DROP_RATE from tbKPI")//14
    List<Double> selectERAB_DROP_RATE();

    @Select("select WIRELESS_CONN_RATE from tbKPI")//15
    List<Integer> selectWIRELESS_CONN_RATE();

    @Select("select eNodeB_INIT_S1 from tbKPI")//16
    List<Integer> selecteNodeB_INIT_S1();

    @Select("select UE_Context_EXCEP_RELE_TIME from tbKPI")//17
    List<Integer> selectUE_Context_EXCEP_RELE_TIME();

    @Select("select UE_Context_SET_SUCCESS_TIME from tbKPI")//18
    List<Double> selectUE_Context_SET_SUCCESS_TIME();

    @Select("select WIRELESS_DROP_RATE from tbKPI")//19
    List<Integer> selectWIRELESS_DROP_RATE();

    @Select("select eNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME from tbKPI")//20
    List<Integer> selecteNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME();

    @Select("select eNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME from tbKPI")//21
    List<Integer> selecteNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME();

    @Select("select eNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME from tbKPI")//22
    List<Integer> selecteeNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME();//

    @Select("select eNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME from tbKPI")//23
    List<Integer> selecteNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME();

    @Select("select eNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME from tbKPI")//24
    List<Integer> selecteNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME();

    @Select("select eNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME from tbKPI")//25
    List<Integer> selecteNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME();

    @Select("select eNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME from tbKPI")//26
    List<Integer> selecteNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME();

    @Select("select eNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME from tbKPI")//27
    List<Integer> selecteNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME();

    @Select("select eNB_IN_SWITCH_SUCC_RATE from tbKPI")//28
    List<Double> selecteNB_IN_SWITCH_SUCC_RATE();

    @Select("select eNB_BETWEEN_SWITCH_SUCC_RATE from tbKPI")//29
    List<Double> selecteNB_BETWEEN_SWITCH_SUCC_RATE();

    @Select("select SAME_FREQ_SWITCH_SUCC_ZSP from tbKPI")//30
    List<Double> selectSAME_FREQ_SWITCH_SUCC_ZSP();

    @Select("select DIFF_FREQ_SWITCH_SUCC_ZSP from tbKPI")//30
    List<Double> selectDIFF_FREQ_SWITCH_SUCC_ZSP();

    @Select("select SWITCH_SUCC_RATE from tbKPI")//31
    List<Double> selectSWITCH_SUCC_RATE();

    @Select("select SECTOR_DPCP_RECV_UP_DATE_THROUGHPUT from tbKPI")//32
    List<Long> selectSECTOR_DPCP_RECV_UP_DATE_THROUGHPUT();

    @Select("select SECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT from tbKPI")//33
    List<Long> selectSECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT();

    @Select("select RPC_RESET_REQUEST_TIME from tbKPI")//34
    List<Integer> selectRPC_RESET_REQUEST_TIME();

    @Select("select RPC_CONN_RESET_RATE from tbKPI")//35
    List<Double> selectRPC_CONN_RESET_RATE();

    @Select("select TO_ONE from tbKPI")//36
    List<Integer> selectTO_ONE();

    @Select("select TO_TWO from tbKPI")//37
    List<Integer> selectTO_TWO();

    @Select("select TO_THREE from tbKPI")//38
    List<Integer> selectTO_THREE();

    @Select("select TO_FOUR from tbKPI")//39
    List<Integer> selectTO_FOUR();

    @Select("select eNB_IN_SWITCH_SUCC_TIME from tbKPI")//40
    List<Integer> selecteNB_IN_SWITCH_SUCC_TIME();

    @Select("select eNB_IN_SWITCH_REQUEST_TIME from tbKPI")//41
    List<Integer> selecteNB_IN_SWITCH_REQUEST_TIME();


}
