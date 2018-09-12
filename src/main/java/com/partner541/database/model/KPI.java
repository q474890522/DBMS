package com.partner541.database.model;
//aaaaaa
import java.sql.Timestamp;
import java.util.Date;

public class KPI {
    private Date STARTTIME				;//datetime not null, --起始时间
    private int CYCLE					;//int not null, --周期
    private String NENAME					;//nvarchar(50) not null, --网元名称
    private String SECTOR					;//text not null,--小区
    private String SECTORNAME				;//nvarchar(100) not null,--小区名称
    private int RRCCONNECTCOMPLETETIME ;//int not null,-- RPC连接建立完成次数
    private int RRCCONNECTREQUESTTIME	;//int not null,--RPC连接请求次数（包括重发）
    private Double RRCSETSUCCRATE 		;//float not null,--RPC建立成功率
    private int ERABSETSUCCESSTIME 		;//int not null,--ERAB建立成功总次数
    private int ERABTRYCONNECTTIME		;//int not null,--ERAB建立尝试总次数

    private Double ERABSETSUCCESSTWO		;//float not null,--建立成功率2
    private int eNodeBTRYGGEREXCEPRELETIME	;//int not null, --enode触发的ERAB异常释放总次数
    private int SECTORSWITCHERABEXCEPRELETIME	;//int not null, --小区切换出E-RAB异常释放总次数
    private Double ERABDROPRATE			;//float not null, --ERAB掉线率
    private Double WIRELESSCONNRATE		;//float not null,--无线接通率
    private int eNodeBINITS1 ;//int not null,--eNodeB发起的S1 RESET导致的UE Context释放次数 (无)
    private int UEContextEXCEPRELETIME ;//int  not null,--UE Context异常释放次数 (无)
    private int UEContextSETSUCCESSTIME ;//int not null,--UE Context建立成功总次数 (无)
    private Double WIRELESSDROPRATE		;//float not null,--无线掉线率 (%)
    private int eNodeBINDIFFFREQSWITCHSUCCTIME ;//int  not null,--eNodeB内异频切换出成功次数 (无)

    private int eNodeBINDIFFFREQSWITCHTRYTIME ;//int not null,--eNodeB内异频切换出尝试次数 (无)
    private int eNodeBINSAMEFREQSWITCHSUCCTIME ;//int not null,--eNodeB内同频切换出成功次数 (无)
    private int eNodeBINSAMEFREQSWITCHTRYTIME ;//int  not null,--eNodeB内同频切换出尝试次数 (无)
    private int eNodeBBETWEENDIFFFREQSWITCHSUCCTIME ;//int not null,--eNodeB间异频切换出成功次数 (无)
    private int eNodeBBETWEENDIFFFREQSWITCHTRYTIME ;//int not null,--eNodeB间异频切换出尝试次数 (无)
    private int eNodeBBETWEENSAMEFREQSWITCHSUCCTIME ;//int not null,--eNodeB间同频切换出成功次数 (无)
    private int eNodeBBETWEENSAMEFREQSWITCHTRYTIME ;//int  not null,--eNodeB间同频切换出尝试次数 (无)
    private Double eNBINSWITCHSUCCRATE ;//float null,--eNB内切换成功率 (%)
    private Double eNBBETWEENSWITCHSUCCRATE ;//float  null,--eNB间切换成功率 (%)
    private Double SAMEFREQSWITCHSUCCZSP ;//float  null,--同频切换成功率zsp (%)

    private Double DIFFFREQSWITCHSUCCZSP ;//float null,--异频切换成功率zsp (%)
    private Double SWITCHSUCCRATE ;//float not null,--切换成功率 (%)
    private Long SECTORDPCPRECVUPDATETHROUGHPUT ;//bigint  not null,--小区PDCP层所接收到的上行数据的总吞吐量 (比特)
    private Long SECTORDPCPRECVDOWNDATETHROUGHPUT ;//bigint not null,--小区PDCP层所发送的下行数据的总吞吐量 (比特)
    private int RPCRESETREQUESTTIME ;//int not null,--RRC重建请求次数 (无)
    private Double RPCCONNRESETRATE ;//float not null,--RRC连接重建比率 (%)
    private int TOONE ;//int not null,--通过重建回源小区的eNodeB间同频切换出执行成功次数 (无)
    private int TOTWO ;//int  not null,--通过重建回源小区的eNodeB间异频切换出执行成功次数 (无)
    private int TOTHREE ;//int not null,--通过重建回源小区的eNodeB内同频切换出执行成功次数 (无)
    private int TOFOUR ;//int not null,--通过重建回源小区的eNodeB内异频切换出执行成功次数 (无)

