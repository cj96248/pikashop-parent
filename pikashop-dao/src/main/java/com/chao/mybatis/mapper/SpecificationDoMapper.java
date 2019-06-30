package com.chao.mybatis.mapper;

import com.chao.mybatis.pojo.SpecificationDo;
import com.chao.mybatis.pojo.SpecificationDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecificationDoMapper {
    long countByExample(SpecificationDoExample example);

    int deleteByExample(SpecificationDoExample example);

    int deleteByPrimaryKey(Long id);

    void deleteByIds(Long[] ids);

    int insert(SpecificationDo record);

    int insertSelective(SpecificationDo record);

    List<SpecificationDo> selectByExample(SpecificationDoExample example);

    SpecificationDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpecificationDo record, @Param("example") SpecificationDoExample example);

    int updateByExample(@Param("record") SpecificationDo record, @Param("example") SpecificationDoExample example);

    int updateByPrimaryKeySelective(SpecificationDo record);

    int updateByPrimaryKey(SpecificationDo record);
}