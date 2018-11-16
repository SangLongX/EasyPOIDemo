package com.test.easypoi.pojo;

/**
 * 投资bean
 * 
 * @author WilliamSang
 * @date 2018/11/13 19:11
 */
public class InvestWithBlobs extends Invest {
    private String nodebody;

    private String guarantycontract;

    public String getNodebody() {
        return nodebody;
    }

    public void setNodebody(String nodebody) {
        this.nodebody = nodebody == null ? null : nodebody.trim();
    }

    public String getGuarantycontract() {
        return guarantycontract;
    }

    public void setGuarantycontract(String guarantycontract) {
        this.guarantycontract = guarantycontract == null ? null : guarantycontract.trim();
    }
}