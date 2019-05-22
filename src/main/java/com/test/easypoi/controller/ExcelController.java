package com.test.easypoi.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.test.easypoi.pojo.Wheel;
import com.test.easypoi.service.IExcelService;
import com.test.easypoi.service.WheelService;
import com.test.easypoi.util.em.WheelEnum;
import com.test.easypoi.util.generic.CommonUtil;
import com.test.easypoi.util.generic.DateUtil;
import com.test.easypoi.util.generic.ExcelUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import static com.test.easypoi.util.generic.MagicElements.GENERIC_EXCEL;
import static com.test.easypoi.util.generic.MagicElements.LOAN_EXCEL;
import static com.test.easypoi.util.generic.MagicElements.TRANSFER_EXCEL;

/**
 * @author: WilliamSang
 * @project easypoi
 * @package com.test.easypoi.controller
 * @email williamsang@yeah.net
 * @date: 2019/5/22 11:40
 * @modifyHistory: <br/>
 * --------------<br/>
 */
@Controller
public class ExcelController {
    @Autowired
    IExcelService excelService;
    @Autowired
    private WheelService wheelService;

    private final String SUFFIX_2003 = "xls";
    private final String SUFFIX_2007 = "xlsx";

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

    @PostMapping("/importExcel")
    public String importExcel(@RequestParam("excelFile") MultipartFile file) {
        ImportParams importParams = new ImportParams();
        // 需要验证
        importParams.setNeedVerfiy(false);
        try {
            ExcelImportResult<Wheel> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Wheel.class,
                                                                              importParams);
            List<Wheel> userList = result.getList();
            for (Wheel tempU : userList) {
                System.out.println("从Excel导入数据到数据库的详细为 ：{}" + tempU);
                //TODO 将导入的数据做保存数据库操作
            }
            System.out.println("从Excel导入数据一共 {} 行 " + userList.size());
        } catch (IOException e) {
            System.out.println("导入失败：{}" + e.getMessage());
        } catch (Exception e1) {
            System.out.println("导入失败：{}" + e1.getMessage());
        }
        return "导入成功";
    }

    @PostMapping("/importExcel2")
    public String importExcel2(@RequestParam("excelFile") MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        Workbook workbook = null;
        List<Wheel> list = new ArrayList();
        try {
            if (originalFilename.endsWith(SUFFIX_2003)) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (originalFilename.endsWith(SUFFIX_2007)) {
                workbook = new XSSFWorkbook(file.getInputStream());
            }
            list = ExcelUtil.parseExcel(WheelEnum.BRAND, workbook);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(list!=null && list.size()>0) {
            for (Wheel tempW :
                    list) {
                wheelService.saveOrUpdate(tempW);
            }
        }
        return "index";
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
