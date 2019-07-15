package com.chao.mybatis.mapper;

import com.chao.mybatis.pojo.ItemCatDo;
import com.chao.mybatis.pojo.ItemCatDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemCatDoMapper {
    long countByExample(ItemCatDoExample example);

    int deleteByExample(ItemCatDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemCatDo record);

    int insertSelective(ItemCatDo record);

    List<ItemCatDo> selectByExample(ItemCatDoExample example);

    ItemCatDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemCatDo record, @Param("example") ItemCatDoExample example);

    int updateByExample(@Param("record") ItemCatDo record, @Param("example") ItemCatDoExample example);

    int updateByPrimaryKeySelective(ItemCatDo record);

    int updateByPrimaryKey(ItemCatDo record);
}