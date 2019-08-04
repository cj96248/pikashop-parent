package com.chao.mybatis.mapper;

import com.chao.mybatis.pojo.GoodsDescDo;
import com.chao.mybatis.pojo.GoodsDescDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDescDoMapper {
    long countByExample(GoodsDescDoExample example);

    int deleteByExample(GoodsDescDoExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(GoodsDescDo record);

    int insertSelective(GoodsDescDo record);

    List<GoodsDescDo> selectByExample(GoodsDescDoExample example);

    GoodsDescDo selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(@Param("record") GoodsDescDo record, @Param("example") GoodsDescDoExample example);

    int updateByExample(@Param("record") GoodsDescDo record, @Param("example") GoodsDescDoExample example);

    int updateByPrimaryKeySelective(GoodsDescDo record);

    int updateByPrimaryKey(GoodsDescDo record);
}