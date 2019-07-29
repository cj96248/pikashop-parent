package com.chao.mybatis.mapper;

import com.chao.mybatis.pojo.OrderItemDo;
import com.chao.mybatis.pojo.OrderItemDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemDoMapper {
    long countByExample(OrderItemDoExample example);

    int deleteByExample(OrderItemDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderItemDo record);

    int insertSelective(OrderItemDo record);

    List<OrderItemDo> selectByExample(OrderItemDoExample example);

    OrderItemDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderItemDo record, @Param("example") OrderItemDoExample example);

    int updateByExample(@Param("record") OrderItemDo record, @Param("example") OrderItemDoExample example);

    int updateByPrimaryKeySelective(OrderItemDo record);

    int updateByPrimaryKey(OrderItemDo record);
}