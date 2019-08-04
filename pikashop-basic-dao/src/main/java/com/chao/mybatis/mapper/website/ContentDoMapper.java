package com.chao.mybatis.mapper.website;

import com.chao.mybatis.website.pojo.ContentDo;
import com.chao.mybatis.website.pojo.ContentDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentDoMapper {
    long countByExample(ContentDoExample example);

    int deleteByExample(ContentDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContentDo record);

    int insertSelective(ContentDo record);

    List<ContentDo> selectByExample(ContentDoExample example);

    ContentDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContentDo record, @Param("example") ContentDoExample example);

    int updateByExample(@Param("record") ContentDo record, @Param("example") ContentDoExample example);

    int updateByPrimaryKeySelective(ContentDo record);

    int updateByPrimaryKey(ContentDo record);
}