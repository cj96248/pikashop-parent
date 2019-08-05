package com.chao.mybatis.mapper;

import com.chao.mybatis.website.pojo.ContentCategoryDo;
import com.chao.mybatis.website.pojo.ContentCategoryDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentCategoryDoMapper {
    long countByExample(ContentCategoryDoExample example);

    int deleteByExample(ContentCategoryDoExample example);

    int deleteByPrimaryKey(Long id);

    int deleteByIds(Long[] ids);

    int insert(ContentCategoryDo record);

    int insertSelective(ContentCategoryDo record);

    List<ContentCategoryDo> selectByExample(ContentCategoryDoExample example);

    ContentCategoryDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContentCategoryDo record, @Param("example") ContentCategoryDoExample example);

    int updateByExample(@Param("record") ContentCategoryDo record, @Param("example") ContentCategoryDoExample example);

    int updateByPrimaryKeySelective(ContentCategoryDo record);

    int updateByPrimaryKey(ContentCategoryDo record);
}