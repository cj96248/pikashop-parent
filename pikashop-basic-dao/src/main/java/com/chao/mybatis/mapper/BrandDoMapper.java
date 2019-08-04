package com.chao.mybatis.mapper;


import com.chao.mybatis.pojo.BrandDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BrandDo record);

    int insertSelective(BrandDo record);

    BrandDo selectByPrimaryKey(Long id);

    List<BrandDo> listBrand();

    List<BrandDo> searchBrand(@Param("keyword") String keyword);

    int updateByPrimaryKeySelective(BrandDo record);

    int updateByPrimaryKey(BrandDo record);

    void deleteByIds(long[] ids);
}