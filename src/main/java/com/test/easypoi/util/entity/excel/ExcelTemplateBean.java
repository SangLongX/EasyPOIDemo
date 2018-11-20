package com.test.easypoi.util.entity.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * easyPoi测试demo
 *
 * @author WilliamSang
 * @date 2018/11/13 14:13
 */
public class ExcelTemplateBean {
    @Excel(name = "primary", orderNum = "0")
    private String id;
    @Excel(name = "name", orderNum = "1")
    private String name;
    @Excel(name = "des", orderNum = "2")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
