package com.test.easypoi.service;

import com.test.easypoi.util.entity.excel.LoanExcelBean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 标的service
 *
 * @author SangXiaolong
 * @date 2018/11/13 16:07
 */
public interface ILoanService {

    /**
     * 查询截至到指定日期所有标的
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param finalDate : 最大时间
     * @return : java.util.List<com.test.easypoi.util.entity.excel.LoanExcelBean> 标的的excel bean list
     * @modifyHistory
     */
    List<LoanExcelBean> findLoanExcel(Date finalDate)
            ;

    /**
     * excel导出的通用查询方法
     *
     * @author SangXiaolong
     * @date 2018/11/16
     * @param values : 参数
     * @param paramStr : sql
     * @return : java.util.List<java.util.Map<java.lang.String,java.lang.Object>> 数据
     * @modifyHistory
     */
    List<Map<String, Object>> findGenericExcel(List<String> values, String paramStr)
            ;
}
