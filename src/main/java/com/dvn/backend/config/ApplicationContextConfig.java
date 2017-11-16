package com.dvn.backend.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dvn.backend.model.UploadFile;
import com.dvn.backend.model.User;



@Configuration
@ComponentScan("com.dvn")
@EnableTransactionManagement
public class ApplicationContextConfig
{
	 @Bean(name="dataSource")
	 public DataSource getH2DataSource()
     {
     	System.out.println("Starting of the method getH2DataSource");
     	DriverManagerDataSource dataSource = new DriverManagerDataSource();
     	dataSource.setDriverClassName("org.h2.Driver");
     	dataSource.setUrl("jdbc:h2:~/thin1");
     	dataSource.setUsername("sa");
     	dataSource.setPassword("");
     	System.out.println("Data source creation");
     	return dataSource;
     }
	 
	 
	 @Autowired
     @Bean(name="sessionFactory")
	 public SessionFactory getSessionFactory(DataSource dataSource)
     {  
     	System.out.println("------Hibernate Properties----");
     	Properties prop = new Properties();
     	prop.setProperty("hibernate.hbm2ddl.auto", "update");
     	prop.put("hibernate.show_sql", "true");
     	prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
     	System.out.println("-----Hibernate properties created----");
     	
     	System.out.println("----Local session factory builder object creation----");
     	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
     	sessionBuilder.addProperties(prop);
     	System.out.println("-----Factory builder object created----");
     	
     	
     	sessionBuilder.addAnnotatedClass(User.class);
     	sessionBuilder.addAnnotatedClass(UploadFile.class);
     	
     	
     	
     	
     	System.out.println("Session factory object creation");
     	SessionFactory sessionFactory = sessionBuilder.buildSessionFactory();
     	System.out.println("Session factory object created");
     	return sessionFactory;
     	
     }
	 
	 @Autowired 
     @Bean(name="txManager")
     public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
     {
     	HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
     	
     	return transactionManager;
     }
   /*  
	 @Bean(name = "multipartResolver")
	    public CommonsMultipartResolver multipartResolver() {
	        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
	         
	       
	        return commonsMultipartResolver;
	    }
     */
   
     

}