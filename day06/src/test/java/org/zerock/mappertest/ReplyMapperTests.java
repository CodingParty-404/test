package org.zerock.mappertest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import javax.activation.DataSource;

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
	public void testInsert()
	{
		long bno = 999920L;
		
		IntStream.range(1, 101).forEach((i)->{
			ReplyVO reply = ReplyVO.builder()
					.bno(bno)
					.reply("reply...."+i)
					.replyer("user"+(i%10))
					.build();
			mapper.insert(reply);
		});
	}
	@Test
	public void testDelete()
	{
		long rno = 200L;
		mapper.delete(rno);
	}
	@Test
	public void tesetUpdate()
	{
		long rno = 1L;
		ReplyVO reply = ReplyVO.builder()
				.rno(rno)
				.reply("UpdateTest")
				.build();
		log.info(reply);
		mapper.update(reply);
	}
}
