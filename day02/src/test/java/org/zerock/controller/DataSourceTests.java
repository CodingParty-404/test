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
	// �������� �ٶ󺸴� �� �������̽� Ÿ���̴ϱ�
	// ������ �������̽� Ÿ������ �����
	// ���� HikariDataSource��� ���� ��������� �������̽� Ÿ���� �� ������ �ڵ�
	
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
		
		assertNotNull(con); // null�� �ƴ϶�� �� Ȯ���ϴٸ�
		// �׽�Ʈ �ڵ忡�� ����ϴ� assert �ø���
		
		log.info(con);
		
		con.close();
	}
	
}
