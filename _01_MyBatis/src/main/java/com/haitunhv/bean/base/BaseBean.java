package com.haitunhv.bean.base;

import java.util.Date;

/**
 * @Author: haitunhv
 * @Date: 2021/2/21 23:41
 */
public abstract class BaseBean {
    private Integer id;
    private Date createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   // @JsonIgnore
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
