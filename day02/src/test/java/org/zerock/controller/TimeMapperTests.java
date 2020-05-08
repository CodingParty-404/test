package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Autowired
	TimeMapper mapper;
	
	@Test
	public void testGetTime() {
		
		log.info(mapper.getTime()); // 2020-05-07 12:35:50
		
		log.info(mapper.getClass().getName());
		
	}
	
	@Test
	public void testGetTime2() {
		log.info(mapper.getTime2());
	}

}
