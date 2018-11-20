package com.test.easypoi.pojo;

import java.util.Date;

/**
 * 债转bean
 * 
 * @author WilliamSang
 * @date 2018/11/13 19:12
 */
public class TransferApply {
    private String id;

    private Date applyTime;

    private Double corpus;

    private Date deadline;

    private Double premium;

    private String status;

    private String investId;

    private String isWisdom;

    private String sourceorderid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Double getCorpus() {
        return corpus;
    }

    public void setCorpus(Double corpus) {
        this.corpus = corpus;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getInvestId() {
        return investId;
    }

    public void setInvestId(String investId) {
        this.investId = investId == null ? null : investId.trim();
    }

    public String getIsWisdom() {
        return isWisdom;
    }

    public void setIsWisdom(String isWisdom) {
        this.isWisdom = isWisdom == null ? null : isWisdom.trim();
    }

    public String getSourceorderid() {
        return sourceorderid;
    }

    public void setSourceorderid(String sourceorderid) {
        this.sourceorderid = sourceorderid == null ? null : sourceorderid.trim();
    }
}