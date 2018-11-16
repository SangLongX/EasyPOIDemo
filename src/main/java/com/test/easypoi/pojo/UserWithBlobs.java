package com.test.easypoi.pojo;

/**
 * 用户bean
 * 
 * @author WilliamSang
 * @date 2018/11/13 19:12
 */
public class UserWithBlobs extends User {
    private String comment;

    private String sealdetail;

    private String idcardimgf;

    private String idcardimgr;

    private String sfidcardimgf;

    private String sfidcardimgr;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getSealdetail() {
        return sealdetail;
    }

    public void setSealdetail(String sealdetail) {
        this.sealdetail = sealdetail == null ? null : sealdetail.trim();
    }

    public String getIdcardimgf() {
        return idcardimgf;
    }

    public void setIdcardimgf(String idcardimgf) {
        this.idcardimgf = idcardimgf == null ? null : idcardimgf.trim();
    }

    public String getIdcardimgr() {
        return idcardimgr;
    }

    public void setIdcardimgr(String idcardimgr) {
        this.idcardimgr = idcardimgr == null ? null : idcardimgr.trim();
    }

    public String getSfidcardimgf() {
        return sfidcardimgf;
    }

    public void setSfidcardimgf(String sfidcardimgf) {
        this.sfidcardimgf = sfidcardimgf == null ? null : sfidcardimgf.trim();
    }

    public String getSfidcardimgr() {
        return sfidcardimgr;
    }

    public void setSfidcardimgr(String sfidcardimgr) {
        this.sfidcardimgr = sfidcardimgr == null ? null : sfidcardimgr.trim();
    }
}