package com.haitunhv.xr.bean;

import com.haitunhv.xr.bean.base.DateBean;

/**
 * @Author: haitunhv
 * @Date: 2021/3/6 23:28
 */
public class Project extends DateBean {
    private String name;
    private String intro;
    private String website;
    private String image;
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
