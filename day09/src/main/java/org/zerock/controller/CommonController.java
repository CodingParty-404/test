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
	public void accessError(Authentication auth, Model model)
	{
		log.error(auth.getCredentials());
		log.error(auth.getAuthorities());
	}
	
	@GetMapping("/customLogin")
	public void customLogin(String error, String logout, Model model)
	{
		log.info("CUSTOM LOGIN GET.................................................");
	}
	
	@GetMapping("/customLogout")
	public void customLogout()
	{
		log.info("CUSTOM LOGOUT GET.......................................");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
