package com.cp.beantest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cp.config.RootConfig;
import com.cp.controller.DataSourceTests;
import com.zaxxer.hikari.HikariConfig;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BeanTest {
	@Test
	public void springAnnotationConfig(){
	  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
	  HikariConfig hikari = context.getBean(HikariConfig.class);
	  System.out.println(hikari.getClass().getName());
	}
}
