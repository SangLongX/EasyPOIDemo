package com.test.easypoi.util.generic;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: WilliamSang
 * @project common-test
 * @package com.sa.util
 * @email williamsang@yeah.net
 * @date: 2019/5/20 18:27
 * @modifyHistory: <br/>
 * --------------<br/>
 */
public class ObjectUtil {
    /**
     * 拷贝对象属性到指定对象，调用方法后，target就会被更新
     *
     * @author SangXiaolong
     * @date 2019/1/11
     * @param source : 得到的对象
     * @param target : 要被更新的对象
     * @return : void
     * @modifyHistory
     */
    public static void copyPropertiesIgnoreNull(Object source, Object target) {
        List<String> nullPropertyNames = getNullPropertyNames(source, null);
        BeanUtils.copyProperties(source, target, ((nullPropertyNames!=null&&nullPropertyNames.size()>0)? nullPropertyNames.toArray(new String[nullPropertyNames.size()]):null));
    }
    /**
     * 排除策略 - 排除null成员变量
     *
     * @author SangXiaolong
     * @date 2019/1/11
     * @param source :
     * @param exclusions :
     * @return : java.lang.String[]
     * @modifyHistory
     */
    public static List<String> getNullPropertyNames(Object source, List<String> exclusions) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            String name = pd.getName();
            if (exclusions!=null && exclusions.contains(name)){
                break;
            }
            Object srcValue = src.getPropertyValue(name);
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        return new ArrayList<>(emptyNames);
    }

    /**
     * 反射get方法
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @param obj : 对象
     * @param filedName : 成员变量名
     * @return : java.lang.Object
     * @modifyHistory
     */
    public static Object castGet(Object obj , String filedName) throws NoSuchFieldException, IllegalAccessException {
        Field declaredField = obj.getClass().getDeclaredField(filedName);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    /**
     * 反射set方法
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @param obj : 对象
     * @param filedName : 成员变量名
     * @param value : 成员变量值
     * @return : void
     * @modifyHistory
     */
    public static void castSet(Object obj, String filedName, Object value) throws IllegalAccessException, NoSuchFieldException {
        if (obj == null) {
            return;
        }
        Field declaredField = obj.getClass().getDeclaredField(filedName);
        declaredField.setAccessible(true);
        declaredField.set(obj, value);
    }

    /**
     * 反射成员变量类型
     *
     * @author WilliamSang
     * @date 2019/5/21
     * @param obj : 对象
     * @param filedName : 成员变量名
     * @return : java.lang.Class
     * @modifyHistory
     */
    public static Class castGetClazz(Object obj, String filedName) throws NoSuchFieldException, IllegalAccessException {
        Object o = castGet(obj, filedName);
        return o == null ? null : o.getClass();
    }

}
