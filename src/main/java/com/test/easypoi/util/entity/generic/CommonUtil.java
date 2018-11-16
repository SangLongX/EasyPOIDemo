package com.test.easypoi.util.entity.generic;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.test.easypoi.util.entity.generic.MagicElements.EMPTY_VAL;

/**
 * 常用的工具类
 *
 * @author WilliamSang
 * @date 2018/11/13 16:47
 */
public class CommonUtil {

    /**
     * 简便获取request parameterMap的value
     *
     * @author WilliamSang
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
        return getSafeFirstString(strs);
    }

    public static String getSafeParamAndRemove(Map<String, String[]> paramMap, String key) {
        if (StringUtils.isBlank(key) || paramMap == null) {
            return null;
        }
        String[] strs = paramMap.remove(key);
        return getSafeFirstString(strs);
    }

    public static String getSafeFirstString(String[] arg) {
        if (arg == null || arg.length < 1) {
            return null;
        }
        return arg[0];
    }

    public static String replaceString(String originalStr, String symbol, List<String> replaceList) {
        if (!originalStr.contains(symbol)) {
            return originalStr;
        }
        StringBuffer sb = new StringBuffer(originalStr);
        List<Integer> positions = searchAllIndex(originalStr, symbol);
        for (int c = 0; c < positions.size(); c++) {
            try {
                sb.replace(positions.get(c), positions.get(c)+1, replaceList.get(c));
            } catch (Exception e) {
                System.err.println(e.getMessage());
                break;
            }
        }
        return sb.toString();
    }

    public static int validateCollectionCount(Collection collection) {
        int count = 0;
        for (Object obj :
                collection) {
            if (obj != null && !obj.toString().equals(EMPTY_VAL.getAbbr())) {
                count ++;
            }
        }
        return count;
    }

    public static List<Integer> searchAllIndex(String str, String symbol) {
        List<Integer> positionList = new ArrayList<>();
        int aa = str.indexOf(symbol);
        boolean ab = (('?'+"")=="?");
        if (str.indexOf(symbol) == -1) {
            return null;
        }
        int tempPosi = -1;
        for (int i = str.indexOf(symbol); i < str.length(); ) {
            if ((str.charAt(i)+"").equals(symbol)) {
                positionList.add(i);
                tempPosi = str.indexOf(symbol, i+1);
            }
            i++;
            i = tempPosi != -1 ? tempPosi : i;
        }
        return positionList;
    }
}
