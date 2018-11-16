package com.test.easypoi.mapper;

import com.test.easypoi.pojo.Loan;
import com.test.easypoi.pojo.LoanWithBlobs;
import com.test.easypoi.provider.LoanInfoProvider;
import com.test.easypoi.util.entity.excel.LoanExcelBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 标的mapper
 *
 * @author WilliamSang
 * @date 2018/11/13 16:29
 */
@Mapper
@Component
public interface LoanMapper {
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
     * 插入标的（完全）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 标的bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insert(LoanWithBlobs record)
            ;

    /**
     * 插入标的（可选）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 标的bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insertSelective(LoanWithBlobs record)
            ;

    /**
     * 根据主键查询
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param id : 主键
     * @return : com.test.easypoi.pojo.LoanWithBlobs 标的bean
     * @modifyHistory
     */
    LoanWithBlobs selectByPrimaryKey(String id)
            ;

    /**
     * 根据主键更新（可选）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 标的bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKeySelective(LoanWithBlobs record)
            ;

    /**
     * 根据主键更新（完全）
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 标的bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKeyWithBLOBs(LoanWithBlobs record)
            ;

    /**
     * 根据主键更新
     *
     * @author WilliamSang
     * @date 2018/11/13
     * @param record : 标的基本信息bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKey(Loan record)
            ;

    @SelectProvider(type = LoanInfoProvider.class, method = "findLoanExcelData")
    /**
     * 查询在一定时间内的标的excel
     *
     * @author WilliamSang
     * @date 2018/11/14
     * @param finalDate : 最大期限
     * @return : java.util.List<com.test.easypoi.util.entity.excel.LoanExcelBean> 标的excel bean list
     * @modifyHistory
     */
    List<LoanExcelBean> findLoanExcelWithLongestDate(@Param("finalDate")Date finalDate)
            ;

    @SelectProvider(type = LoanInfoProvider.class, method = "findGenericData")
    /**
     * excel导出通用查询
     *
     * @author WilliamSang
     * @date 2018/11/16
     * @param sql : sql
     * @param params : 参数
     * @return : java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @modifyHistory
     */
    List<Map<String, Object>> findGenericExcelData(@Param("sql") String sql,@Param("data") List<String> params)
            ;
}