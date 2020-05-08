package com.cp.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


@Log4j
public class JDBCTests {
	
	@Test
	public void testConnect() throws Exception {
		log.info("testConnection success");
		Class clz = Class.forName("com.mysql.cj.jdbc.Driver");
		log.info(clz);
		// 강사님 아이피 56
		// 진호 아이피 34
		// 내 아이피 127.0.0.1
		
        String url = "jdbc:mysql://cpserver.cdeamujkn2lg.ap-northeast-2.rds.amazonaws.com/cpspringex?serverTimezone=Asia/Seoul";
		String username = "cpspringuser";
		String password = "cpspringuser";
		
		
		Connection con = DriverManager.getConnection(url, username, password);
		log.info(con);
	}

}
