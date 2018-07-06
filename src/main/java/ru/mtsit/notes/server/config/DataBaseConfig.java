package ru.mtsit.notes.server.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@PropertySource("classpath:db.properties") //ссылка на конфигурационный файл с параметрами базы данных
@ComponentScan("ru.mtsit.notes.server")
@EnableTransactionManagement
@EnableJpaRepositories("ru.mtsit.notes.server.repository")

public class DataBaseConfig {

    @Resource
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(env.getRequiredProperty("bd.entity.package"));
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getHibernateProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory().getObject());
        return manager;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        try {

            InputStream is = getClass().getClassLoader().getResourceAsStream("hibernate.properties");
            properties.load(is);
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't find 'hibernate.properties'" + e);
        }
        return properties;
    }


    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();

        ds.setUrl(env.getRequiredProperty("bd.url"));
        ds.setDriverClassName(env.getRequiredProperty("bd.driver"));
        ds.setUsername(env.getRequiredProperty("bd.username"));
        ds.setPassword(env.getRequiredProperty("bd.password"));

        ds.setInitialSize(Integer.valueOf(env.getRequiredProperty("bd.initialSize")));
        ds.setMinIdle(Integer.valueOf(env.getRequiredProperty ("bd.minIdle")));
        ds.setMaxIdle(Integer.valueOf(env.getRequiredProperty ("bd.maxIdle")));
        ds.setTimeBetweenEvictionRunsMillis(Long.valueOf(env.getRequiredProperty("bd.timeBetwieenEvictionRunsMillis")));
        ds.setMinEvictableIdleTimeMillis(Long.valueOf(env.getRequiredProperty("bd.minEvictableIdlesMillis")));
        ds.setTestOnBorrow(Boolean.valueOf(env.getRequiredProperty("bd.testOnBorow")));
        ds.setValidationQuery(env.getRequiredProperty("bd.validationQuere"));

        return ds;
    }

}
