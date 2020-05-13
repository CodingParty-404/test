package org.zerock.controller;


import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.ReplyMapper;
import org.zerock.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	ReplyMapper mapper;
	
	@Test
	public void testTime() {
		
		Long bno = 4849609L;
		
		// 100개 넣기
		IntStream.range(1, 101).forEach(i ->{
			
			ReplyVO reply = ReplyVO.builder().bno(bno).reply("rrrrr").replyer("hj").build();
			
			mapper.insert(reply);
		});
	}
}
