package com.igoer.springmvc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

/**
 * Created by Administrator on 2016/10/8.
 */
public class User {

    private Integer id;

    private String name;

    private Double height;

    private Boolean isjob;

    /**
     * @DateTimeFormat 注解用于完成对日期的参数注入
     *
     * pattern：指定解析/格式化字段数据的模式，如”yyyy-MM-dd HH:mm:ss”
     * iso：指定解析/格式化字段数据的ISO模式，包括四种：
     *      ISO.NONE（不使用）
     *      ISO.DATE(yyyy-MM-dd)
     *      ISO.TIME(hh:mm:ss.SSSZ)
     *      ISO.DATE_TIME(yyyy-MM-dd hh:mm:ss.SSSZ)
     *      默认ISO.NONE
     * style：指定用于格式化的样式模式，默认“SS”，具体使用请参考Joda-Time类库的org.joda.time.format.DateTimeFormat的forStyle的javadoc；
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    /**
     * @JsonFormat 注解用于 jackson 返回json字符串时对日期类型进行格式输出
     *
     * pattern: 指定格式化字段数据的模式
     * timezone: 指定时间时区 GMT+8 东八区
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;

    /**
     * @NumberFormat 定义数字相关的解析/格式化元数据
     *
     * 参数如下：
     * style：用于指定样式类型，包括三种：
     *      Style.NUMBER（通用样式）
     *      Style.CURRENCY（货币样式）
     *      Style.PERCENT（百分数样式）
     *      默认Style.NUMBER
     * pattern：自定义样式，如patter="#,###"；
     */
    @NumberFormat(style = NumberFormat.Style.NUMBER, pattern = "#,###")
    private Double income;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Boolean getIsjob() {
        return isjob;
    }

    public void setIsjob(Boolean isjob) {
        this.isjob = isjob;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }
}
