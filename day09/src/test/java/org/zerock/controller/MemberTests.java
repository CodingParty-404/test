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
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
	})
@Log4j
public class MemberTests {
	
	@Autowired
	PasswordEncoder pwEncoder;
	
	@Test
	public void testCompare() {
		
		// PasswordEncoder은 복호화는 안돼
		// 그래서 대칭 비교만 할 수 있다. 비대칭 비교는 불가
		
		String password = "1234";
		
		String en1 = pwEncoder.encode(password);	
		log.info(en1);
		
		String en2 = pwEncoder.encode(password);		
		log.info(en2);
		
		// 둘이 맞는지 비교
		log.info(pwEncoder.matches(password, en1));
		log.info(pwEncoder.matches(password, en2));
	}
	
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void testAdd() {
		
		for(int i = 0; i < 30; i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("hj"+i); // db pk 충돌나면 db에 안들어가고 테스트 오류남
			vo.setUserpw(pwEncoder.encode("hj"+i)); // 비밀번호는 암호화 해서 만들어야 해
			vo.setUsername("사용자"+i);
			vo.setEnabled(true);
			log.info(mapper.addMember(vo));
			
		}
	}
	
	
	@Test
	public void testAddAuth() {
		AuthVO vo = new AuthVO();
		
		// 테이블에 멤버 넣는 코드
		//for(int i = 0; i < 30; i++) {
		//	log.info(mapper.addMemberAuth("hj"+i, "ROLE_MEMBER"));			
		//}
		
		// 권한 부여하는 코드
		// log.info(mapper.addMemberAuth("hj0", "ROLE_ADMIN"));
	}
	
	
	@Test
	public void testReadMember() {
			
		String userid = "wewe1";
		MemberVO vo = mapper.read(userid);
		List<AuthVO> authList = mapper.readAuth(userid);
		
		log.info(vo);
		log.info(authList);
		
		vo.setAuthList(authList);

	}
	

}
