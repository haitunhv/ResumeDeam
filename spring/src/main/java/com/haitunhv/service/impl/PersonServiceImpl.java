package com.haitunhv.service.impl;

import com.haitunhv.dao.PersonDao;
import com.haitunhv.factory.GeneralFactory;
import com.haitunhv.service.PersonService;

/**
 * @Author: haitunhv
 * @Date: 2021/3/27 21:14
 */
public class PersonServiceImpl implements PersonService {
//    private PersonDao personDao = GeneralFactory.get("personDao");
    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public int remove(Integer id) {
        return personDao.remove(id);
    }
}
