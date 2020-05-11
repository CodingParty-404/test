package com.cp.mappertests;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cp.commontest.CommonTest;
import com.cp.domain.BoardVO;
import com.cp.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class BoardMapperTests extends CommonTest{
	@Autowired
	BoardMapper boardMapper;
	
	@Test
	public void getList()
	{
		boardMapper.getList().forEach((vo)->log.info(vo));
	}
	@Test
	public void select()
	{
		log.info(boardMapper.select(4849570L));
	}
	@Test
	public void delete()
	{
		log.info(boardMapper.delete(4849563L));
	}
	@Test
	public void insert()
	{
		BoardVO vo = new BoardVO();
		vo.setTitle("���Ÿ��Ʋ");
		vo.setContent("��γ���");
		vo.setWriter("��ι�");
		
		log.info(boardMapper.insert(vo));
	}
	@Test
	public void update()
	{
		BoardVO vo = boardMapper.select(4849564L);
		vo.setTitle("�ȳ�Ÿ��Ʋ");
		vo.setContent("�ȳ���������������");
		boardMapper.update(vo);
	}
}
