package com.igoer.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2016/10/9.
 *
 * 异常测试
 */
@Controller
@RequestMapping("error")
public class Error {

    @RequestMapping("/mav")
    public ModelAndView error_1() {
        String str = null;
        str.length();
        return new ModelAndView();
    }
}
