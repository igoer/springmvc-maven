package com.igoer.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/9/30.
 *
 * 基本的路由设定以及参数绑定
 */
@Controller
@RequestMapping("route")
public class Route {

    /**
     * 通过返回 ModelAndView 跳转到 views 目录下的页面
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/route/index");
        return model;
    }

}
