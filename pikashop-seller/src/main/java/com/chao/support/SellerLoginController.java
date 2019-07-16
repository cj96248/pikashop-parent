package com.chao.support;

import com.alibaba.dubbo.config.annotation.Reference;
import com.chao.common.viewobject.CommonResult;
import com.chao.entity.viewobject.LoginUser;
import com.chao.entity.viewobject.UserStatusEnum;
import com.chao.mybatis.pojo.SellerDo;
import com.chao.service.SellerService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/login")
public class SellerLoginController {

    @Reference
    SellerService sellerService;

    @RequestMapping("/sellerInfo")
    public CommonResult getSellerDetail(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm");
        String date = LocalDateTime.now().format(formatter);
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        SellerDo seller = sellerService.findOne(name);
        LoginUser user = new LoginUser().setId(seller.getSellerId()).setName(seller.getNickName()).setStatus(UserStatusEnum.valuesOf(seller.getStatus())).setLoginTime(date);
        return CommonResult.build(1, user);
    }
}
