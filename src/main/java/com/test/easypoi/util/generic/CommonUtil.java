package com.test.easypoi.util.generic;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static com.test.easypoi.util.generic.MagicElements.EMPTY_VAL;

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
     * @return : java.lang.String 值， 默认null
     * @modifyHistory
     */
    public static String getSafeParam(Map<String, String[]> paramMap, String key) {
        if (StringUtils.isBlank(key) || paramMap == null) {
            return null;
        }
        String[] strs = paramMap.get(key);
        return getSafeFirstString(strs);
    }

    /**
     * 简便取出request parameterMap的value，并移除（map需要转换为可变map）
     *
     * @author WilliamSang
     * @date 2018/11/19
     * @param paramMap : parameterMap
     * @param key : 键（删除的）
     * @return : java.lang.String 值（删除的）， 默认null
     * @modifyHistory
     */
    public static String getSafeParamAndRemove(Map<String, String[]> paramMap, String key) {
        if (StringUtils.isBlank(key) || paramMap == null) {
            return null;
        }
        String[] strs = paramMap.remove(key);
        return getSafeFirstString(strs);
    }

    /**
     * 获取String[]的第一个元素
     *
     * @author WilliamSang
     * @date 2018/11/19
     * @param arg : String[]
     * @return : java.lang.String 第一个元素，默认null
     * @modifyHistory
     */
    public static String getSafeFirstString(String[] arg) {
        if (arg == null || arg.length < 1) {
            return null;
        }
        return arg[0];
    }

    /**
     * 替换字符串
     *
     * @author WilliamSang
     * @date 2018/11/19
     * @param originalStr : 原字符串
     * @param symbol : 替换的标志（一个字符）
     * @param replaceList : 替换的list（可定义每个字符位置字符不同）
     * @return : java.lang.String 替换后的字符
     * @modifyHistory
     */
    public static String replaceString(String originalStr, String symbol, List<String> replaceList) {
        if (StringUtils.isBlank(originalStr)) {
            return null;
        }
        if (StringUtils.isBlank(symbol) || !originalStr.contains(symbol)) {
            return originalStr;
        }
        StringBuffer sb = new StringBuffer(originalStr);
        List<Integer> positions = searchAllIndex(originalStr, symbol, replaceList);
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

    /**
     * 统计collection不为空的元素个数
     *
     * @author WilliamSang
     * @date 2018/11/19
     * @param collection : collection
     * @return : int 数量
     * @modifyHistory
     */
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

    /**
     * 查找字符串指定字符位置的list
     *
     * @author WilliamSang
     * @date 2018/11/19
     * @param str : 原字符串
     * @param symbol : 标志的字符
     * @return : java.util.List<java.lang.Integer> 每个字符在字符串的位置
     * @modifyHistory
     */
    public static List<Integer> searchAllIndex(String str, String symbol, List<String> listData) {
        List<Integer> positionList = new ArrayList<>();
        int aa = str.indexOf(symbol);
        boolean ab = (('?'+"")=="?");
        if (str.indexOf(symbol) == -1) {
            return null;
        }
        int tempPosi = -1;
        int dataIndex = 0;
        for (int i = str.indexOf(symbol); i < str.length(); ) {
            int len = i;
            if (dataIndex!=0) {
                for (int j = 0; j < dataIndex; j++) {
                    len += listData.get(j).length()-1;
                }
            }
            if ((str.charAt(i)+"").equals(symbol)) {
                positionList.add(len);
                tempPosi = str.indexOf(symbol, i+1);
                dataIndex++;
            }
            i++;
            i = tempPosi != -1 ? tempPosi : i;
        }
        return positionList;
    }
}
