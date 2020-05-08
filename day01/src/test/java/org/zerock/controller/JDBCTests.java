package org.zerock.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

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
		
        String url = "jdbc:mysql://127.0.0.1/springex?serverTimezone=Asia/Seoul";
		String username = "springuser";
		String password = "springuser";
		
		
		Connection con = DriverManager.getConnection(url, username, password);
		log.info(con);
	}

}
