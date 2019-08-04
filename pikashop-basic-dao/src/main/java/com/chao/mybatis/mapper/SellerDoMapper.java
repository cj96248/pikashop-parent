package com.chao.mybatis.mapper;

import com.chao.mybatis.pojo.SellerDo;
import com.chao.mybatis.pojo.SellerDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellerDoMapper {
    long countByExample(SellerDoExample example);

    int deleteByExample(SellerDoExample example);

    int deleteByPrimaryKey(String sellerId);

    int insert(SellerDo record);

    int insertSelective(SellerDo record);

    List<SellerDo> selectByExample(SellerDoExample example);

    SellerDo selectByPrimaryKey(String sellerId);

    int updateByExampleSelective(@Param("record") SellerDo record, @Param("example") SellerDoExample example);

    int updateByExample(@Param("record") SellerDo record, @Param("example") SellerDoExample example);

    int updateByPrimaryKeySelective(SellerDo record);

    int updateByPrimaryKey(SellerDo record);
}