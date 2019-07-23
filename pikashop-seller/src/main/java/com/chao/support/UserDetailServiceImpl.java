package com.chao.support;

import com.chao.mybatis.pojo.SellerDo;
import com.chao.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class UserDetailServiceImpl  implements UserDetailsService {
    private SellerService sellerService;

    public void setSellerService(SellerService sellerService){
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        log.info("Check access for {}", name);
        List<GrantedAuthority> auths = Arrays.asList(new SimpleGrantedAuthority("ROLE_SELLER"));
        SellerDo seller = sellerService.findOne(name);
        if(seller != null){
            return new User(name, seller.getPassword(), auths);
        }
        return null;
    }
}
