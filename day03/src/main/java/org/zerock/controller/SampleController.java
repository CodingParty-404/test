package org.zerock.controller;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/")
@Log4j
public class SampleController {

	@GetMapping("")
	public void basic() {
		log.info("basic.........");
		
		
	}
	
	
	
	@GetMapping("/rx01")
	public String rx01(@ModelAttribute("param") String param, RedirectAttributes rttr) {
		
		log.info("param:" + param);
			
		rttr.addAttribute("msg", "AAA");
		rttr.addAttribute("result", "BBB");
		
		SampleDTO sample = new SampleDTO();
		sample.setName("a");
		sample.setAge(16);
		
		// rttr.addAttribute("sample", sample); 객체 자체로는 못가서 문자열로 바꿔야 한다
		rttr.addAttribute("sample", sample.toString());
		
		return "redirect:/sample/target2";
	}
	
	 
	
	
	
	@GetMapping("/ex01")
	public String ex01(@ModelAttribute("dto") SampleDTO dto, Model model) {
		
		log.info(dto);
		
		model.addAttribute("msg", "hello world");
		
		return "redirect:/sample/target";
	}
	
	@GetMapping("/target")
	public void target() {
		log.info("target");
	}
	
//	@InitBinder
//	public void initBiner(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	@GetMapping("/exMember")
	public void exMember(MemberVO vo) {
		log.info(vo);	
	}
	
	
	
	
}
