package com.haitunhv.dao;

import com.haitunhv.domain.Skill;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/4/10 15:36
 */
public interface SkillDao {
    boolean save(Skill skill);

    boolean update(Skill skill);

    boolean remove(Integer id);

    @Select("SELECT * FROM skill WHERE id = #{id}")
    Skill get(Integer id);

    @Select("SELECT * FROM skill")
    List<Skill> list();
}
