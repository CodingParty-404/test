package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/sample")
public class SampleController {	
	
	// 로그인 노우
	@GetMapping("/all")
	public void doAll() {		
		log.info("all");
	}
	
	// 로그인 예쓰
	@GetMapping("/member")
	public void doMember() {
		log.info("member");
	}
	
	// 어드민 온리
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("admin");
	}
	
}
