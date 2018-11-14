package com.test.easypoi.util.entity.pnr;

/**
 * 汇付操作类型 --
 * 说明同PnrStatus
 *
 * @author SangXiaolong
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

    private String operation;
    private String operationVal;
    private String op;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperationVal() {
        return operationVal;
    }

    public void setOperationVal(String operationVal) {
        this.operationVal = operationVal;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    PnrOperationType (String operation, String operationVal, String op) {
        this.operation = operation;
        this.operationVal = operationVal;
        this.op = op;
    }
}
