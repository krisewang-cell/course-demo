package com.course.wang.config.db;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Wangjunlei
 * @date 2021/3/10 12:46 下午
 */
@Configuration
public class DataSourceConfig {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.datasource.hikari.jdbc-url}")
    private String url;
    @Value("${spring.datasource.hikari.username}")
    private String userName;
    @Value("${spring.datasource.hikari.password}")
    private String passWord;
    @Value("${spring.datasource.hikari.driver-class-name}")
    private String driverClassName;

    @Bean("courseDataSource")
    public DataSource courseDataSource() {
        logger.info("初始化数据库参数...,url:{},username:{},password:{},driver:{}", url
                , userName, passWord, driverClassName);
        HikariDataSource dataSource = new HikariDataSource();
        try {
            dataSource.setUsername(userName);
            dataSource.setPassword(passWord);
            dataSource.setJdbcUrl(url);
            dataSource.setDriverClassName(driverClassName);
        } catch (Exception e) {
            logger.error("参数获取异常..");
        }
        return dataSource;
    }
}
