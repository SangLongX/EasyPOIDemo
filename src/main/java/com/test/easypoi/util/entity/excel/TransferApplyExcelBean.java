package com.test.easypoi.util.entity.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 导出债转excel bean
 *
 * @author SangXiaolong
 * @date 2018/11/13 14:20
 */
public class TransferApplyExcelBean {
    @Excel(name = "投资人id")
    private String investId;
    @Excel(name = "投资人姓名", orderNum = "1")
    private String investUserName;
    @Excel(name = "投资状态", orderNum = "2")
    private String investStatus;
    @Excel(name = "债转开始时间", orderNum = "3", databaseFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transferBeginTime;
    @Excel(name = "债转本金", orderNum = "4")
    private Double transferCorpus;
    @Excel(name = "第三方订单号", orderNum = "5")
    private String sourceOrderId;

    public String getInvestId() {
        return investId;
    }

    public void setInvestId(String investId) {
        this.investId = investId;
    }

    public String getInvestUserName() {
        return investUserName;
    }

    public void setInvestUserName(String investUserName) {
        this.investUserName = investUserName;
    }

    public String getInvestStatus() {
        return investStatus;
    }

    public void setInvestStatus(String investStatus) {
        this.investStatus = investStatus;
    }

    public Date getTransferBeginTime() {
        return transferBeginTime;
    }

    public void setTransferBeginTime(Date transferBeginTime) {
        this.transferBeginTime = transferBeginTime;
    }

    public Double getTransferCorpus() {
        return transferCorpus;
    }

    public void setTransferCorpus(Double transferCorpus) {
        this.transferCorpus = transferCorpus;
    }

    public String getSourceOrderId() {
        return sourceOrderId;
    }

    public void setSourceOrderId(String sourceOrderId) {
        this.sourceOrderId = sourceOrderId;
    }
}
