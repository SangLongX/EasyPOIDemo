package com.test.easypoi.util.entity.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * 导出标的excel bean
 *
 * @author SangXiaolong
 * @date 2018/11/13 14:18
 */
public class LoanExcelBean {
    @Excel(name = "标的id")
    private String loanId;
    @Excel(name = "标的名", orderNum = "1")
    private String loanName;
    @Excel(name = "投资人id", orderNum = "2")
    private String investUserId;
    @Excel(name = "投资人姓名", orderNum = "3")
    private String investUserName;
    @Excel(name = "投资人身份证号", orderNum = "4")
    private String investUserIdCard;
    @Excel(name = "投资回报本金", orderNum = "5")
    private String investRepayCorpus;
    @Excel(name = "投资回报利率", orderNum = "6")
    private String investRepayInterest;
    @Excel(name = "投资时间", orderNum = "7")
    private String investTime;
    @Excel(name = "投资回报状态", orderNum = "8")
    private String investRepayStatus;


    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public String getInvestUserId() {
        return investUserId;
    }

    public void setInvestUserId(String investUserId) {
        this.investUserId = investUserId;
    }

    public String getInvestUserName() {
        return investUserName;
    }

    public void setInvestUserName(String investUserName) {
        this.investUserName = investUserName;
    }

    public String getInvestUserIdCard() {
        return investUserIdCard;
    }

    public void setInvestUserIdCard(String investUserIdCard) {
        this.investUserIdCard = investUserIdCard;
    }

    public String getInvestRepayCorpus() {
        return investRepayCorpus;
    }

    public void setInvestRepayCorpus(String investRepayCorpus) {
        this.investRepayCorpus = investRepayCorpus;
    }

    public String getInvestRepayInterest() {
        return investRepayInterest;
    }

    public void setInvestRepayInterest(String investRepayInterest) {
        this.investRepayInterest = investRepayInterest;
    }

    public String getInvestTime() {
        return investTime;
    }

    public void setInvestTime(String investTime) {
        this.investTime = investTime;
    }

    public String getInvestRepayStatus() {
        return investRepayStatus;
    }

    public void setInvestRepayStatus(String investRepayStatus) {
        this.investRepayStatus = investRepayStatus;
    }
}
