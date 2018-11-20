package com.test.easypoi.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import com.test.easypoi.mapper.UserMapper;
import com.test.easypoi.pojo.UserWithBlobs;
import com.test.easypoi.service.IExcelService;
import com.test.easypoi.service.ILoanService;
import com.test.easypoi.service.ITransferApplyService;
import com.test.easypoi.util.entity.excel.ExcelTemplateBean;
import com.test.easypoi.util.entity.excel.TransferApplyExcelBean;
import com.test.easypoi.util.entity.excel.LoanExcelBean;
import com.test.easypoi.util.generic.MagicElements;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static com.test.easypoi.util.generic.MagicElements.SQL_LOAN;
import static com.test.easypoi.util.generic.MagicElements.SQL_TRANSFER;

/**
 * 导出excel 实现
 *
 * @author WilliamSang
 * @date 2018/11/13 13:42
 */
@Service
public class ExcelServiceImpl implements IExcelService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    ILoanService loanService;
    @Autowired
    ITransferApplyService transferApplyService;



    @Override
    public void downloadTest(HttpServletResponse response) {
        UserWithBlobs userWithBLOBs = userMapper.selectByPrimaryKey("18300000020");
        System.out.println(userWithBLOBs.getUsername());
        System.out.println(userWithBLOBs.getMobileNumber());

        download(response);
    }

    private void download(HttpServletResponse response) {
        int line = 10000;
        List<ExcelTemplateBean> list = new ArrayList<ExcelTemplateBean>();
        //单sheet默认最多保存6万行数据，如果超过导出上限会自动创建sheet（讲道理应该可以自定义）
        for(int i=0 ; i<line; i++) {
            ExcelTemplateBean poiVo = new ExcelTemplateBean();
            poiVo.setId(i+"");
            poiVo.setName(i+"name");
            poiVo.setDescription(i+"des");
            list.add(poiVo);
        }

        //指定列表标题和工作表名称
        ExportParams params = new ExportParams("测试通过EasyPoi导出Excel","POI-Sheet");
        params.setCreateHeadRows(true);
        Workbook workbook = ExcelExportUtil.exportExcel(params, ExcelTemplateBean.class,list);
        response.setHeader("content-Type","application/vnd.ms-excel");
        response.setHeader("Content-Disposition","attachment;filename="+System.currentTimeMillis()+".xls");
        response.setCharacterEncoding("UTF-8");
        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downloadLoan(Date lonestDate, HttpServletResponse response) {
        List<LoanExcelBean> loanExcel = loanService.findLoanExcel(lonestDate);

        String fileName = "loan";

        try {
            download(fileName, null, null, LoanExcelBean.class, loanExcel, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void downloadTransferApply(String toWhere, String userIds, Date transferDate, HttpServletResponse response) {
        List<TransferApplyExcelBean> transferApplyExcel = transferApplyService.findTransferApplyExcel(toWhere, transferDate, userIds);

        String fileName = "transfer";

        try {
            download(fileName, null, null, TransferApplyExcelBean.class, transferApplyExcel, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载excel
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param fileName : excel文件名
     * @param sheetName : sheet名
     * @param excelTitle : excel标题
     * @param clazz : excel bean的clazz
     * @param dataList : excel bean list
     * @param response : 响应
     * @return : void
     * @modifyHistory
     */
    private void download(String fileName, String sheetName, String excelTitle, Class clazz, List dataList, HttpServletResponse response) throws IOException {
        ExportParams params = new ExportParams(excelTitle,sheetName);
        params.setCreateHeadRows(true);
        Workbook workbook = ExcelExportUtil.exportExcel(params, clazz,dataList);
        response.setHeader("content-Type","application/vnd.ms-excel");
        response.setHeader("Content-Disposition","attachment;filename="+fileName+".xls");
        response.setCharacterEncoding("UTF-8");
        workbook.write(response.getOutputStream());
        workbook.close();
    }


    @Override
    public List<String> getEmptyList(String abbr, String symbol) {
        MagicElements element = null;
        if (SQL_LOAN.getAbbr().equals(abbr)) {
            element = SQL_LOAN;
        } else if (SQL_TRANSFER.getAbbr().equals(abbr)) {
            element = SQL_TRANSFER;
        }
        if (element == null) {
            return null;
        }
        List numberList = getNumberList(element, '?');
        numberList.add(element.getFull());
        return numberList;
    }

    private List<String> getNumberList(MagicElements element, char symbol) {
        List list = new ArrayList();
        String srcText = element.getFull();
        char[] chs = srcText.toCharArray();
        // 定义变量count存储字符串出现次数
        int count = 0;
        for(int i = 0;i < chs.length;i++) {
            if(chs[i] == symbol) {
                list.add(count+"");
                count++;
            }
        }
        return list;
    }

    @Override
    public void downloanGeneric(List<String> dataList, String paramStr, HttpServletResponse response) {
        List<Map<String, Object>> resultList = loanService.findGenericExcel(dataList, paramStr);

        if (resultList== null || resultList.size() < 1) {
            try {
                alert("无数据", response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        try {
            downloadGenerict(resultList, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void alert(String message, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.flush();
        out.println("<script>");
        out.println("alert('"+message+"');");
        out.println("history.back();");
        out.println("</script>");
    }

    public void downloadGenerict(List<Map<String, Object>> data, HttpServletResponse response) throws IOException {
        List<ExcelExportEntity> colList = new ArrayList<ExcelExportEntity>();
        
        if ( data == null || data.size() < 1) {
            throw new RuntimeException("无数据");
        }
        Set<String> samplekeys = data.get(0).keySet();
        for (String str :
                samplekeys) {
            ExcelExportEntity entity = new ExcelExportEntity(str, str);
            colList.add(entity);
        }


        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(null, null), colList,
                data);
        response.setHeader("content-Type","application/vnd.ms-excel");
        response.setHeader("Content-Disposition","attachment;filename="+new String("数据".getBytes(),"iso-8859-1")+".xls");
        response.setCharacterEncoding("UTF-8");
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
