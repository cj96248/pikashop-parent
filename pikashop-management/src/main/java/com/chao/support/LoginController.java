package com.chao.support;

import com.chao.common.viewobject.CommonResult;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/info")
    public CommonResult getLoginName(){
        Map<String, String> info = new HashMap<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm");
        String time = LocalDateTime.now().format(dateTimeFormatter);
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        info.put("name", name);
        info.put("time", time);
        return CommonResult.build(1, info);
    }
}
