package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/sample")
@Controller
public class SampleController {

	//로그인 사용자 page
	//로그인 x page
	// admin page
	
	@GetMapping("/all")
	public void doAll()
	{
		log.info("ALL.................................");
	}
	
	@GetMapping("/member")
	public void doMember()
	{
		log.info("member................................");
	}
	
	@GetMapping("/admin")
	public void doAdmin()
	{
		log.info("admin.................................");
	}
	
	
	
	
	
}
