package org.zerock.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	BoardMapper mapper;

	@Test
	public void selectTest() {
		
		BoardVO vo = new BoardVO();
		List<BoardVO> list = new ArrayList<>();
		
		
		 list = mapper.selectBoard();
		
		 Iterator it = list.iterator();
		 while(it.hasNext()){
			 log.info(it.next());
		 }
		
	}
	
	
	
	@Test
	public void insertTest() {
	
		BoardVO vo = new BoardVO();
		vo.setTitle("한글");
		vo.setContent("잘");
		vo.setWriter("들어가니");
		
		mapper.insertBoard(vo);
	}
	
	
	
	@Test
	public void deleteTest() {
				
		mapper.deleteBoard(4849556L);
	}
	
	
	
	@Test
	public void updateTest() {
		
		// bno로 select하면 vo 하나 반환하는 SQL메서드 필요
		BoardVO vo = mapper.selectOne(4849557L);
			
		vo.setTitle("bad");
		vo.setContent("night");
		
		
		mapper.updateBoard(vo);
	}

}
