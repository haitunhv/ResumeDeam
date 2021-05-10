package com.haitunhv.jk.controller;

import com.haitunhv.jk.query.DictItemQuery;
import com.haitunhv.jk.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author: haitunhv
 * @Date: 2021/5/8 22:01
 */
@Controller
@RequestMapping("/dictItems")
public class DictItemController {
    @Autowired
    private DictItemService service;

    @GetMapping("/list")
    public String list(DictItemQuery query, ModelMap modelMap){
        service.list(query);
        modelMap.addAttribute("data",query);
        return "pages/dictType";
    }
}
