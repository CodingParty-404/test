package com.cp.dbtests;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cp.commontest.CommonTest;

import lombok.extern.log4j.Log4j;

@Log4j
public class DBTest extends CommonTest {
	
	@Autowired
	DataSource da;
	
	@Test
	public void jdbcTest() throws Exception
	{
		Connection connection = da.getConnection();
		
		log.info(connection);
	}
	
	@Test
	public void mybatisTest() throws Exception
	{
	} 
	
}
