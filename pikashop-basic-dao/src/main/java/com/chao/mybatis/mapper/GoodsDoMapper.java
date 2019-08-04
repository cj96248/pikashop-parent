package com.chao.mybatis.mapper;

import com.chao.mybatis.pojo.GoodsDo;
import com.chao.mybatis.pojo.GoodsDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDoMapper {
    long countByExample(GoodsDoExample example);

    int deleteByExample(GoodsDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsDo record);

    int insertSelective(GoodsDo record);

    List<GoodsDo> selectByExample(GoodsDoExample example);

    GoodsDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsDo record, @Param("example") GoodsDoExample example);

    int updateByExample(@Param("record") GoodsDo record, @Param("example") GoodsDoExample example);

    int updateByPrimaryKeySelective(GoodsDo record);

    int updateByPrimaryKey(GoodsDo record);
}