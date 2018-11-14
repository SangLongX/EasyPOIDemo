package com.test.easypoi.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.test.easypoi.mapper.UserMapper;
import com.test.easypoi.pojo.UserWithBlobs;
import com.test.easypoi.service.IExcelService;
import com.test.easypoi.service.ILoanService;
import com.test.easypoi.service.ITransferApplyService;
import com.test.easypoi.util.entity.excel.ExcelTemplateBean;
import com.test.easypoi.util.entity.excel.TransferApplyExcelBean;
import com.test.easypoi.util.entity.excel.LoanExcelBean;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 导出excel 实现
 *
 * @author SangXiaolong
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
     * @author SangXiaolong
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

}
