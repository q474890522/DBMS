package com.partner541.database.model;
//aaaaaa
import java.sql.Timestamp;

public class KPI {
    private Timestamp START_TIME				;//datetime not null, --起始时间
    private int CYCLE					;//int not null, --周期
    private String NE_NAME					;//nvarchar(50) not null, --网元名称
    private String SECTOR					;//text not null,--小区
    private String SECTOR_NAME				;//nvarchar(100) not null,--小区名称
    private int RRC_CONNECT_COMPLETE_TIME ;//int not null,-- RPC连接建立完成次数
    private int RRC_CONNECT_REQUEST_TIME	;//int not null,--RPC连接请求次数（包括重发）
    private Double RRC_SET_SUCC_RATE 		;//float not null,--RPC建立成功率
    private int ERAB_SET_SUCCESS_TIME 		;//int not null,--ERAB建立成功总次数
    private int ERAB_TRY_CONNECT_TIME		;//int not null,--ERAB建立尝试总次数

    private Double ERAB_SET_SUCCESS_TWO		;//float not null,--建立成功率2
    private int eNodeB_TRYGGER_EXCEP_RELE_TIME	;//int not null, --enode触发的ERAB异常释放总次数
    private int SECTOR_SWITCH_ERAB_EXCEP_RELE_TIME	;//int not null, --小区切换出E-RAB异常释放总次数
    private Double ERAB_DROP_RATE			;//float not null, --ERAB掉线率
    private Double WIRELESS_CONN_RATE		;//float not null,--无线接通率
    private int eNodeB_INIT_S1 ;//int not null,--eNodeB发起的S1 RESET导致的UE Context释放次数 (无)
    private int UE_Context_EXCEP_RELE_TIME ;//int  not null,--UE Context异常释放次数 (无)
    private int UE_Context_SET_SUCCESS_TIME ;//int not null,--UE Context建立成功总次数 (无)
    private Double WIRELESS_DROP_RATE		;//float not null,--无线掉线率 (%)
    private int eNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME ;//int  not null,--eNodeB内异频切换出成功次数 (无)

    public Timestamp getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(Timestamp START_TIME) {
        this.START_TIME = START_TIME;
    }

    public int getCYCLE() {
        return CYCLE;
    }

    public void setCYCLE(int CYCLE) {
        this.CYCLE = CYCLE;
    }

    public String getNE_NAME() {
        return NE_NAME;
    }

    public void setNE_NAME(String NE_NAME) {
        this.NE_NAME = NE_NAME;
    }

    public String getSECTOR() {
        return SECTOR;
    }

    public void setSECTOR(String SECTOR) {
        this.SECTOR = SECTOR;
    }

    public String getSECTOR_NAME() {
        return SECTOR_NAME;
    }

    public void setSECTOR_NAME(String SECTOR_NAME) {
        this.SECTOR_NAME = SECTOR_NAME;
    }

    public int getRRC_CONNECT_COMPLETE_TIME() {
        return RRC_CONNECT_COMPLETE_TIME;
    }

    public void setRRC_CONNECT_COMPLETE_TIME(int RRC_CONNECT_COMPLETE_TIME) {
        this.RRC_CONNECT_COMPLETE_TIME = RRC_CONNECT_COMPLETE_TIME;
    }

    public int getRRC_CONNECT_REQUEST_TIME() {
        return RRC_CONNECT_REQUEST_TIME;
    }

    public void setRRC_CONNECT_REQUEST_TIME(int RRC_CONNECT_REQUEST_TIME) {
        this.RRC_CONNECT_REQUEST_TIME = RRC_CONNECT_REQUEST_TIME;
    }

    public Double getRRC_SET_SUCC_RATE() {
        return RRC_SET_SUCC_RATE;
    }

    public void setRRC_SET_SUCC_RATE(Double RRC_SET_SUCC_RATE) {
        this.RRC_SET_SUCC_RATE = RRC_SET_SUCC_RATE;
    }

    public int getERAB_SET_SUCCESS_TIME() {
        return ERAB_SET_SUCCESS_TIME;
    }

    public void setERAB_SET_SUCCESS_TIME(int ERAB_SET_SUCCESS_TIME) {
        this.ERAB_SET_SUCCESS_TIME = ERAB_SET_SUCCESS_TIME;
    }

