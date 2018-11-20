package com.test.easypoi.mapper;

import com.test.easypoi.pojo.Invest;
import com.test.easypoi.pojo.InvestWithBlobs;

/**
 * 投资mapper
 *
 * @author WilliamSang
 * @date 2018/11/13 19:01
 */
public interface InvestMapper {
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
     * 插入投资（完全）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 投资bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insert(InvestWithBlobs record)
            ;

    /**
     * 插入投资（可选）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 投资bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insertSelective(InvestWithBlobs record)
            ;

    /**
     * 根据主键查询投资
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param id : 主键
     * @return : com.test.easypoi.pojo.InvestWithBlobs 投资bean
     * @modifyHistory
     */
    InvestWithBlobs selectByPrimaryKey(String id)
            ;

    /**
     * 根据主键更新（可选）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 投资bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKeySelective(InvestWithBlobs record)
            ;

    /**
     * 根据主键更新（完全）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 投资bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKeyWithBLOBs(InvestWithBlobs record)
            ;

    /**
     * 根据主键更新
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 投资基本信息bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKey(Invest record)
            ;
}