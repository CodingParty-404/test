package org.zerock.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataSource;

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
		
		PageDTO pageDTO = new PageDTO(12, 20);
		int total = 260;
		// 異쒕젰 寃곌낵
		// PageMaker(pageDTO=PageDTO(page=12, amount=20), total=260, start=11, end=13, prev=true, next=false)
		// realEnd=13, tempEnd=20�씠�씪�꽌 prev�뒗 true怨� next�뒗 false�떎
		
		PageMaker maker = new PageMaker(pageDTO, total);
		
		log.info(maker);
		
		
	}
	
	
	@Test
	public void test0512_1() {
		
		PageDTO pageDTO = new PageDTO(10, 10);
		
		mapper.getList(pageDTO).forEach(vo -> log.info(vo));
		
	}


	@Test
	public void selectTest() {
		
		BoardVO vo = new BoardVO();
		List<BoardVO> list = new ArrayList<>();
		
		
//		 list = mapper.select(0L);
		
		 Iterator it = list.iterator();
		 while(it.hasNext()){
			 log.info(it.next());
		 }
		
	}
	
	
	
	@Test
	public void insertTest() {
	
		BoardVO vo = new BoardVO();
		vo.setTitle("�븳湲�");
		vo.setContent("�옒");
		vo.setWriter("�뱾�뼱媛��땲");
		
		mapper.insert(vo);
	}
	
	
	
	@Test
	public void deleteTest() {
				
		mapper.delete(4849556L);
	}
	
	
	
	@Test
	public void updateTest() {
		
		// bno濡� select�븯硫� vo �븯�굹 諛섑솚�븯�뒗 SQL硫붿꽌�뱶 �븘�슂
		BoardVO vo = mapper.select(4849557L);
			
		vo.setTitle("bad");
		vo.setContent("night");
		
		
		mapper.update(vo);
	}
	
	
	
	@Test
	public void findList() {
		BoardVO vo = new BoardVO();
		PageDTO dto = new PageDTO(1, 10);
		dto.setKeyword("00947");
		dto.setType("tcw");
		
		mapper.getFindList(dto).forEach(g->log.info(g));
		
	}

}