    public int getERAB_TRY_CONNECT_TIME() {
        return ERAB_TRY_CONNECT_TIME;
    }

    public void setERAB_TRY_CONNECT_TIME(int ERAB_TRY_CONNECT_TIME) {
        this.ERAB_TRY_CONNECT_TIME = ERAB_TRY_CONNECT_TIME;
    }

    public Double getERAB_SET_SUCCESS_TWO() {
        return ERAB_SET_SUCCESS_TWO;
    }

    public void setERAB_SET_SUCCESS_TWO(Double ERAB_SET_SUCCESS_TWO) {
        this.ERAB_SET_SUCCESS_TWO = ERAB_SET_SUCCESS_TWO;
    }

    public int geteNodeB_TRYGGER_EXCEP_RELE_TIME() {
        return eNodeB_TRYGGER_EXCEP_RELE_TIME;
    }

    public void seteNodeB_TRYGGER_EXCEP_RELE_TIME(int eNodeB_TRYGGER_EXCEP_RELE_TIME) {
        this.eNodeB_TRYGGER_EXCEP_RELE_TIME = eNodeB_TRYGGER_EXCEP_RELE_TIME;
    }

    public int getSECTOR_SWITCH_ERAB_EXCEP_RELE_TIME() {
        return SECTOR_SWITCH_ERAB_EXCEP_RELE_TIME;
    }

    public void setSECTOR_SWITCH_ERAB_EXCEP_RELE_TIME(int SECTOR_SWITCH_ERAB_EXCEP_RELE_TIME) {
        this.SECTOR_SWITCH_ERAB_EXCEP_RELE_TIME = SECTOR_SWITCH_ERAB_EXCEP_RELE_TIME;
    }

    public Double getERAB_DROP_RATE() {
        return ERAB_DROP_RATE;
    }

    public void setERAB_DROP_RATE(Double ERAB_DROP_RATE) {
        this.ERAB_DROP_RATE = ERAB_DROP_RATE;
    }

    public Double getWIRELESS_CONN_RATE() {
        return WIRELESS_CONN_RATE;
    }

    public void setWIRELESS_CONN_RATE(Double WIRELESS_CONN_RATE) {
        this.WIRELESS_CONN_RATE = WIRELESS_CONN_RATE;
    }

    public int geteNodeB_INIT_S1() {
        return eNodeB_INIT_S1;
    }

    public void seteNodeB_INIT_S1(int eNodeB_INIT_S1) {
        this.eNodeB_INIT_S1 = eNodeB_INIT_S1;
    }

    public int getUE_Context_EXCEP_RELE_TIME() {
        return UE_Context_EXCEP_RELE_TIME;
    }

    public void setUE_Context_EXCEP_RELE_TIME(int UE_Context_EXCEP_RELE_TIME) {
        this.UE_Context_EXCEP_RELE_TIME = UE_Context_EXCEP_RELE_TIME;
    }

    public int getUE_Context_SET_SUCCESS_TIME() {
        return UE_Context_SET_SUCCESS_TIME;
    }

    public void setUE_Context_SET_SUCCESS_TIME(int UE_Context_SET_SUCCESS_TIME) {
        this.UE_Context_SET_SUCCESS_TIME = UE_Context_SET_SUCCESS_TIME;
    }

    public Double getWIRELESS_DROP_RATE() {
        return WIRELESS_DROP_RATE;
    }

    public void setWIRELESS_DROP_RATE(Double WIRELESS_DROP_RATE) {
        this.WIRELESS_DROP_RATE = WIRELESS_DROP_RATE;
    }

    public int geteNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME() {
        return eNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME;
    }

    public void seteNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME(int eNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME) {
        this.eNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME = eNodeB_IN_DIFF_FREQ_SWITCH_SUCC_TIME;
    }

    public int geteNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME() {
        return eNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME;
    }

    public void seteNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME(int eNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME) {
        this.eNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME = eNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME;
    }

    public int geteNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME() {
        return eNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME;
    }

    public void seteNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME(int eNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME) {
        this.eNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME = eNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME;
    }

    public int geteNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME() {
        return eNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME;
    }

    public void seteNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME(int eNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME) {
        this.eNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME = eNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME;
    }

    public int geteNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME() {
        return eNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME;
    }

