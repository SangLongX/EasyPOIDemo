package com.test.easypoi.controller;

import com.test.easypoi.service.IExcelService;
import com.test.easypoi.service.ILoanService;
import com.test.easypoi.service.ITransferApplyService;
import com.test.easypoi.util.generic.CommonUtil;
import com.test.easypoi.util.generic.DateUtil;
import com.test.easypoi.util.generic.MagicElements;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.*;

import static com.test.easypoi.util.generic.MagicElements.*;

/**
 * 入口 --
 * 未注释的方法为跳转页面
 *
 * @author WilliamSang
 * @date 2018/11/13 13:36
 */
@Controller
@RequestMapping("/bdjr")
public class EntranceController {
    @Autowired
    IExcelService excelService;
    @Autowired
    ILoanService loanService;
    @Autowired
    ITransferApplyService transferApplyService;


    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/excel/fixed")
    public String toFixedExcel() {
        return "fixedExcel";
    }

    @RequestMapping("/excel/generic")
    public String toGenericExcel(Model model) {
        Map<String, List> map = new HashMap<>(1);
        List<MagicElements> magicElements = Arrays.asList(SQL_TRANSFER, SQL_LOAN);
        map.put("selectItems", magicElements);
        model.addAllAttributes(map);
        return "excelSelect";
    }

    @RequestMapping("/excel/genericExport")
    public String toGenericExcelSearch(Model model, HttpServletRequest request) {
        String sql = request.getParameter("sql");

        List<String> emptyList = excelService.getEmptyList(sql, "?");
        String queryStr = emptyList.remove(emptyList.size() - 1);
        model.addAttribute("listData", emptyList);
        model.addAttribute("queryStr", queryStr);
        return "excelSearch";
    }

    /**
     * 下载入口
     *
     * @param request  : 请求
     * @param response : 响应
     * @return : void
     * @author WilliamSang
     * @date 2018/11/13
     * @modifyHistory
     */
    @RequestMapping("/downloadExcel")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response) {

        Map<String, String[]> parameterMap = new HashMap<>(request.getParameterMap());

        String downloadClass = CommonUtil.getSafeParamAndRemove(parameterMap, "downloadClass");
        if (LOAN_EXCEL.getFull().equals(downloadClass)) {
            // loan
            String longestDateStr = CommonUtil.getSafeParam(parameterMap, "longestDate");
            Date longestDate = getRequestDate(longestDateStr);

            excelService.downloadLoan(longestDate, response);
        } else if (TRANSFER_EXCEL.getFull().equals(downloadClass)) {
            // transfer
            String item = CommonUtil.getSafeParam(parameterMap, "item");
            String userIds = CommonUtil.getSafeParam(parameterMap, "userIds");
            String transferDateStr = CommonUtil.getSafeParam(parameterMap, "transferDate");
            Date transferDate = getRequestDate(transferDateStr);

            excelService.downloadTransferApply(item, userIds, transferDate, response);
        } else if (GENERIC_EXCEL.getFull().equals(downloadClass)) {
            // generic
            String paramStr = CommonUtil.getSafeParamAndRemove(parameterMap, "paramStr");
            List<String> dataList = new ArrayList<>();
            for (int i = 0; i < parameterMap.values().size(); i++) {
                dataList.add(CommonUtil.getSafeParam(parameterMap, "col"+i));
            }
            excelService.downloanGeneric(dataList, paramStr, response);
        }
    }

    /**
     * 把String类型的时间转换成时间格式（格式为yyyy-mm-dd）
     *
     * @param dateStr : 时间字符
     * @return : java.util.Date 时间对象
     * @author WilliamSang
     * @date 2018/11/13
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
