package com.test.easypoi.util.entity.pnr;

/**
 * 汇付操作类型 --
 * 说明同PnrStatus
 *
 * @author WilliamSang
 * @date 2018/11/14 13:55
 * @modifyHistory
 * 2018/11/14 仅存入资金操作
 */
public enum PnrOperationType {

    // 资金操作
    BILL_TO_FROZEN("bl_ot_fz", "从冻结金额中转出", "to_frozen"),
    BILL_TI_BALANCE("bl_in", "转入到余额", "ti_balance"),
    BILL_FREEZE("bl_fz", "冻结", "freeze"),
    BILL_TO_BALANCE("bl_ot", "从余额转出", "to_balance"),
    BILL_UNFREEZE("bl_ufz", "解冻", "unfreeze"),
    ;

    private String abbr;
    private String cnDes;
    private String full;

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getCnDes() {
        return cnDes;
    }

    public void setCnDes(String cnDes) {
        this.cnDes = cnDes;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    PnrOperationType(String abb, String cnDes, String full) {
        this.abbr = abb;
        this.cnDes = cnDes;
        this.full = full;
    }
}
