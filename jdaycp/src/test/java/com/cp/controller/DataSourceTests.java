package com.cp.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cp.config.RootConfig;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class DataSourceTests {
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	private SqlSessionFactory sessionfactory;
	
	@Test
	public void testDataSource() throws Exception {
		
		Connection con = datasource.getConnection();
		
		log.info(con);
		
	}
	
	@Test
	public void testSession() {
		
		SqlSession session = sessionfactory.openSession();
		log.info(session);
		
		session.close();
		
	}
	
	@Test
	public void testDataSourceBean() {
		
		log.info( "jhgkhgjhg"+ datasource);
	}
	

	
	
	

}
