package org.zerock.controller;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PagingVO;
import org.zerock.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	BoardMapper mapper;
	
	
	
	@Test
	public void test1() {
		
		// 1 - 0 스킵
		// 2 - 10 스킵
		// 3 - 20 스킵
		List<BoardVO> result = mapper.getList(10, 10);
		
		result.forEach(vo -> log.info(vo));
	}
	
	
	@Test
	public void test2() {
		
		PagingVO vo = new PagingVO();
		vo.setSkip(4);
		vo.setAmount(10);
		
		List<BoardVO> result = mapper.getList2(vo);
		result.forEach(boardlist -> log.info(boardlist));
	}

}
