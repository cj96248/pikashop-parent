package com.chao.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

    /**
     * 密码加密
     * @param raw
     * @return
     */
    public static String encrypt(String raw){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(raw);
    }
    public static boolean compare(String expect, String actual){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(expect, actual);
    }
}
