package com.course.wang.config;

import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Wangjunlei
 * @apiNote 库配置
 * @date 2021/3/10 12:42 下午
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryCourse",
        transactionManagerRef = "transactionManagerCourse",
        basePackages = {"com.course.wang.dao"}
)
public class CourseConfig {
    private final DataSource dataSource;

    public CourseConfig(@Qualifier("courseDataSource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean("entityManagerFactoryCourse")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryCourse(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource)
                .packages("com.course.wang.entity")
                .persistenceUnit("coursePersistenceUnit")
                .build();
    }

    @Bean(name = "transactionManagerCourse")
    PlatformTransactionManager transactionManagerCapitalBak(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryCourse(builder).getObject()));
    }
}
