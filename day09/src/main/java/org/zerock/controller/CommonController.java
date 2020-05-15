package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class CommonController {
	
	@GetMapping("/accessError")
	public void acessError(Authentication auth, Model model) {
		
		log.error(auth.getCredentials());
		log.error(auth.getAuthorities());
		

	}
	
	// 커스텀 로그인
	// p.631
	@GetMapping("/customLogin")
	public void customLogin() {
		
		
	}
	
	// 커스텀 로그아웃
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom logout");
	}

}
