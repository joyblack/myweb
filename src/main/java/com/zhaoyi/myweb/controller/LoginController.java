package com.zhaoyi.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @PostMapping(value = {"/user/login"})
    public String login(@RequestParam("username")String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Map<String, Object> map){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser","admin");
            return "redirect:/index";
        }else{
            map.put("msg", "用户名或密码错误");
            return "login";
        }

    }
}
