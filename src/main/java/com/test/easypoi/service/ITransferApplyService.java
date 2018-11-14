package com.test.easypoi.service;

import com.test.easypoi.util.entity.excel.TransferApplyExcelBean;

import java.util.Date;
import java.util.List;

/**
 * 债转service
 *
 * @author SangXiaolong
 * @date 2018/11/13 16:07
 */
public interface ITransferApplyService {
    /**
     * 查询债转信息
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param toWhere : 要排除的数据源
     * @param transferApplyStartTime : 债转开始时间
     * @param userIds : 用户id，多个用逗号分隔
     * @return : java.util.List<com.test.easypoi.util.entity.TransferApplyExcelBean> 债转的excel bean list
     * @modifyHistory
     */
    List<TransferApplyExcelBean> findTransferApplyExcel(String toWhere, Date transferApplyStartTime, String userIds)
            ;
}
