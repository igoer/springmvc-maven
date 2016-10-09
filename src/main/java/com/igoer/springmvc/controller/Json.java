package com.igoer.springmvc.controller;

import com.igoer.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Administrator on 2016/10/8.
 *
 * Json 返回
 */
@Controller
@RequestMapping("json")
public class Json {

    /**
     * 返回 json
     * SpringMVC 会将方法的返回值进行 json 序列化后写出
     *
     * @return
     */
    @RequestMapping("/map")
    @ResponseBody
    public Map<String, String> map() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "hello");
        map.put("key2", "world");
        return map;
    }

    /**
     * 返回 json
     * SpringMVC 会将方法的返回值进行 json 序列化后写出
     *
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<String> list() {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        return list;
    }

    /**
     * 返回 json
     * SpringMVC 会将方法的返回值进行 json 序列化后写出
     *
     * @return
     */
    @RequestMapping("/bean")
    @ResponseBody
    public User bean() {
        User user = new User();
        user.setId(1);
        user.setName("tom");
        user.setHeight(1.88);
        user.setIsjob(false);
        user.setIncome(12000.0);
        user.setBirthday(new Date());
        return user;
    }
}
