package com.cp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cp.mapper.MemberMapper;
import com.cp.vo.MemberVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTests {
	
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void insertTest() {
		MemberVO member = new MemberVO();
		member.setMid("wewe1157");
		member.setMname("³ª°Ç³ç");
		member.setMpw("1234");
		log.info(mapper.addMember(member));
	}
	
	@Test
	public void selectTest() {
		log.info(mapper.getMember2("wewe1157"));
	}
	
	@Test
	public void deleteTest() {
		log.info(mapper.deleteMember2("wewe1157"));
	}

	@Test
	public void updateTest() {
		MemberVO member = new MemberVO();
		member.setMid("wewe1158");
		member.setMname("±è°Ç³ç");
		member.setMpw("1333");
		log.info(mapper.updateMember2(member));
	}
	
	@Test
	public void insertXMLTest() {
		MemberVO member = new MemberVO();
		member.setMid("wewe1158");
		member.setMname("³ª°Ç³ç");
		member.setMpw("1234");
		log.info(mapper.addMember2(member));
	}
	
}
