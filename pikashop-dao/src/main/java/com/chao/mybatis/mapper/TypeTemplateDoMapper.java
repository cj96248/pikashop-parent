package com.chao.mybatis.mapper;

import com.chao.mybatis.pojo.TypeTemplateDo;
import com.chao.mybatis.pojo.TypeTemplateDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeTemplateDoMapper {
    long countByExample(TypeTemplateDoExample example);

    int deleteByExample(TypeTemplateDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TypeTemplateDo record);

    int insertSelective(TypeTemplateDo record);

    List<TypeTemplateDo> selectByExample(TypeTemplateDoExample example);

    TypeTemplateDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TypeTemplateDo record, @Param("example") TypeTemplateDoExample example);

    int updateByExample(@Param("record") TypeTemplateDo record, @Param("example") TypeTemplateDoExample example);

    int updateByPrimaryKeySelective(TypeTemplateDo record);

    int updateByPrimaryKey(TypeTemplateDo record);
}