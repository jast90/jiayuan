package io.github.jast90.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jast90 on 2021/3/11
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //非登录请求,获取session,判断是否有用户数据
        if(request.getSession().getAttribute("s_sysUser")!=null) {
            //已经登录,放行
            return true;
        }else {
            response.sendRedirect("/login");
        }
        return false;//默认拦截
    }
}
