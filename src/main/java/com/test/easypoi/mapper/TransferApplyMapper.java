package com.test.easypoi.mapper;

import com.test.easypoi.pojo.TransferApply;
import com.test.easypoi.provider.TransferApplyProvider;
import com.test.easypoi.util.entity.excel.TransferApplyExcelBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 债转mapper
 * 
 * @author WilliamSang
 * @date 2018/11/13 16:29
 */
@Mapper
@Component
public interface TransferApplyMapper {
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
     * 插入债转（完全）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 债转bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insert(TransferApply record)
            ;

    /**
     * 插入债转（可选）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 债转bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insertSelective(TransferApply record)
            ;

    /**
     * 根据主键查询债转
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param id : 主键
     * @return : com.test.easypoi.pojo.TransferApply 债转bean
     * @modifyHistory
     */
    TransferApply selectByPrimaryKey(String id)
            ;

    /**
     * 根据主键更新（可选）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 债转bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKeySelective(TransferApply record)
            ;

    /**
     * 根据主键更新（完全）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 债转bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKey(TransferApply record)
            ;

    @SelectProvider(type = TransferApplyProvider.class, method = "findTransferApplyExcelData")
    /**
     * 查询债转信息
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param toWhere : 要排除的数据源 0 - 百达； 1 - 富管家； 2 - 同城
     * @param transferApplyStartTime : 债转开始时间
     * @param toArray : 用户id，多个用逗号分隔
     * @return : java.util.List<com.test.easypoi.util.entity.excel.TransferApplyExcelBean> 债转excel bean list
     * @modifyHistory
     */
    List<TransferApplyExcelBean> findTransferApplyExcelWithItems(@Param("toWhere") String toWhere, @Param("transferStartTime") Date transferApplyStartTime, @Param("userIds") String[] toArray)
            ;
}