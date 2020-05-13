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
import org.zerock.dto.PageDTO;
import org.zerock.dto.PageMaker;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	BoardMapper mapper;
	
	
	
	@Test
	public void test0512_2() {
		
		PageDTO pageDTO = new PageDTO(1, 100);
		int total = 260;
		// 출력 결과
		// PageMaker(pageDTO=PageDTO(page=12, amount=20), total=260, start=11, end=13, prev=true, next=false)
		// realEnd=13, tempEnd=20이라서 prev는 true고 next는 false다
		
		PageMaker maker = new PageMaker(pageDTO, total);
		
		log.info(maker);
		
	}
	
	
	@Test
	public void test0512_1() {
		
		// 이건 카운트할때에도 필요하다
		
		PageDTO pageDTO = new PageDTO(1, 10);
		// 검색조건이 없을때에도 잘 돌아간다
		pageDTO.setType("tcw");
		pageDTO.setKeyword("100");
		
		mapper.getPagingList(pageDTO).forEach(vo -> log.info(vo));
		
		
		log.info("total: " + mapper.getTotal(pageDTO));
		
	}
	



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
				
		mapper.deleteBoard(999892L);
	}
	
	
	
	@Test
	public void updateTest() {
		
		// bno로 select하면 vo 하나 반환하는 SQL메서드 필요
		BoardVO vo = mapper.selectOne(999894L);
			
		vo.setTitle("bad");
		vo.setContent("night");
		
		
		mapper.updateBoard(vo);
	}

}
