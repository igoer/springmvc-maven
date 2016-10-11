package com.igoer.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/30.
 *
 * 基本的路由设定及页面跳转
 */
@Controller
@RequestMapping("route")
public class Route {

    /***************************************************
     * 基本请求映射
     ***************************************************/

    /**
     * 通过返回 ModelAndView 跳转到 views/route 目录下的页面
     *
     * @return
     */
    @RequestMapping("/model")
    public ModelAndView model() {
        ModelAndView model = new ModelAndView();
        model.setViewName("route/route_1");
        return model;
    }

    /**
     * 通过返回 String 跳转到 views/route 目录下对应页面
     *
     * @return
     */
    @RequestMapping("/string")
    public String string() {
        return "route/route_2";
    }

    /**
     * 重定向, 通过返回 ModelAndView 实现
     *
     * @return
     */
    @RequestMapping("/model302")
    public ModelAndView model302() {
        return new ModelAndView("redirect:model");
    }

    /**
     * 重定向, 通过返回 String 实现
     *
     * @return
     */
    @RequestMapping("/string302")
    public String string302() {
        return "redirect:string";
    }

    /***************************************************
     * 占位符请求映射
     * 该功能在 SpringMVC 向 REST 目标挺进过程中具有里程碑意义
     ***************************************************/

    /**
     * 将请求地址中的占位符参数绑定到 controller 的处理器方法入参中
     * url 中的 {xxx} 占位符可以通过 @PathVariable 注解绑定到方法的入参中
     *
     * @return
     */
    @RequestMapping(value = "/pv/{id}")
    public ModelAndView pathVariable(@PathVariable(value = "id") Integer id) {
        return new ModelAndView("route/route_" + id);
    }

    /**
     * 将请求地址中的占位符参数绑定到 controller 的处理器方法入参中
     * url 中的 {xxx} 占位符可以通过 @PathVariable 注解绑定到方法的入参中
     *
     * @return
     */
    @RequestMapping(value = "/pvs/{id}/{name}")
    public ModelAndView pathVariableMore(@PathVariable(value = "id") Integer id, @PathVariable("name") String name) {
        System.out.println(name);
        return new ModelAndView("route/route_" + id);
    }

    /**
     * 将请求地址中的占位符参数绑定到 controller 的处理器方法入参中
     * url 中的 {xxx} 占位符可以通过 @PathVariable 注解绑定到方法的入参中
     *
     * @return
     */
    @RequestMapping(value = "/pvp/{id}/project")
    public ModelAndView pathVariableJup(@PathVariable(value = "id") Integer id) {
        return new ModelAndView("route/route_" + id);
    }

    /***************************************************
     * Ant 风格请求映射
     * ?    匹配一个字符
     * *    匹配任意字符
     * **   匹配多层路径（可以为 0 个）
     ***************************************************/

    /**
     * 匹配如下请求地址
     *
     * /route/ant_1/a
     * /route/ant_1/ab
     * /route/ant_1/abc 等URL地址
     *
     * @return
     */
    @RequestMapping(value = "/ant_1/*")
    public ModelAndView ant_1() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 匹配如下请求地址
     *
     * /route/ant_2/a/index
     * /route/ant_2/ab/index
     * /route/ant_2/abc/index 等URL地址
     *
     * @return
     */
    @RequestMapping(value = "/ant_2/*/index")
    public ModelAndView ant_2() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 匹配如下请求地址
     *
     * /route/ant_3
     * /route/ant_3/aa
     * /route/ant_3/aa/bb
     * /route/ant_3/aa/bb/cc 等URL地址
     *
     * @return
     */
    @RequestMapping(value = "/ant_3/**")
    public ModelAndView ant_3() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 匹配如下请求地址
     *
     * /route/ant_4/aa/index
     * /route/ant_4/aa/bb/index
     * /route/ant_4/aa/bb/cc/index 等URL地址
     *
     * @return
     */
    @RequestMapping(value = "/ant_4/**/index")
    public ModelAndView ant_4() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 匹配如下请求地址
     *
     * /route/ant_5aa
     * /route/ant_5bb
     * /route/ant_5cc 等URL地址
     *
     *
     * @return
     */
    @RequestMapping(value = "/ant_5??")
    public ModelAndView ant_5() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 匹配如下请求地址
     *
     * /route/ant_6/a
     * /route/ant_6/b
     * /route/ant_6/c 等URL地址
     *
     *
     * @return
     */
    @RequestMapping(value = "/ant_6/?")
    public ModelAndView ant_6() {
        return new ModelAndView("route/route_1");
    }

    /***************************************************
     * 其他请求映射
     ***************************************************/

    /**
     * 使用 @RequestMapping 的 method 属性设置请求方式
     *
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 使用 @RequestMapping 的 method 属性设置请求方式
     *
     * @return
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ModelAndView post() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 使用 @RequestMapping 的 params 属性设置
     * 方法仅处理请求中包含了名为 “param” 的参数
     *
     * @return
     */
    @RequestMapping(value = "/params", params = "param")
    public ModelAndView params() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 使用 @RequestMapping 的 params 属性设置
     * 方法仅处理请求中包含了名为 “param”，值为 “123” 的请求
     *
     * @return
     */
    @RequestMapping(value = "/paramsValue", params = "param=123")
    public ModelAndView paramsValue() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 使用 @RequestMapping 的 header 属性设置 Reauest Header 中包含的属性
     *
     * 示例设置了只处理请求头中包含自定义的 MYHEADER 属性且值为 ABC123CDE
     * 如无法匹配服务器返回 404
     *
     * @return
     */
    @RequestMapping(value = "/header", headers = "MYHEADER=ABC123CDE")
    public ModelAndView header() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 使用 @RequestMapping 的 cousumes 属性设置
     * 方法仅处理 request Content-Type 为 application/json 类型的请求
     * 如无法匹配服务器返回 415
     *
     * @return
     */
    @RequestMapping(value = "/cousumes", consumes = "application/json")
    public ModelAndView cousumes() {
        return new ModelAndView("route/route_1");
    }

    /**
     * 使用 @RequestMapping 的 produces 属性设置
     * 方法仅处理 request Accept 为 application/json 类型的请求（浏览器支持的返回结果类型）
     * 并且该请求将返回 application/json json类型数据
     *
     * @return
     */
    @RequestMapping(value = "/produces", produces = "application/json")
    @ResponseBody
    public Map<String, String> produces() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "hello");
        map.put("key2", "world");
        return map;
    }

}
