package com.chao.mybatis.mapper;

import com.chao.mybatis.pojo.OrderDo;
import com.chao.mybatis.pojo.OrderDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDoMapper {
    long countByExample(OrderDoExample example);

    int deleteByExample(OrderDoExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(OrderDo record);

    int insertSelective(OrderDo record);

    List<OrderDo> selectByExample(OrderDoExample example);

    OrderDo selectByPrimaryKey(Long orderId);

    int updateByExampleSelective(@Param("record") OrderDo record, @Param("example") OrderDoExample example);

    int updateByExample(@Param("record") OrderDo record, @Param("example") OrderDoExample example);

    int updateByPrimaryKeySelective(OrderDo record);

    int updateByPrimaryKey(OrderDo record);
}