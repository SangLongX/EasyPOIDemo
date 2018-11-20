package com.test.easypoi.mapper;

import com.test.easypoi.pojo.User;
import com.test.easypoi.pojo.UserWithBlobs;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 用户mapper
 * 
 * @author SangXiaolong
 * @date 2018/11/13 16:36
 */
@Mapper
@Component
public interface UserMapper {
    /**
     * 根据主键删除
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param id : 主键
     * @return : int 受影响行数
     * @modifyHistory
     */
    int deleteByPrimaryKey(String id)
            ;

    /**
     * 插入用户（完全）
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param record : 用户bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insert(UserWithBlobs record)
            ;

    /**
     * 插入用户（可选）
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param record : 用户bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int insertSelective(UserWithBlobs record)
            ;

    /**
     * 根据主键查询用户
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param id : 主键
     * @return : com.test.easypoi.pojo.UserWithBlobs 用户bean
     * @modifyHistory
     */
    UserWithBlobs selectByPrimaryKey(String id)
            ;

    /**
     * 根据主键更新（可选）
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param record : 用户bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKeySelective(UserWithBlobs record)
            ;

    /**
     * 根据主键更新（完全）
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param record : 用户bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKeyWithBLOBs(UserWithBlobs record)
            ;

    /**
     * 根据主键更新（完全）
     *
     * @author SangXiaolong
     * @date 2018/11/13
     * @param record : 用户基本信息bean
     * @return : int 受影响行数
     * @modifyHistory
     */
    int updateByPrimaryKey(User record)
            ;
}