    private int eNBINSWITCHSUCCTIME ;//int not null,--eNB内切换出成功次数 (次)
    private int eNBINSWITCHREQUESTTIME ;//int not null,--eNB内切换出请求次数

    public Date getSTARTTIME() {
        return STARTTIME;
    }

    public void setSTARTTIME(Date STARTTIME) {
        this.STARTTIME = STARTTIME;
    }

    public int getCYCLE() {
        return CYCLE;
    }

    public void setCYCLE(int CYCLE) {
        this.CYCLE = CYCLE;
    }

    public String getNENAME() {
        return NENAME;
    }

    public void setNENAME(String NENAME) {
        this.NENAME = NENAME;
    }

    public String getSECTOR() {
        return SECTOR;
    }

    public void setSECTOR(String SECTOR) {
        this.SECTOR = SECTOR;
    }

    public String getSECTORNAME() {
        return SECTORNAME;
    }

    public void setSECTORNAME(String SECTORNAME) {
        this.SECTORNAME = SECTORNAME;
    }

    public int getRRCCONNECTCOMPLETETIME() {
        return RRCCONNECTCOMPLETETIME;
    }

    public void setRRCCONNECTCOMPLETETIME(int RRCCONNECTCOMPLETETIME) {
        this.RRCCONNECTCOMPLETETIME = RRCCONNECTCOMPLETETIME;
    }

    public int getRRCCONNECTREQUESTTIME() {
        return RRCCONNECTREQUESTTIME;
    }

    public void setRRCCONNECTREQUESTTIME(int RRCCONNECTREQUESTTIME) {
        this.RRCCONNECTREQUESTTIME = RRCCONNECTREQUESTTIME;
    }

    public Double getRRCSETSUCCRATE() {
        return RRCSETSUCCRATE;
    }

    public void setRRCSETSUCCRATE(Double RRCSETSUCCRATE) {
        this.RRCSETSUCCRATE = RRCSETSUCCRATE;
    }

    public int getERABSETSUCCESSTIME() {
        return ERABSETSUCCESSTIME;
    }

    public void setERABSETSUCCESSTIME(int ERABSETSUCCESSTIME) {
        this.ERABSETSUCCESSTIME = ERABSETSUCCESSTIME;
    }

    public int getERABTRYCONNECTTIME() {
        return ERABTRYCONNECTTIME;
    }

    public void setERABTRYCONNECTTIME(int ERABTRYCONNECTTIME) {
        this.ERABTRYCONNECTTIME = ERABTRYCONNECTTIME;
    }

    public Double getERABSETSUCCESSTWO() {
        return ERABSETSUCCESSTWO;
    }

    public void setERABSETSUCCESSTWO(Double ERABSETSUCCESSTWO) {
        this.ERABSETSUCCESSTWO = ERABSETSUCCESSTWO;
    }

    public int geteNodeBTRYGGEREXCEPRELETIME() {
        return eNodeBTRYGGEREXCEPRELETIME;
    }

    public void seteNodeBTRYGGEREXCEPRELETIME(int eNodeBTRYGGEREXCEPRELETIME) {
        this.eNodeBTRYGGEREXCEPRELETIME = eNodeBTRYGGEREXCEPRELETIME;
    }

    public int getSECTORSWITCHERABEXCEPRELETIME() {
        return SECTORSWITCHERABEXCEPRELETIME;
    }

    public void setSECTORSWITCHERABEXCEPRELETIME(int SECTORSWITCHERABEXCEPRELETIME) {
        this.SECTORSWITCHERABEXCEPRELETIME = SECTORSWITCHERABEXCEPRELETIME;
    }

    public Double getERABDROPRATE() {
        return ERABDROPRATE;
    }

    public void setERABDROPRATE(Double ERABDROPRATE) {
        this.ERABDROPRATE = ERABDROPRATE;
    }

    public Double getWIRELESSCONNRATE() {
        return WIRELESSCONNRATE;
    }

    public void setWIRELESSCONNRATE(Double WIRELESSCONNRATE) {
        this.WIRELESSCONNRATE = WIRELESSCONNRATE;
    }

    public int geteNodeBINITS1() {
        return eNodeBINITS1;
    }

    public void seteNodeBINITS1(int eNodeBINITS1) {
        this.eNodeBINITS1 = eNodeBINITS1;
    }

    public int getUEContextEXCEPRELETIME() {
        return UEContextEXCEPRELETIME;
    }

