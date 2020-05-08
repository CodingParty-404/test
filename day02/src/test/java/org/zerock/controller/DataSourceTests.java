package org.zerock.controller;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
	
	@Autowired
	private DataSource dataSource;
	// 스프링이 바라보는 건 인터페이스 타입이니까
	// 무조건 인터페이스 타입으로 적어라
	// 직접 HikariDataSource라고 만들어도 상관없지만 인터페이스 타입이 더 유연한 코드
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void testSessionFactory() throws Exception {
		SqlSession session = sessionFactory.openSession();
		
		log.info(session);
		
		session.close();
	}
	
	@Test
	public void testConnection() throws Exception {
		
		Connection con = dataSource.getConnection();
		
		assertNotNull(con); // null이 아니라는 게 확실하다면
		// 테스트 코드에서 사용하는 assert 시리즈
		
		log.info(con);
		
		con.close();
	}
	
}
