package com.test.easypoi.provider;

import com.test.easypoi.util.generic.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

import static com.test.easypoi.util.generic.MagicElements.SQL_SYMBOL;

/**
 * 标的provider
 *
 * @author WilliamSang
 * @date 2018/11/13 14:18
 */
public class LoanInfoProvider {

    /**
     * 查询在一定时间内的标的excel
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param finalDate : 最大期限
     * @return : java.lang.String sql语句
     * @modifyHistory
     */
    public String findLoanExcelData(@Param("finalDate") Date finalDate) {
        String sql = "SELECT l.`id` loanId,l.`name` loanName,u.id investUserId,u.`realname` investUserName,u.`id_card` investUserIdCard,ir.`corpus` investRepayCorpus,ir.`interest` investRepayInterest,i.`time` investTime," +
                "CASE ir.`status` WHEN 'repaying' THEN '还款中' WHEN 'bad_debt' THEN '坏账' WHEN 'complete' THEN '完成' WHEN 'overdue' THEN '逾期' WHEN 'wait_repay_verify' THEN '等待还款确认' WHEN 'compensatory' THEN '代偿' ELSE '未指定' END investRepayStatus " +
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

    /**
     * 通用导出excel
     *
     * @author WilliamSang
     * @date 2018/11/16
     * @param sql :sql语句
     * @param params : 参数
     * @return : java.lang.String 拼装好的sql语句
     * @modifyHistory
     */
    public String findGenericData(@Param("sql") String sql,@Param("data") List<String> params) {
        if (StringUtils.isBlank(sql)) {
            throw new RuntimeException("没有对应的sql");
        }

        String s = CommonUtil.replaceString(sql, "?", params);
        String symbol = SQL_SYMBOL.getFull();
        if (s.indexOf(symbol)!=-1) {
            int devideIndex = s.indexOf(symbol);
            s = s.split(symbol)[0].split("AND")[0];
        }
        return s;
    }
}
