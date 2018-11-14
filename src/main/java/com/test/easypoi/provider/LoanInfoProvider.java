package com.test.easypoi.provider;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 标的provider
 *
 * @author SangXiaolong
 * @date 2018/11/13 14:18
 */
public class LoanInfoProvider {

    /**
     * 查询在一定时间内的标的excel
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param finalDate : 最大期限
     * @return : java.lang.String sql语句
     * @modifyHistory
     */
    public String findLoanExcelData(@Param("finalDate") Date finalDate) {
        String sql = "SELECT l.`id` loanId,l.`name` loanName,u.id investUserId,u.`realname` investUserName,u.`id_card` investUserIdCard,ir.`corpus` investRepayCorpus,ir.`interest` investRepayInterest,i.`time` investTime,ir.`status` investRepayStatus " +
                "FROM invest_repay ir " +
                "LEFT JOIN invest i ON i.id = ir.`invest_id` " +
                "LEFT JOIN loan l ON l.id = i.`loan_id` " +
                "LEFT JOIN USER u ON u.id = i.`user_id` "
                ;
        if (finalDate != null) {
            sql += "WHERE i.`time` < #{finalDate}";
        }
        return sql;
    }
}
