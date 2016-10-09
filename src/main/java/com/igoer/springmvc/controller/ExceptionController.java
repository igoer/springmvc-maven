package com.igoer.springmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/10/9.
 *
 * 全局 controller 异常处理
 * @ControllerAdvice 注解大体意思为控制器增强
 * 即把@ControllerAdvice注解内部使用 @ExceptionHandler、@InitBinder、@ModelAttribute 注解的方法应用到所有的 @RequestMapping注解的方法
 * 非常简单，不过只有当使用 @ExceptionHandler 最有用，另外两个用处不大
 */
@ControllerAdvice
public class ExceptionController {

    /**
     * 处理 Controller 请求发送的异常
     * 可以通过 value = NullPointerException.class 参数来自定义该方法处理的异常类型, 不定义则处理所有异常
     *
     * @param error
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler
    public ModelAndView ExceptionToView(Throwable error, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        model.setViewName("error");
        model.addObject("error", error.toString());
        return model;
    }

}
