package com.haitunhv.xr.bean;

import com.haitunhv.xr.bean.base.DateBean;

/**
 * @Author: haitunhv
 * @Date: 2021/3/6 23:28
 */
public class Experience extends DateBean {
    private String job;
    private String intro;
    private Company company;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
