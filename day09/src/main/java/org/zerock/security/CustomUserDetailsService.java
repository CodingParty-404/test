package org.zerock.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.extern.log4j.Log4j;


@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberMapper mapper;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("==============================================================");
		log.info("==============================================================");
		log.info(username);
		
		MemberVO vo = mapper.read(username);
		List<AuthVO> authList = mapper.readAuth(username); 
		vo.setAuthList(authList);
		log.info(vo);
		
		log.info("==============================================================");
		log.info("==============================================================");
		
		return vo;
	}

}
