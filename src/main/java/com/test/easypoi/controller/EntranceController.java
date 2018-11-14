package com.test.easypoi.controller;

import com.test.easypoi.service.IExcelService;
import com.test.easypoi.service.ILoanService;
import com.test.easypoi.service.ITransferApplyService;
import com.test.easypoi.util.CommonUtil;
import com.test.easypoi.util.DateUtil;
import com.test.easypoi.util.entity.excel.TransferApplyExcelBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 入口
 *
 * @author SangXiaolong
 * @date 2018/11/13 13:36
 */
@Controller
@RequestMapping("/dragon")
public class EntranceController {
    @Autowired
    IExcelService excelService;
    @Autowired
    ILoanService loanService;
    @Autowired
    ITransferApplyService transferApplyService;

    private List<String> downloadClassList = Arrays.asList("loan", "transfer");

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/poidownload")
    public void downloadExcel(HttpServletResponse response) {
        excelService.downloadTest(response);
    }

    @RequestMapping("/loan")
    public String toLoan() {
        return "loan";
    }

    @RequestMapping("/transfer")
    public String toTransferApply() {
        return "transferApply";
    }

    /**
     * 下载入口
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param request : 请求
     * @param response : 响应
     * @return : void
     * @modifyHistory
     */
    @RequestMapping("/downloadExcel")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response) {

        Map<String, String[]> parameterMap = request.getParameterMap();

        String downloadClass = CommonUtil.getSafeParam(parameterMap, "downloadClass");
        int index = downloadClassList.indexOf(downloadClass);
        if (index == 0) {
            // loan
            String longestDateStr = CommonUtil.getSafeParam(parameterMap, "longestDate");

            Date longestDate = getRequestDate(longestDateStr);

            excelService.downloadLoan(longestDate, response);
        } else if (index == 1) {
            // transfer
            String item = CommonUtil.getSafeParam(parameterMap, "item");
            String userIds = CommonUtil.getSafeParam(parameterMap, "userIds");
            String transferDateStr = CommonUtil.getSafeParam(parameterMap, "transferDate");

            Date transferDate = getRequestDate(transferDateStr);

            excelService.downloadTransferApply(item, userIds, transferDate, response);
        }
    }

    /**
     * 把String类型的时间转换成时间格式（格式为yyyy-mm-dd）
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param dateStr : 时间字符
     * @return : java.util.Date 时间对象
     * @modifyHistory
     */
    private Date getRequestDate(String dateStr) {
        Date date = null;
        if (StringUtils.isNotBlank(dateStr)) {
            try {
                date = DateUtil.getLowerYearMonthDay(dateStr);
            } catch (ParseException e) {
                System.err.println("没有日期");
            }
        }
        return date;
    }
}
