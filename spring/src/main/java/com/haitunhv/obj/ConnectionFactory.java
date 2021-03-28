package com.haitunhv.obj;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Author: gss
 * @Date: 2021/3/28 20:30
 */
public class ConnectionFactory {
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
//    静态
//    public static Connection getConn() throws Exception{
//        Class.forName("com.mysql.jdbc.Driver");
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/xr","root","root");
//    }

//实例
    public Connection getConn() throws Exception{
        Class.forName(driver);
        return DriverManager.getConnection(url,username,password);
    }
}
