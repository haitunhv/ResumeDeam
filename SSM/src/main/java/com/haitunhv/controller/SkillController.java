package com.haitunhv.controller;

import com.haitunhv.domain.Skill;
import com.haitunhv.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/4/10 15:54
 */
@Controller
@RequestMapping("/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping("/list")
    @ResponseBody
    public List<Skill> list(){
        return skillService.list();
    }

    @GetMapping("/get")
    @ResponseBody
    public Skill get(Integer id){
        return skillService.get(id);
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(Skill skill){
        return skillService.save(skill)?"保存成功":"保存失败";
    }

    @PostMapping("/remove")
    @ResponseBody
    public String remove(Integer id){
        return skillService.remove(id)?"删除成功":"删除失败";
    }
}
