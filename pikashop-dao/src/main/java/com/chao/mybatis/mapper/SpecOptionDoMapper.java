package com.chao.mybatis.mapper;

import com.chao.mybatis.pojo.SpecOptionDo;
import com.chao.mybatis.pojo.SpecOptionDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecOptionDoMapper {
    long countByExample(SpecOptionDoExample example);

    int deleteByExample(SpecOptionDoExample example);

    int deleteByPrimaryKey(Long id);

    int deleteBySpecIds(Long[] ids);

    int insert(SpecOptionDo record);

    int insertSelective(SpecOptionDo record);

    List<SpecOptionDo> selectByExample(SpecOptionDoExample example);

    SpecOptionDo selectByPrimaryKey(Long id);

    List<SpecOptionDo> selectBySpecId(Long id);

    int updateByExampleSelective(@Param("record") SpecOptionDo record, @Param("example") SpecOptionDoExample example);

    int updateByExample(@Param("record") SpecOptionDo record, @Param("example") SpecOptionDoExample example);

    int updateByPrimaryKeySelective(SpecOptionDo record);

    int updateByPrimaryKey(SpecOptionDo record);
}