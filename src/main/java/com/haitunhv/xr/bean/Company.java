package com.haitunhv.xr.bean;

import com.haitunhv.xr.bean.base.BaseBean;

/**
 * @Author: gss
 * @Date: 2021/3/6 23:28
 */
public class Company extends BaseBean {
    private String name;
    private String logo;
    private String website;
    private String intro;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