    public void seteNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME(int eNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME) {
        this.eNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME = eNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME;
    }

    public int geteNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME() {
        return eNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME;
    }

    public void seteNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME(int eNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME) {
        this.eNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME = eNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME;
    }

    public int geteNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME() {
        return eNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME;
    }

    public void seteNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME(int eNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME) {
        this.eNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME = eNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME;
    }

    public int geteNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME() {
        return eNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME;
    }

    public void seteNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME(int eNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME) {
        this.eNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME = eNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME;
    }

    public Double geteNB_IN_SWITCH_SUCC_RATE() {
        return eNB_IN_SWITCH_SUCC_RATE;
    }

    public void seteNB_IN_SWITCH_SUCC_RATE(Double eNB_IN_SWITCH_SUCC_RATE) {
        this.eNB_IN_SWITCH_SUCC_RATE = eNB_IN_SWITCH_SUCC_RATE;
    }

    public Double geteNB_BETWEEN_SWITCH_SUCC_RATE() {
        return eNB_BETWEEN_SWITCH_SUCC_RATE;
    }

    public void seteNB_BETWEEN_SWITCH_SUCC_RATE(Double eNB_BETWEEN_SWITCH_SUCC_RATE) {
        this.eNB_BETWEEN_SWITCH_SUCC_RATE = eNB_BETWEEN_SWITCH_SUCC_RATE;
    }

    public Double getSAME_FREQ_SWITCH_SUCC_ZSP() {
        return SAME_FREQ_SWITCH_SUCC_ZSP;
    }

    public void setSAME_FREQ_SWITCH_SUCC_ZSP(Double SAME_FREQ_SWITCH_SUCC_ZSP) {
        this.SAME_FREQ_SWITCH_SUCC_ZSP = SAME_FREQ_SWITCH_SUCC_ZSP;
    }

    public Double getDIFF_FREQ_SWITCH_SUCC_ZSP() {
        return DIFF_FREQ_SWITCH_SUCC_ZSP;
    }

    public void setDIFF_FREQ_SWITCH_SUCC_ZSP(Double DIFF_FREQ_SWITCH_SUCC_ZSP) {
        this.DIFF_FREQ_SWITCH_SUCC_ZSP = DIFF_FREQ_SWITCH_SUCC_ZSP;
    }

    public Double getSWITCH_SUCC_RATE() {
        return SWITCH_SUCC_RATE;
    }

    public void setSWITCH_SUCC_RATE(Double SWITCH_SUCC_RATE) {
        this.SWITCH_SUCC_RATE = SWITCH_SUCC_RATE;
    }

    public Long getSECTOR_DPCP_RECV_UP_DATE_THROUGHPUT() {
        return SECTOR_DPCP_RECV_UP_DATE_THROUGHPUT;
    }

    public void setSECTOR_DPCP_RECV_UP_DATE_THROUGHPUT(Long SECTOR_DPCP_RECV_UP_DATE_THROUGHPUT) {
        this.SECTOR_DPCP_RECV_UP_DATE_THROUGHPUT = SECTOR_DPCP_RECV_UP_DATE_THROUGHPUT;
    }

    public Long getSECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT() {
        return SECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT;
    }

    public void setSECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT(Long SECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT) {
        this.SECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT = SECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT;
    }

    public int getRPC_RESET_REQUEST_TIME() {
        return RPC_RESET_REQUEST_TIME;
    }

    public void setRPC_RESET_REQUEST_TIME(int RPC_RESET_REQUEST_TIME) {
        this.RPC_RESET_REQUEST_TIME = RPC_RESET_REQUEST_TIME;
    }

    public Double getRPC_CONN_RESET_RATE() {
        return RPC_CONN_RESET_RATE;
    }

    public void setRPC_CONN_RESET_RATE(Double RPC_CONN_RESET_RATE) {
        this.RPC_CONN_RESET_RATE = RPC_CONN_RESET_RATE;
    }

    public int getTO_ONE() {
        return TO_ONE;
    }

    public void setTO_ONE(int TO_ONE) {
        this.TO_ONE = TO_ONE;
    }

    public int getTO_TWO() {
        return TO_TWO;
    }

