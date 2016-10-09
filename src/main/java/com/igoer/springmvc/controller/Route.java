package com.igoer.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/9/30.
 *
 * 基本的路由设定及页面跳转
 */
@Controller
@RequestMapping("route")
public class Route {

    /**
     * 通过返回 ModelAndView 跳转到 views 目录下的页面
     *
     * @return
     */
    @RequestMapping("/model")
    public ModelAndView route_1() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/route/route_1");
        return model;
    }

    /**
     * 通过返回 String 跳转到 views 目录下对应页面
     *
     * @return
     */
    @RequestMapping("/string")
    public String route_2() {
        return "route_2";
    }

}
