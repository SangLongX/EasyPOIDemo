package com.test.easypoi.service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 导出excel service
 *
 * @author SangXiaolong
 * @date 2018/11/13 13:42
 */
public interface IExcelService {
    /**
     * 测试 -- 下载
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param response :
     * @return : void
     * @modifyHistory
     */
    void downloadTest(HttpServletResponse response)
            ;
    /**
     * 下载标的excel
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param lonestDate : 最长时间
     * @param response : 响应
     * @return : void
     * @modifyHistory
     */
    void downloadLoan(Date lonestDate, HttpServletResponse response)
            ;

    /**
     * 下载债转excel
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param toWhere : 排除的数据源 0 - 百达； 1 - 富管家； 2 - 同城
     * @param userIds : 用户id，多个用逗号分隔
     * @param transferDate : 债转发起时间
     * @param response : 响应
     * @return : void
     * @modifyHistory
     */
    void  downloadTransferApply(String toWhere, String userIds, Date transferDate, HttpServletResponse response)
            ;
}
