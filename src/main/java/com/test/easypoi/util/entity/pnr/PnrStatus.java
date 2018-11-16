package com.test.easypoi.util.entity.pnr;

/**
 * 汇付状态 --
 * abbr 是要传递的值（简写）
 * cnDes 是要显示的中文信息（中文描述）
 * full 是数据库真实值（全称）
 *
 * @author WilliamSang
 * @date 2018/11/14 11:09
 */
public enum PnrStatus {
    // 智投
    WISDOM_SUCCESS("wz_ss", "审核通过", "adopt"),
    WISDOM_COMPLETE("wz_cp", "完成", "complete"),
    WISDOM_FAIL("wz_vf_fl", "审核驳回", "fail"),
    WISDOM_VERIFYING("wz_vf", "审核中", "to_examine"),

    // 智投投资
    INVEST_WZ_RECHARGE_FAIL("wi_rc_fl", "智投充值失败", "recharge_fail"),
    INVEST_WZ_RECHARGE_SUCCESS("wi_rc_ss", "智投充值成功", "recharge_success"),
    INVEST_WZ__SUCCESS("wi_ss", "加入成功", "wisdom_success"),
    INVEST_WZ_WAIT_AFFIRM("wi_af", "等待确认", "wait_affirm"),

    // 还款
    REPAYING("rp", "还款中", "repaying"),
    REPAY_BAD_DEBT("rp_bd", "坏账", "bad_debt"),
    REPAY_COMPLETE("rp_cp", "完成", "complete"),
    REPAY_OVERDUE("rp_od", "逾期", "overdue"),
    REPAY_WAIT_REPAY_VERIFY("rp_wt_cf", "等待还款确认", "wait_repay_verify"),
    REPAY_COMPENSATORY("rp_cpst", "代偿", "compensatory"),

    // 标的
    LOAN_BD("ln_bd", "坏账", "bad_debt"),
    LOAN_RECHECK("ln_rc", "等待复核", "recheck"),
    LOAN_VERIFY_FAIL("ln_vf_fl", "审核未通过", "verify_fail"),
    LOAN_OVERDUE("ln_od", "逾期", "overdue"),
    LOAN_WITHDRAW("ln_wd", "撤标", "withdrawal"),
    LOAN_PUBLICY("ln_pub", "贷前公示", "dqgs"),
    LOAN_WAITING_RAISE("ln_wt_rz", "等待发布", "waiting_raise"),
    LOAN_CANCEL("ln_cc", "流标", "cancel"),
    LOAN_WAITING_VERIFY("ln_wt_vf", "等待审核", "waiting_verify"),
    LOAN_RAISING("ln_rz", "筹款中", "raising"),
    LOAN_COMPLETE("ln_ct", "完成", "complete"),
    LOAN_REPAYING("ln_rp", "还款中", "repaying"),
    LOAN_WAITING_CANCEL_AFFIRM("ln_wt_cc_af", "流标后等待资金托管方确认", "waiting_cancel_affirm"),
    LOAN_WAITING_RECHECK_VERIFY("ln_wt_rc", "放款后等待资金托管方确认", "waiting_recheck_verify"),
    LOAN_WAITING_VERIFY_AFFIRM("ln_wt_vf_af", "审核后等待资金托管确认", "waiting_verify_affirm"),
    LOAN_WAITING_VERIFY_AFFIRM_USER("ln_wt_vf_af_uz", "审核后等待资金托管方用户确认", "waiting_verify_affirm_user"),
    LOAN_WAIT_REPAY_VERIFY("ln_wt_rp_vf", "提前还款等待资金托管方确认", "wait_repay_verify"),

    // 投资
    INVEST_COMPLETE("iv_cp", "完成", "complete"),
    INVEST_WAIT_LOANING_VERIFY("iv_wt_ln", "资金托管放款确认中", "wait_loaning_verify"),
    INVEST_CANCEL("iv_cc", "流标", "cancel"),
    INVEST_BAD_DEBT("iv_bd", "坏账", "bad_debt"),
    INVEST_WAIT_AFFIRM("iv_wt", "资金托管确认中", "wait_affirm"),
    INVEST_OVERDUE("iv_od", "逾期", "overdue"),
    INVEST_WITHDRAW("iv_wd", "撤标", "withdrawal"),
    INVEST_SUCCESS("iv_ss", "投标成功", "bid_success"),
    INVEST_REPAYING("iv_rp", "还款中", "repaying"),

    // 充值
    RECHARGE_WAIT_PAY("rc_wt", "等待付款", "wait_pay"),
    RECHARGE_SUCCESS("rc_ss", "充值成功", "success"),
    RECHARGE_FAIL("rc_fl", "充值失败", "fail"),

    // 取现
    WITHDRAW_RECHECK("wd_rc", "等待复核", "recheck"),
    WITHDRAW_WAIT_VERIFY("wd_wt_vf", "等待审核", "wait_verify"),
    WITHDRAW_VERIFY_FAIL("wd_vf_fl", "审核未通过", "verify_fail"),
    WITHDRAW_WAIT_HUIFU_VERIFY ("wd_wt_hf_vf", "等待汇付审核", "wait_huifu_verify "),
    WITHDRAW_SUCCESS("wd_ss", "提现成功", "success"),

    // 操作状态
    OPERATION_PASSED("op_ps", "完成", "passed"),
    OPERATION_UN_SEND("op_un_sd", "未发送", "un_send"),
    OPERATION_NO_RESPONSE("op_no_rp", "无响应", "no_response"),
    OPERATION_SENDED("op_sd", "已发送", "sended"),
    OPERATION_REFUSED("op_rf", "拒绝", "refused"),
    OPERATION_CANCEL("op_cc", "取消", "cancel"),

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

    PnrStatus(String abb, String cnDes, String full) {
        this.abbr = abb;
        this.cnDes = cnDes;
        this.full = full;
    }
}


