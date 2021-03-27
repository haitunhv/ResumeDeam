package com.haitunhv;

import com.haitunhv.bean.Skill;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/3/25 21:23
 */
public interface SkillDao {
    boolean save(Skill skill);
    boolean update(Skill skill);
    boolean delete(Integer id);
    Skill get(Integer id);
    List<Skill> list();
}
