package org.zerock.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class MemberTest {

	@Autowired
	PasswordEncoder pwEncoder;
	@Autowired
	MemberMapper mapper;

	@Test
	public void testReadMember()
	{
		String userid = "sigkgk0";
		MemberVO vo = mapper.read(userid);
		List<AuthVO> authList = mapper.readAuth(userid);
		
		log.info(vo);
		log.info(authList);
		
		vo.setAuthList(authList);
	}
	@Test
	public void testReadAuth() {
		mapper.addAuth("sigkgk0", "ROLE_ADMIN");
	}
	
	@Test
	public void testAuth()
	{
		for (int i = 0; i < 100; i++) {
			mapper.addAuth("U"+i, "ROLE_MEMBER");
		}
	}
	
	@Test
	public void testAdd() {
		for (int i = 0; i < 30; i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("sigkgk" + i);
			vo.setUserpw(pwEncoder.encode("sigkgk" + i));
			vo.setUserName("김진호" + i);
			vo.setEnabled(true);
			log.info(mapper.addMember(vo));
		}
	}

	@Test
	public void testCompare() {
		String password = "aslkdjksjrbksjf";

		String en1 = pwEncoder.encode(password);
		log.info(en1);
		String en2 = pwEncoder.encode(en1);
		log.info(en2);

		log.info(pwEncoder.matches(en1, en2));
	}

}
