package com.test.easypoi.util.em;

import com.test.easypoi.pojo.Wheel;

import java.util.Date;

/**
 * demo enum 案例enum
 *
 * @author: WilliamSang
 * @project easypoi
 * @package com.test.easypoi.em
 * @email williamsang@yeah.net
 * @date: 2019/5/20 17:44
 * @modifyHistory: <br/>
 * --------------<br/>
 */
public enum WheelEnum implements IExcelEnum<Wheel> {
    /**
     * 品牌
     */
    BRAND(0, "brand", String.class),
    /**
     * 原料
     */
    MATERIAL(1, "material", String.class),
    /**
     * 价格
     */
    PRICE(2, "price", Double.class),
    /**
     * 出厂日期
     */
    OUTCOMDATE(3, "outComDate", Date.class)
    ;

    /**
     * 顺序： 对应到excel列元素的顺序
     */
    private int order;
    /**
     * 对应顺序的 对象属性
     */
    private String property;
    /**
     * 对应属性的类型，如String、Double等（注：基本数据类型用包装类型）
     */
    private Class propertyClazz;


    WheelEnum(int order, String property, Class propertyClazz) {
        this.order = order;
        this.property = property;
        this.propertyClazz = propertyClazz;
    }

    @Override
    public Class<Wheel> getTClass() {
        return Wheel.class;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public String getProperty() {
        return this.property;
    }

    @Override
    public Class getPropertyClazz() {
        return propertyClazz;
    }

    @Override
    public IExcelEnum<Wheel>[] getAllValues() {
        return values();
    }

    /**
     * 根据顺序，取出对应的enum
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @param order :
     * @return : com.test.easypoi.em.WheelEnum
     * @modifyHistory
     */
    public static WheelEnum getByKey(int order) {
        for (WheelEnum enu :
                WheelEnum.values()) {
            if (enu.getOrder() == order) {
                return enu;
            }
        }
        return null;
    }
}
