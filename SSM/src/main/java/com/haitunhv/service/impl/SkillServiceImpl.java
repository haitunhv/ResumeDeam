package com.haitunhv.service.impl;

import com.haitunhv.dao.SkillDao;
import com.haitunhv.domain.Skill;
import com.haitunhv.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: haitunhv
 * @Date: 2021/4/10 15:49
 */
@Service
@Transactional
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillDao skillDao;

    @Override
    public boolean save(Skill skill) {
        Integer id = skill.getId();
        if (id == null || id <1){
            skillDao.save(skill);
        }
        return skillDao.update(skill);
    }

    @Override
    public boolean remove(Integer id) {
        return skillDao.remove(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Skill get(Integer id) {
        return skillDao.get(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Skill> list() {
        return skillDao.list();
    }
}
