package com.test.easypoi.mapper;

import com.test.easypoi.pojo.Wheel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 投资mapper
 *
 * @author WilliamSang
 * @date 2018/11/13 19:01
 */
@Mapper
@Component
public interface WheelMapper {

    /**
     * 插入投资（可选）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 投资bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insertSelective(Wheel record)
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
    Wheel selectByPrimaryKey(String id)
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
    int updateByPrimaryKeySelective(Wheel record)
            ;

}