    public void setUEContextEXCEPRELETIME(int UEContextEXCEPRELETIME) {
        this.UEContextEXCEPRELETIME = UEContextEXCEPRELETIME;
    }

    public int getUEContextSETSUCCESSTIME() {
        return UEContextSETSUCCESSTIME;
    }

    public void setUEContextSETSUCCESSTIME(int UEContextSETSUCCESSTIME) {
        this.UEContextSETSUCCESSTIME = UEContextSETSUCCESSTIME;
    }

    public Double getWIRELESSDROPRATE() {
        return WIRELESSDROPRATE;
    }

    public void setWIRELESSDROPRATE(Double WIRELESSDROPRATE) {
        this.WIRELESSDROPRATE = WIRELESSDROPRATE;
    }

    public int geteNodeBINDIFFFREQSWITCHSUCCTIME() {
        return eNodeBINDIFFFREQSWITCHSUCCTIME;
    }

    public void seteNodeBINDIFFFREQSWITCHSUCCTIME(int eNodeBINDIFFFREQSWITCHSUCCTIME) {
        this.eNodeBINDIFFFREQSWITCHSUCCTIME = eNodeBINDIFFFREQSWITCHSUCCTIME;
    }

    public int geteNodeBINDIFFFREQSWITCHTRYTIME() {
        return eNodeBINDIFFFREQSWITCHTRYTIME;
    }

    public void seteNodeBINDIFFFREQSWITCHTRYTIME(int eNodeBINDIFFFREQSWITCHTRYTIME) {
        this.eNodeBINDIFFFREQSWITCHTRYTIME = eNodeBINDIFFFREQSWITCHTRYTIME;
    }

    public int geteNodeBINSAMEFREQSWITCHSUCCTIME() {
        return eNodeBINSAMEFREQSWITCHSUCCTIME;
    }

    public void seteNodeBINSAMEFREQSWITCHSUCCTIME(int eNodeBINSAMEFREQSWITCHSUCCTIME) {
        this.eNodeBINSAMEFREQSWITCHSUCCTIME = eNodeBINSAMEFREQSWITCHSUCCTIME;
    }

    public int geteNodeBINSAMEFREQSWITCHTRYTIME() {
        return eNodeBINSAMEFREQSWITCHTRYTIME;
    }

    public void seteNodeBINSAMEFREQSWITCHTRYTIME(int eNodeBINSAMEFREQSWITCHTRYTIME) {
        this.eNodeBINSAMEFREQSWITCHTRYTIME = eNodeBINSAMEFREQSWITCHTRYTIME;
    }

    public int geteNodeBBETWEENDIFFFREQSWITCHSUCCTIME() {
        return eNodeBBETWEENDIFFFREQSWITCHSUCCTIME;
    }

    public void seteNodeBBETWEENDIFFFREQSWITCHSUCCTIME(int eNodeBBETWEENDIFFFREQSWITCHSUCCTIME) {
        this.eNodeBBETWEENDIFFFREQSWITCHSUCCTIME = eNodeBBETWEENDIFFFREQSWITCHSUCCTIME;
    }

    public int geteNodeBBETWEENDIFFFREQSWITCHTRYTIME() {
        return eNodeBBETWEENDIFFFREQSWITCHTRYTIME;
    }

    public void seteNodeBBETWEENDIFFFREQSWITCHTRYTIME(int eNodeBBETWEENDIFFFREQSWITCHTRYTIME) {
        this.eNodeBBETWEENDIFFFREQSWITCHTRYTIME = eNodeBBETWEENDIFFFREQSWITCHTRYTIME;
    }

    public int geteNodeBBETWEENSAMEFREQSWITCHSUCCTIME() {
        return eNodeBBETWEENSAMEFREQSWITCHSUCCTIME;
    }

    public void seteNodeBBETWEENSAMEFREQSWITCHSUCCTIME(int eNodeBBETWEENSAMEFREQSWITCHSUCCTIME) {
        this.eNodeBBETWEENSAMEFREQSWITCHSUCCTIME = eNodeBBETWEENSAMEFREQSWITCHSUCCTIME;
    }

    public int geteNodeBBETWEENSAMEFREQSWITCHTRYTIME() {
        return eNodeBBETWEENSAMEFREQSWITCHTRYTIME;
    }

    public void seteNodeBBETWEENSAMEFREQSWITCHTRYTIME(int eNodeBBETWEENSAMEFREQSWITCHTRYTIME) {
        this.eNodeBBETWEENSAMEFREQSWITCHTRYTIME = eNodeBBETWEENSAMEFREQSWITCHTRYTIME;
    }

