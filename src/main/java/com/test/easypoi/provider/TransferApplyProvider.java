package com.test.easypoi.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 债转provider
 *
 * @author SangXiaolong
 * @date 2018/11/13 14:18
 */
public class TransferApplyProvider {

    private final String invalidString = "-1";
    private final String bdString = "0";
    /**
     * 查询需要导出的债转信息
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param toWhere : 要排除的数据来源 0 - 百达； 1 - 富管家； 2 - 同城
     * @param transferStartTime : 债转开始时间
     * @param investUserIds : 投资id（多个用，分割）
     * @return : java.lang.String sql语句
     * @modifyHistory
     */
    public String findTransferApplyExcelData(@Param("toWhere") String toWhere, @Param("transferStartTime") Date transferStartTime, @Param("userIds") String[] investUserIds) {
        String sql = "SELECT inv.`user_id` investId,u.`realname` investUserName,inv.`status` investStatus,ta.`apply_time` transferBeginTime,ta.`corpus` transferCorpus,inv.`sourceOrderid` sourceOrderId " +
                "FROM invest inv " +
                "LEFT JOIN transfer_apply ta ON inv.`id`=ta.`invest_id` " +
                "LEFT JOIN USER u ON u.id = inv.`user_id` " +
                "WHERE inv.`id` IN (SELECT t.`invest_id` FROM transfer_apply t WHERE t.`id` IN " +
                "(SELECT i.`transfer_apply` FROM invest i " +
                "LEFT JOIN loan l ON l.id = i.`loan_id` WHERE 1=1 "
                ;
        if (StringUtils.isNotBlank(toWhere) && !invalidString.equals(toWhere)) {
            if (bdString.equals(toWhere)) {
                sql += "AND l.`towhere` NOT IN ('1', '2')";
            } else {
                sql += "AND l.`towhere` <> #{toWhere} ";
            }
        }
        if (investUserIds != null && investUserIds.length > 0 && investUserIds[0] != null) {
            sql += "AND i.`user_id` IN (";
            for (String userId:
                 investUserIds) {
                sql += "'"+userId + "',";
            }
            sql = sql.substring(0,sql.length() - 1);
            sql += ")";
        }
        if (transferStartTime != null) {
            sql += "AND i.time > #{transferStartTime}";
        }
        sql += "))";
        return sql;
    }
}
