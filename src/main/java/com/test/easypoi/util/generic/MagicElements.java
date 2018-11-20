package com.test.easypoi.util.generic;

/**
 * 魔法值 --
 * 即固定值
 *
 * @author SangXiaolong
 * @date 2018/11/15 15:17
 */
public enum  MagicElements {
    // 常用
    NULL_VAL("null", "一些表单的默认数据", "null"),
    EMPTY_VAL("", "空值", ""),

    // 页面
    LOAN_EXCEL("0", "标的", "loan"),
    TRANSFER_EXCEL("1", "债转", "transfer"),
    GENERIC_EXCEL("2", "通用", "generic"),

    // sql
    SQL_SYMBOL("?", "sql代替标志", "?"),
    SQL_TRANSFER("sl_tf", "债转", "SELECT inv.`user_id` investId,u.`realname` investUserName," +
            "CASE inv.`status` WHEN 'complete' THEN '完成' WHEN 'wait_loaning_verify' THEN '资金托管放款确认中' WHEN 'cancel' THEN '流标' " +
            "WHEN 'bad_debt' THEN '坏账' WHEN 'wait_affirm' THEN '资金托管确认中' WHEN 'overdue' THEN '逾期' " +
            "WHEN 'withdrawal' THEN '撤标' WHEN 'bid_success' THEN '投标成功' WHEN 'repaying' THEN '还款中' " +
            "ELSE '未指定' END investStatus,ta.`apply_time` transferBeginTime,ta.`corpus` transferCorpus,inv.`sourceOrderid` sourceOrderId " +
            "FROM invest inv " +
            "LEFT JOIN transfer_apply ta ON inv.`id`=ta.`invest_id` " +
            "LEFT JOIN USER u ON u.id = inv.`user_id` " +
            "WHERE inv.`id` IN (SELECT t.`invest_id` FROM transfer_apply t WHERE t.`id` IN " +
            "(SELECT i.`transfer_apply` FROM invest i " +
            "LEFT JOIN loan l ON l.id = i.`loan_id` " +
            "WHERE 1=1 AND l.`towhere` <> ? AND i.`user_id` in (?) AND i.time > '?'));"),
    SQL_LOAN("sq_ln",   "标的", "SELECT l.`id` loanId,l.`name` loanName,u.id investUserId,u.`realname` investUserName,u.`id_card` investUserIdCard,ir.`corpus` investRepayCorpus,ir.`interest` investRepayInterest,i.`time` investTime," +
            "CASE ir.`status` WHEN 'repaying' THEN '还款中' WHEN 'bad_debt' THEN '坏账' WHEN 'complete' THEN '完成' " +
            "WHEN 'overdue' THEN '逾期' WHEN 'wait_repay_verify' THEN '等待还款确认' WHEN 'compensatory' THEN '代偿' " +
            "ELSE '未指定' END investRepayStatus FROM invest_repay ir " +
            "LEFT JOIN invest i ON i.id = ir.`invest_id` " +
            "LEFT JOIN loan l ON l.id = i.`loan_id` " +
            "LEFT JOIN USER u ON u.id = i.`user_id` " +
            "WHERE 1=1 AND i.`time` < '?'")
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

    MagicElements(String abb, String cnDes, String full) {
        this.abbr = abb;
        this.cnDes = cnDes;
        this.full = full;
    }
}
