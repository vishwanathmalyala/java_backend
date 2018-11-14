package com.arun.application.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class BeanConfiguration {

  @Value("${db.url}")
  private String url;
  @Value("${db.user}")
  private String user;
  @Value("${db.password}")
  private String password;

  @Bean(destroyMethod = "close")
  SessionFactory sessionFactory() {
    org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();
    config.addAnnotatedClass(com.arun.application.entity.WelcomeTable.class);
    config.addProperties(getProperterties());
    return config.buildSessionFactory();
  }

  private Properties getProperterties() {
    Properties p = new Properties();
    p.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
    System.out.println(url);
    p.setProperty("hibernate.connection.url", url);
    p.setProperty("hibernate.connection.user", user);
    p.setProperty("hibernate.connection.password", password);
    p.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    p.setProperty("hibernate.show_sql", "true");
    return p;
  }
}
