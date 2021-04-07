package com.haitunhv.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author: haitunhv
 * @Date: 2021/4/5 20:53
 */
@Configuration
@EnableTransactionManagement
public class TxConfig {
    @Bean
    public DataSourceTransactionManager mgr(DataSource dataSource){
        DataSourceTransactionManager mgr = new DataSourceTransactionManager();
        mgr.setDataSource(dataSource);
        return mgr;
    }
}
