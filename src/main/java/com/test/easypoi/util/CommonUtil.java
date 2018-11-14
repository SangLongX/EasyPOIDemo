package com.test.easypoi.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 常用的工具类
 *
 * @author SangXiaolong
 * @date 2018/11/13 16:47
 */
public class CommonUtil {

    /**
     * 简便获取request parameterMap的value
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param paramMap : parameterMap
     * @param key : 键
     * @return : java.lang.String 值
     * @modifyHistory
     */
    public static String getSafeParam(Map<String, String[]> paramMap, String key) {
        if (StringUtils.isBlank(key) || paramMap == null) {
            return null;
        }
        String[] strs = paramMap.get(key);
        if (strs == null || strs.length < 1) {
            return null;
        }
        return strs[0];
    }
}
