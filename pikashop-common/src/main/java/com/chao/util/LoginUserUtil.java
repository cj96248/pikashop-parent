package com.chao.util;

import org.springframework.security.core.context.SecurityContextHolder;

public class LoginUserUtil {

    public static String getUserId(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
