package com.haitunhv.service;

import com.haitunhv.domain.Skill;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/4/10 15:48
 */
public interface SkillService {
    boolean save(Skill skill);

    boolean remove(Integer id);

    Skill get(Integer id);

    List<Skill> list();
}
