package com.zhaoyi.myweb.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterupter implements HandlerInterceptor {
    /**
     * 其他的方法由于java8的default，我们可以不实现了，专心写这部分代码进行登录检查即可
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        // 若登录，放行请求
        if(loginUser != null){
            return true;
        }
        request.setAttribute("msg","未登录，请先登录");
        System.out.println("this is is a preHandler method." + request.getRequestURI());
        request.getRequestDispatcher("/login").forward(request, response);
        return false;
    }
}
