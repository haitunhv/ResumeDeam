package com.haitunhv.bean;

import com.haitunhv.bean.base.BaseBean;

/**
 * @Author: haitunhv
 * @Date: 2021/2/28 19:29
 */
public class Skill extends BaseBean {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


}
