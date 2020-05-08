package org.zerock.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.MemberMapper;
import org.zerock.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTest {
	
	@Autowired
	MemberMapper mapper;
	
	// �����ֱⰡ ª�Ƽ� bean���� ������ �ʴ´�
	MemberVO vo; 
	
	@Test
	public void testMemberInsert() {
		
		// ���������� ó��
		vo = new MemberVO();
		
		vo.setMid("uer44");
		vo.setMpw("1234");
		vo.setMname("j");
		
		log.info(mapper.addMember(vo));
	}
	
	@Test
	public void testRead() {
		
		MemberVO vo = mapper.getMember("uer66");
		log.info(vo);
	
	}
	
	@Test
	public void testDelete() {
		
		log.info(mapper.deleteMember("uer66"));
	}
	
	
	// ���� ����
	@Test
	public void testUpdate() {
		MemberVO vo = MemberVO.builder().mid("1").mpw("1234").mname("Go Gil Dong").build();
		
		log.info(mapper.updateMember(vo));
	}

}
