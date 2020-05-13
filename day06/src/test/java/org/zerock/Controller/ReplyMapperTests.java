package org.zerock.Controller;

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
	public void testInsert() {
		
		long bno = 4849609L;
		
		IntStream.range(1, 101).forEach((i)->{
			ReplyVO reply = ReplyVO.builder()
					.bno(bno)
					.reply("reply....."+i)
					.replyer("user"+(i%10))
					.build();
			mapper.insert(reply);
		});
		
	}
	
	
}
