package com.igoer.springmvc.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/10/10.
 *
 * 本 interceptor 实现了对所有系统请求的记录工作, 以及每个请求执行时间
 *
 * 在记录请求耗时时需要把 RequestLogInterceptor 放在拦截器链的第一个，这样得到的时间才是比较准确的。
 */
public class RequestLogInterceptor extends HandlerInterceptorAdapter {

    Logger log = Logger.getLogger(RequestLogInterceptor.class);

    /**
     * 记录每次请求进入的开始时间
     * 拦截器是单例的，因此不管用户请求多少次都只有一个拦截器实现，即线程不安全，所以这里使用 ThreadLocal 来进行记录
     */
    ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    /**
     * 进入 controller 之前执行
     * 返回值：
     * true表示继续流程（如调用下一个拦截器或处理器）
     * false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 记录请求开始执行时间
        startTime.set(System.currentTimeMillis());

        String url = request.getRequestURI();
        String ip = request.getRemoteAddr();
        log.info("request --> ip: " + ip + "\t" + url);

        return true;
    }

    /**
     * controller 返回 ModelAndView 后执行
     * 可以在这里对 ModelAndView 携带的数据进行处理工作
     * 如请求的返回值为 json xml 或者其他则不执行该方法
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView 注意如请求返回 404 modelAndView 的值为 null
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //log.info("modelAndView: " + modelAndView.getViewName());
    }

    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间, 异常监控等
     * 还可以进行一些资源清理，类似于 try-catch-finally 中的 finally
     * 但仅调用处理器执行链中 preHandle 返回 true 的拦截器的 afterCompletion。
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long beginTime = startTime.get();
        long endTime = System.currentTimeMillis();
        long consumeTime = endTime - beginTime;

        log.info("request use time: " + consumeTime + "ms");
    }

}
