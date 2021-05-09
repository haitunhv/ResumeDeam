package com.haitunhv.jk.controller;

import com.haitunhv.jk.pojo.po.DictType;
import com.haitunhv.jk.query.DictTypeQuery;
import com.haitunhv.jk.service.DictTypeService;
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
@RequestMapping("/dictTypes")
public class DictTypeController {
    @Autowired
    private DictTypeService service;

    @GetMapping("/list")
    public String list(DictTypeQuery query, ModelMap modelMap){
        modelMap.addAttribute("data",service.list(query));
        return "pages/dictType";
    }
}
