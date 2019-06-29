package com.chao.mybatis.mapper;


import com.chao.mybatis.pojo.BrandDo;

import java.util.List;

public interface BrandDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BrandDo record);

    int insertSelective(BrandDo record);

    BrandDo selectByPrimaryKey(Long id);

    List<BrandDo> listBrand();

    int updateByPrimaryKeySelective(BrandDo record);

    int updateByPrimaryKey(BrandDo record);

    void deleteByIds(long[] ids);
}