package com.test.easypoi.pojo;

import java.util.Date;

/**
 * 投资回报bean
 * 
 * @author SangXiaolong
 * @date 2018/11/13 19:10
 */
public class InvestRepay {
    private String id;

    private Double corpus;

    private Double defaultInterest;

    private Double interest;

    private Integer length;

    private Integer period;

    private Date repayDay;

    private String status;

    private Date time;

    private String investId;

    private Double fee;

    private Double corpusToSystem;

    private Double actInterest;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Double getCorpus() {
        return corpus;
    }

    public void setCorpus(Double corpus) {
        this.corpus = corpus;
    }

    public Double getDefaultInterest() {
        return defaultInterest;
    }

    public void setDefaultInterest(Double defaultInterest) {
        this.defaultInterest = defaultInterest;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Date getRepayDay() {
        return repayDay;
    }

    public void setRepayDay(Date repayDay) {
        this.repayDay = repayDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getInvestId() {
        return investId;
    }

    public void setInvestId(String investId) {
        this.investId = investId == null ? null : investId.trim();
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getCorpusToSystem() {
        return corpusToSystem;
    }

    public void setCorpusToSystem(Double corpusToSystem) {
        this.corpusToSystem = corpusToSystem;
    }

    public Double getActInterest() {
        return actInterest;
    }

    public void setActInterest(Double actInterest) {
        this.actInterest = actInterest;
    }
}