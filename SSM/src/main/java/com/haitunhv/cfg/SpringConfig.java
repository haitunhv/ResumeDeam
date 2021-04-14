package com.haitunhv.cfg;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author: haitunhv
 * @Date: 2021/4/13 22:28
 */
@ComponentScan({"com.haitunhv.service","com.haitunhv.converter"})
@PropertySource("classpath:db.properties")
@MapperScan("${mybatis.mapperScan}")
@EnableTransactionManagement
public class SpringConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;
    @Value("${mybatis.configLocation}")
    private String configLocation;
    @Bean
    public DataSource dataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setTypeAliasesPackage(typeAliasesPackage);
        bean.setConfigLocation(new ClassPathResource(configLocation));
        return bean;
    }
    @Bean
    public DataSourceTransactionManager mgr(DataSource dataSource){
        DataSourceTransactionManager mgr = new DataSourceTransactionManager();
        mgr.setDataSource(dataSource);
        return mgr;
    }
}
