package com.zhaoyi.myweb.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

        @Override
        public Locale resolveLocale(HttpServletRequest request) {
            String l = request.getParameter("l");
            // 若没有获取到提供的，则使用操作系统默认的区域信息
            Locale locale = Locale.getDefault();
            if(!StringUtils.isEmpty(l)){
                String[] s = l.split("_");
                // 第一个参数为语言代码，第二个参数为国家代码
                locale = new Locale(s[0], s[1]);
            }
            return locale;
        }

        @Override
        public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        }

}
