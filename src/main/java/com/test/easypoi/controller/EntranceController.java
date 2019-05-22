package com.test.easypoi.controller;

import com.test.easypoi.service.IExcelService;
import com.test.easypoi.util.generic.MagicElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.test.easypoi.util.generic.MagicElements.*;

/**
 * 入口 --
 *
 * @author WilliamSang
 * @date 2018/11/13 13:36
 */
@Controller
@RequestMapping
public class EntranceController {
    @Autowired
    IExcelService excelService;


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

    @RequestMapping("/excel/import")
    public String toImportExcel() {
        return "importExcel";
    }

}
