package com.test.easypoi.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * @author: WilliamSang
 * @project easypoi
 * @package com.test.easypoi.pojo
 * @email williamsang@yeah.net
 * @date: 2019/5/20 10:07
 * @modifyHistory: <br/>
 * --------------<br/>
 */
@Data
public class Wheel {
    @Excel(name = "品牌", orderNum = "0")
    private String brand;
    @Excel(name = "原料")
    private String material;
    @Excel(name = "价格")
    private Double price;
    @Excel(name = "出厂日期")
    private Date outComDate;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getOutComDate() {
        return outComDate;
    }

    public void setOutComDate(Date outComDate) {
        this.outComDate = outComDate;
    }

    public Wheel(String brand, String material, Double price, Date outComDate) {
        this.brand = brand;
        this.material = material;
        this.price = price;
        this.outComDate = outComDate;
    }

    public Wheel() {
    }
}
