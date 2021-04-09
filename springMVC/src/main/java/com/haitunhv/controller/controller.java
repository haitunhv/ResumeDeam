package com.haitunhv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: haitunhv
 * @Date: 2021/4/6 20:39
 */
@Controller
public class controller {

    @RequestMapping("/addUser")
    @ResponseBody
    public String add(){
        return "add success";
    }
}
