package com.zhaoyi.myweb.config;

import com.zhaoyi.myweb.component.LoginHandlerInterupter;
import com.zhaoyi.myweb.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 浏览器发送/restweb也会来到hello页面.
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
    }



    /**
     * 添加自定义拦截器到容器中，并配置相关参数
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // SB已经对静态资源 *.css , *.jss进行了映射，我们可以不加管理
        registry.addInterceptor(new LoginHandlerInterupter()).addPathPatterns("/**")
                . excludePathPatterns("/login","/user/login", "/asserts/**","/webjars/**");

    }

    /**
     * 自定义本地解析器
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }



}
