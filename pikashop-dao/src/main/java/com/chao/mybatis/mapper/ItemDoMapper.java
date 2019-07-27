package com.chao.mybatis.mapper;

import com.chao.mybatis.pojo.ItemDo;
import com.chao.mybatis.pojo.ItemDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemDoMapper {
    long countByExample(ItemDoExample example);

    int deleteByExample(ItemDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemDo record);

    int insertSelective(ItemDo record);

    List<ItemDo> selectByExample(ItemDoExample example);

    ItemDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemDo record, @Param("example") ItemDoExample example);

    int updateByExample(@Param("record") ItemDo record, @Param("example") ItemDoExample example);

    int updateByPrimaryKeySelective(ItemDo record);

    int updateByPrimaryKey(ItemDo record);
}