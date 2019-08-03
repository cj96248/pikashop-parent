package com.chao.website.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.website.mapper.ContentCategoryDoMapper;
import com.chao.mybatis.website.pojo.ContentCategoryDo;
import com.chao.mybatis.website.pojo.ContentCategoryDoExample;
import com.chao.website.service.ContentCategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 服务实现层
 *
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private ContentCategoryDoMapper contentCategoryMapper;

    /**
     * 查询全部
     */
    @Override
    public List<ContentCategoryDo> findAll() {
        return contentCategoryMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public CommonResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<ContentCategoryDo> page = (Page<ContentCategoryDo>) contentCategoryMapper.selectByExample(null);
        return CommonResult.build(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(ContentCategoryDo contentCategory) {
        contentCategoryMapper.insert(contentCategory);
    }


    /**
     * 修改
     */
    @Override
    public void update(ContentCategoryDo contentCategory) {
        contentCategoryMapper.updateByPrimaryKey(contentCategory);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public ContentCategoryDo findOne(Long id) {
        return contentCategoryMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            contentCategoryMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public CommonResult findPage(ContentCategoryDo contentCategory, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        ContentCategoryDoExample example = new ContentCategoryDoExample();
        ContentCategoryDoExample.Criteria criteria = example.createCriteria();

        if (contentCategory != null) {
            if (contentCategory.getName() != null && contentCategory.getName().length() > 0) {
                criteria.andNameLike("%" + contentCategory.getName() + "%");
            }

        }

        Page<ContentCategoryDo> page = (Page<ContentCategoryDo>) contentCategoryMapper.selectByExample(example);
        return CommonResult.build(page.getTotal(), page.getResult());
    }

}