    public void setTO_TWO(int TO_TWO) {
        this.TO_TWO = TO_TWO;
    }

    public int getTO_THREE() {
        return TO_THREE;
    }

    public void setTO_THREE(int TO_THREE) {
        this.TO_THREE = TO_THREE;
    }

    public int getTO_FOUR() {
        return TO_FOUR;
    }

    public void setTO_FOUR(int TO_FOUR) {
        this.TO_FOUR = TO_FOUR;
    }

    public int geteNB_IN_SWITCH_SUCC_TIME() {
        return eNB_IN_SWITCH_SUCC_TIME;
    }

    public void seteNB_IN_SWITCH_SUCC_TIME(int eNB_IN_SWITCH_SUCC_TIME) {
        this.eNB_IN_SWITCH_SUCC_TIME = eNB_IN_SWITCH_SUCC_TIME;
    }

    public int geteNB_IN_SWITCH_REQUEST_TIME() {
        return eNB_IN_SWITCH_REQUEST_TIME;
    }

    public void seteNB_IN_SWITCH_REQUEST_TIME(int eNB_IN_SWITCH_REQUEST_TIME) {
        this.eNB_IN_SWITCH_REQUEST_TIME = eNB_IN_SWITCH_REQUEST_TIME;
    }

    private int eNodeB_IN_DIFF_FREQ_SWITCH_TRY_TIME ;//int not null,--eNodeB内异频切换出尝试次数 (无)
    private int eNodeB_IN_SAME_FREQ_SWITCH_SUCC_TIME ;//int not null,--eNodeB内同频切换出成功次数 (无)
    private int eNodeB_IN_SAME_FREQ_SWITCH_TRY_TIME ;//int  not null,--eNodeB内同频切换出尝试次数 (无)
    private int eNodeB_BETWEEN_DIFF_FREQ_SWITCH_SUCC_TIME ;//int not null,--eNodeB间异频切换出成功次数 (无)
    private int eNodeB_BETWEEN_DIFF_FREQ_SWITCH_TRY_TIME ;//int not null,--eNodeB间异频切换出尝试次数 (无)
    private int eNodeB_BETWEEN_SAME_FREQ_SWITCH_SUCC_TIME ;//int not null,--eNodeB间同频切换出成功次数 (无)
    private int eNodeB_BETWEEN_SAME_FREQ_SWITCH_TRY_TIME ;//int  not null,--eNodeB间同频切换出尝试次数 (无)
    private Double eNB_IN_SWITCH_SUCC_RATE ;//float null,--eNB内切换成功率 (%)
    private Double eNB_BETWEEN_SWITCH_SUCC_RATE ;//float  null,--eNB间切换成功率 (%)
    private Double SAME_FREQ_SWITCH_SUCC_ZSP ;//float  null,--同频切换成功率zsp (%)

    private Double DIFF_FREQ_SWITCH_SUCC_ZSP ;//float null,--异频切换成功率zsp (%)
    private Double SWITCH_SUCC_RATE ;//float not null,--切换成功率 (%)
    private Long SECTOR_DPCP_RECV_UP_DATE_THROUGHPUT ;//bigint  not null,--小区PDCP层所接收到的上行数据的总吞吐量 (比特)
    private Long SECTOR_DPCP_RECV_DOWN_DATE_THROUGHPUT ;//bigint not null,--小区PDCP层所发送的下行数据的总吞吐量 (比特)
    private int RPC_RESET_REQUEST_TIME ;//int not null,--RRC重建请求次数 (无)
    private Double RPC_CONN_RESET_RATE ;//float not null,--RRC连接重建比率 (%)
    private int TO_ONE ;//int not null,--通过重建回源小区的eNodeB间同频切换出执行成功次数 (无)
    private int TO_TWO ;//int  not null,--通过重建回源小区的eNodeB间异频切换出执行成功次数 (无)
    private int TO_THREE ;//int not null,--通过重建回源小区的eNodeB内同频切换出执行成功次数 (无)
    private int TO_FOUR ;//int not null,--通过重建回源小区的eNodeB内异频切换出执行成功次数 (无)

    private int eNB_IN_SWITCH_SUCC_TIME ;//int not null,--eNB内切换出成功次数 (次)
    private int eNB_IN_SWITCH_REQUEST_TIME ;//int not null,--eNB内切换出请求次数


}