    public Double geteNBINSWITCHSUCCRATE() {
        return eNBINSWITCHSUCCRATE;
    }

    public void seteNBINSWITCHSUCCRATE(Double eNBINSWITCHSUCCRATE) {
        this.eNBINSWITCHSUCCRATE = eNBINSWITCHSUCCRATE;
    }

    public Double geteNBBETWEENSWITCHSUCCRATE() {
        return eNBBETWEENSWITCHSUCCRATE;
    }

    public void seteNBBETWEENSWITCHSUCCRATE(Double eNBBETWEENSWITCHSUCCRATE) {
        this.eNBBETWEENSWITCHSUCCRATE = eNBBETWEENSWITCHSUCCRATE;
    }

    public Double getSAMEFREQSWITCHSUCCZSP() {
        return SAMEFREQSWITCHSUCCZSP;
    }

    public void setSAMEFREQSWITCHSUCCZSP(Double SAMEFREQSWITCHSUCCZSP) {
        this.SAMEFREQSWITCHSUCCZSP = SAMEFREQSWITCHSUCCZSP;
    }

    public Double getDIFFFREQSWITCHSUCCZSP() {
        return DIFFFREQSWITCHSUCCZSP;
    }

    public void setDIFFFREQSWITCHSUCCZSP(Double DIFFFREQSWITCHSUCCZSP) {
        this.DIFFFREQSWITCHSUCCZSP = DIFFFREQSWITCHSUCCZSP;
    }

    public Double getSWITCHSUCCRATE() {
        return SWITCHSUCCRATE;
    }

    public void setSWITCHSUCCRATE(Double SWITCHSUCCRATE) {
        this.SWITCHSUCCRATE = SWITCHSUCCRATE;
    }

    public Long getSECTORDPCPRECVUPDATETHROUGHPUT() {
        return SECTORDPCPRECVUPDATETHROUGHPUT;
    }

    public void setSECTORDPCPRECVUPDATETHROUGHPUT(Long SECTORDPCPRECVUPDATETHROUGHPUT) {
        this.SECTORDPCPRECVUPDATETHROUGHPUT = SECTORDPCPRECVUPDATETHROUGHPUT;
    }

    public Long getSECTORDPCPRECVDOWNDATETHROUGHPUT() {
        return SECTORDPCPRECVDOWNDATETHROUGHPUT;
    }

    public void setSECTORDPCPRECVDOWNDATETHROUGHPUT(Long SECTORDPCPRECVDOWNDATETHROUGHPUT) {
        this.SECTORDPCPRECVDOWNDATETHROUGHPUT = SECTORDPCPRECVDOWNDATETHROUGHPUT;
    }

    public int getRPCRESETREQUESTTIME() {
        return RPCRESETREQUESTTIME;
    }

    public void setRPCRESETREQUESTTIME(int RPCRESETREQUESTTIME) {
        this.RPCRESETREQUESTTIME = RPCRESETREQUESTTIME;
    }

    public Double getRPCCONNRESETRATE() {
        return RPCCONNRESETRATE;
    }

    public void setRPCCONNRESETRATE(Double RPCCONNRESETRATE) {
        this.RPCCONNRESETRATE = RPCCONNRESETRATE;
    }

    public int getTOONE() {
        return TOONE;
    }

    public void setTOONE(int TOONE) {
        this.TOONE = TOONE;
    }

    public int getTOTWO() {
        return TOTWO;
    }

    public void setTOTWO(int TOTWO) {
        this.TOTWO = TOTWO;
    }

    public int getTOTHREE() {
        return TOTHREE;
    }

    public void setTOTHREE(int TOTHREE) {
        this.TOTHREE = TOTHREE;
    }

    public int getTOFOUR() {
        return TOFOUR;
    }

    public void setTOFOUR(int TOFOUR) {
        this.TOFOUR = TOFOUR;
    }

    public int geteNBINSWITCHSUCCTIME() {
        return eNBINSWITCHSUCCTIME;
    }

    public void seteNBINSWITCHSUCCTIME(int eNBINSWITCHSUCCTIME) {
        this.eNBINSWITCHSUCCTIME = eNBINSWITCHSUCCTIME;
    }

    public int geteNBINSWITCHREQUESTTIME() {
        return eNBINSWITCHREQUESTTIME;
    }

    public void seteNBINSWITCHREQUESTTIME(int eNBINSWITCHREQUESTTIME) {
        this.eNBINSWITCHREQUESTTIME = eNBINSWITCHREQUESTTIME;
    }




}
