package com.haitunhv.obj;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author: gss
 * @Date: 2021/3/28 21:21
 */
public class ConnectionFactoryBean implements FactoryBean<Connection> {
    private String driver;
    private String url;
    private String username;
    private String password;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public Connection getObject() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url,username,password);
    }

    @Override
    public Class<?> getObjectType() {
        return Connection.class;
    }
}
