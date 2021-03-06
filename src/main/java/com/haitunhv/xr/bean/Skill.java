package com.haitunhv.xr.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Author: gss
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

    @JsonIgnore
    public String getTypeString(){
        switch (level){
            case 1:return "熟悉";
            case 2:return "掌握";
            case 3:return "精通";
            default:return "了解";
        }
    }
}
