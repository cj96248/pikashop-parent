package com.chao.service.impl;

import java.util.Date;
import java.util.List;

import com.chao.common.viewobject.CommonResult;
import com.chao.mybatis.mapper.SellerDoMapper;
import com.chao.mybatis.pojo.SellerDo;
import com.chao.mybatis.pojo.SellerDoExample;
import com.chao.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerDoMapper sellerMapper;

    /**
     * 查询全部
     */
    @Override
    public List<SellerDo> findAll() {
        return sellerMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public CommonResult<SellerDo> findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<SellerDo> page = (Page<SellerDo>) sellerMapper.selectByExample(null);
        return CommonResult.build(page.getTotal(), page.getResult());
    }
    /**
     * 增加
     */
    @Override
    public void add(SellerDo seller) {
        seller.setStatus("0");//状态
        seller.setCreateTime(new Date());//申请日期
        sellerMapper.insert(seller);
    }
    /**
     * 修改
     */
    @Override
    public void update(SellerDo seller) {
        sellerMapper.updateByPrimaryKey(seller);
    }

    /**
     * 根据ID获取实体
     *
     * @param id
     * @return
     */
    @Override
    public SellerDo findOne(String id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            sellerMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public CommonResult<SellerDo> findPage(SellerDo seller, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        SellerDoExample example = new SellerDoExample();
        SellerDoExample.Criteria criteria = example.createCriteria();

        if (seller != null) {
            if (seller.getSellerId() != null && seller.getSellerId().length() > 0) {
                criteria.andSellerIdLike("%" + seller.getSellerId() + "%");
            }
            if (seller.getName() != null && seller.getName().length() > 0) {
                criteria.andNameLike("%" + seller.getName() + "%");
            }
            if (seller.getNickName() != null && seller.getNickName().length() > 0) {
                criteria.andNickNameLike("%" + seller.getNickName() + "%");
            }
            if (seller.getPassword() != null && seller.getPassword().length() > 0) {
                criteria.andPasswordLike("%" + seller.getPassword() + "%");
            }
            if (seller.getEmail() != null && seller.getEmail().length() > 0) {
                criteria.andEmailLike("%" + seller.getEmail() + "%");
            }
            if (seller.getMobile() != null && seller.getMobile().length() > 0) {
                criteria.andMobileLike("%" + seller.getMobile() + "%");
            }
            if (seller.getTelephone() != null && seller.getTelephone().length() > 0) {
                criteria.andTelephoneLike("%" + seller.getTelephone() + "%");
            }
            if (seller.getStatus() != null && seller.getStatus().length() > 0) {
                criteria.andStatusLike("%" + seller.getStatus() + "%");
            }
            if (seller.getAddressDetail() != null && seller.getAddressDetail().length() > 0) {
                criteria.andAddressDetailLike("%" + seller.getAddressDetail() + "%");
            }
            if (seller.getLinkmanName() != null && seller.getLinkmanName().length() > 0) {
                criteria.andLinkmanNameLike("%" + seller.getLinkmanName() + "%");
            }
            if (seller.getLinkmanQq() != null && seller.getLinkmanQq().length() > 0) {
                criteria.andLinkmanQqLike("%" + seller.getLinkmanQq() + "%");
            }
            if (seller.getLinkmanMobile() != null && seller.getLinkmanMobile().length() > 0) {
                criteria.andLinkmanMobileLike("%" + seller.getLinkmanMobile() + "%");
            }
            if (seller.getLinkmanEmail() != null && seller.getLinkmanEmail().length() > 0) {
                criteria.andLinkmanEmailLike("%" + seller.getLinkmanEmail() + "%");
            }
            if (seller.getLicenseNumber() != null && seller.getLicenseNumber().length() > 0) {
                criteria.andLicenseNumberLike("%" + seller.getLicenseNumber() + "%");
            }
            if (seller.getTaxNumber() != null && seller.getTaxNumber().length() > 0) {
                criteria.andTaxNumberLike("%" + seller.getTaxNumber() + "%");
            }
            if (seller.getOrgNumber() != null && seller.getOrgNumber().length() > 0) {
                criteria.andOrgNumberLike("%" + seller.getOrgNumber() + "%");
            }
            if (seller.getLogoPic() != null && seller.getLogoPic().length() > 0) {
                criteria.andLogoPicLike("%" + seller.getLogoPic() + "%");
            }
            if (seller.getBrief() != null && seller.getBrief().length() > 0) {
                criteria.andBriefLike("%" + seller.getBrief() + "%");
            }
            if (seller.getLegalPerson() != null && seller.getLegalPerson().length() > 0) {
                criteria.andLegalPersonLike("%" + seller.getLegalPerson() + "%");
            }
            if (seller.getLegalPersonCardId() != null && seller.getLegalPersonCardId().length() > 0) {
                criteria.andLegalPersonCardIdLike("%" + seller.getLegalPersonCardId() + "%");
            }
            if (seller.getBankUser() != null && seller.getBankUser().length() > 0) {
                criteria.andBankUserLike("%" + seller.getBankUser() + "%");
            }
            if (seller.getBankName() != null && seller.getBankName().length() > 0) {
                criteria.andBankNameLike("%" + seller.getBankName() + "%");
            }
        }
        Page<SellerDo> page = (Page<SellerDo>) sellerMapper.selectByExample(example);
        return CommonResult.build(page.getTotal(), page.getResult());
    }

    @Override
    public void updateStatus(String sellerId, String status) {
        SellerDo seller = sellerMapper.selectByPrimaryKey(sellerId);
        seller.setStatus(status);
        sellerMapper.updateByPrimaryKey(seller);
    }
}
