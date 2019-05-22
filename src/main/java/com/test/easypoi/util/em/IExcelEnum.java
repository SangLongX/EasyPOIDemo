package com.test.easypoi.util.em;

/**
 * excel enum的通用接口
 *
 * @author: WilliamSang
 * @project easypoi
 * @package com.test.easypoi.em
 * @email williamsang@yeah.net
 * @date: 2019/5/21 13:31
 * @modifyHistory: <br/>
 * --------------<br/>
 */
public interface IExcelEnum<T> {
    /**
     * 获取泛型的类型
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @return : java.lang.Class<T>
     * @modifyHistory
     */
    Class<T> getTClass()
            ;

    /**
     * 成员变量order getter
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @return : int
     * @modifyHistory
     */
    int getOrder()
            ;

    /**
     * 成员变量 property getter
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @return : java.lang.String
     * @modifyHistory
     */
    String getProperty()
            ;

    /**
     * 成员变量 propertyClazz getter
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @return : java.lang.Class
     * @modifyHistory
     */
    Class getPropertyClazz()
            ;

    /**
     * 获取所有 enum
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @return : com.test.easypoi.em.IEnum<T>[]
     * @modifyHistory
     */
    IExcelEnum<T>[] getAllValues()
            ;

}