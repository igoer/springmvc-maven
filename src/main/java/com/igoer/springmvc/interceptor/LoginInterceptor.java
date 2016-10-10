package com.igoer.springmvc.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2016/10/10.
 *
 * 本 interceptor 实现对用户的登录检查, 假设用户的登录状态保存在 session 的 LOGIN Attribute 中
 *
 * 推荐能使用servlet规范中的过滤器Filter实现的功能就用Filter实现
 * 因为HandlerInteceptor只有在Spring Web MVC环境下才能使用，因此Filter是最通用的、最先应该使用的。
 * 如登录这种拦截器最好使用Filter来实现。
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final String LONGPATH = "/login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 放行登录请求
        String requesturl = request.getRequestURI();
        if (requesturl.startsWith(LONGPATH)) {
            return true;
        }

        HttpSession session = request.getSession();
        Object user = session.getAttribute("LOGIN");
        // 如果用户已经登录, 放行继续执行后面的 interceptor
        if (user != null) {
            return true;
        }

        response.sendRedirect(request.getContextPath() + LONGPATH);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
