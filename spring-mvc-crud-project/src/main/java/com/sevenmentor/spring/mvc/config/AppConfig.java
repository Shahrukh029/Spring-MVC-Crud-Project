package com.sevenmentor.spring.mvc.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@EnableTransactionManagement
@EnableWebMvc
@Configuration
@ComponentScan(basePackages ="com.sevenmentor.spring.mvc")

public class AppConfig implements WebMvcConfigurer {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() throws PropertyVetoException {
	    ComboPooledDataSource dataSource = new ComboPooledDataSource();
	    dataSource.setDriverClass("com.mysql.jdbc.Driver");
	    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydatabase");
	    dataSource.setUser("user1");
	    dataSource.setPassword("User1user1#");
	    dataSource.setInitialPoolSize(5);
	    dataSource.setMinPoolSize(5);
	    dataSource.setMaxPoolSize(20);
	    dataSource.setMaxIdleTime(3000);
	 
	    return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) 
	{
	LocalSessionFactoryBean sessionBuilder = new LocalSessionFactoryBean();
	sessionBuilder.setDataSource(dataSource);
	sessionBuilder.setPackagesToScan("com.sevenmentor.spring.mvc.entity");
	Properties props=new Properties();
	props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	props.setProperty("hibernate.show_sql","true");
	sessionBuilder.setHibernateProperties(props);
	
	return sessionBuilder;
	
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	 
	    return transactionManager;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	

}