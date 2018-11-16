package com.test.easypoi.mapper;

import com.test.easypoi.pojo.InvestRepay;

/**
 * 投资回报mapper
 *
 * @author WilliamSang
 * @date 2018/11/13 19:04
 */
public interface InvestRepayMapper {
    /**
     * 根据主键删除
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param id : 主键
     * @return : int 受影响行数
     * @modifyHistory
     */
    int deleteByPrimaryKey(String id)
            ;

    /**
     * 插入投资回报（完全）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 投资回报bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insert(InvestRepay record)
            ;

    /**
     * 插入投资回报（可选）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 投资回报bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insertSelective(InvestRepay record)
            ;

    /**
     * 根据主键查询投资回报
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param id : 主键
     * @return : com.test.easypoi.pojo.InvestRepay 投资回报bean
     * @modifyHistory
     */
    InvestRepay selectByPrimaryKey(String id)
            ;

    /**
     * 根据主键更新（可选）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 投资回报bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKeySelective(InvestRepay record)
            ;

    /**
     * 根据主键更新（完全）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 投资回报bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKey(InvestRepay record)
            ;
}