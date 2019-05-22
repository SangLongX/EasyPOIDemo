package com.test.easypoi.util.generic;

import com.test.easypoi.util.em.IExcelEnum;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 通用excel转化工具
 *
 * @author: WilliamSang
 * @project easypoi
 * @package com.test.easypoi.util.generic
 * @email williamsang@yeah.net
 * @date: 2019/5/21 13:25
 * @modifyHistory: <br/>
 * --------------<br/>
 */
public class ExcelUtil {
    /**
     * 解析excel文件，转换成对象list
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @param enu : 带对象泛型的enum（任意选一个即可）
     * @param workbook : excel的workbook
     * @return : java.util.List 对象list
     * @modifyHistory
     */
    public static List parseExcel(IExcelEnum enu, Workbook workbook) {
        // 获取泛型对象类型
        Class clazz = enu.getTClass();
        if (clazz == null) {
            throw new RuntimeException("没有对应关系");
        }
        if (workbook == null) {
            throw new RuntimeException("无数据");
        }
        // 结果list，现定位多个sheet的数据格式相同，如修改成多种格式，需要做变动！！！
        List resultList = new ArrayList();
        try {
            // 获取所有enum
            IExcelEnum[] allValues = enu.getAllValues();
            // 解析workbook
            // sheet个数
            int numOfSheet = workbook.getNumberOfSheets();
            // 遍历sheet
            for (int sheetNo = 0; sheetNo < numOfSheet; sheetNo++) {
                //获取一个sheet也就是一个工作簿
                Sheet sheet = workbook.getSheetAt(sheetNo);
                int lastRowNum = sheet.getLastRowNum();
                //从第一行开始第一行一般是标题
                for (int colNo = 1; colNo <= lastRowNum; colNo++) {
                    // 构造新实例
                    Row row = sheet.getRow(colNo);
                    Object o = clazz.newInstance();
                    resultList.add(o);
                    for (int rowNo = 0; rowNo < row.getLastCellNum();rowNo++){
                        if (row.getCell(colNo) != null) {
                            try {
                                setValue(o, allValues[rowNo], row.getCell(rowNo));
                            } catch (NoSuchFieldException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * 根据cell，填充对象属性
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @param obj : 目标对象
     * @param iEnum : 对应的enum类型
     * @param cell : 单元格
     * @return : void
     * @modifyHistory
     */
    public static void setValue(Object obj, IExcelEnum iEnum, Cell cell) throws NoSuchFieldException, IllegalAccessException {
        if (obj == null || iEnum == null || cell == null) {
            return;
        }

        Object filedValue = null;
        if (String.class.isAssignableFrom(iEnum.getPropertyClazz())) {
            filedValue = cell.getStringCellValue();
        } else if(Date.class.isAssignableFrom(iEnum.getPropertyClazz())) {
            filedValue = cell.getDateCellValue();
        } else if(Boolean.class.isAssignableFrom(iEnum.getPropertyClazz())) {
            filedValue = cell.getBooleanCellValue();
        } else if(Number.class.isAssignableFrom(iEnum.getPropertyClazz())) {
            filedValue = cell.getNumericCellValue();
        }
        ObjectUtil.castSet(obj, iEnum.getProperty(), filedValue);
    }
}
