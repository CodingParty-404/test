package org.zerock.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.vo.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping("/hello")
	public String hello() {
		
		return "Hello";
	};
	
	
	// consumes는 어떤 타입으로 받을 지 지정
	// produces는 어떤 타입으로 보낼 지 지정
	@PostMapping(value="/s1", produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleVO getSample() {
		
		return new SampleVO(122, "star", "load");
	}
	
	@PostMapping(value="/s2", produces = MediaType.APPLICATION_JSON_VALUE)
	public SampleVO getSample(@RequestBody SampleVO vo) {
		// @RequestBody 리퀘스트바디가 JSON을 처리한다
		
		log.info(vo);
		
		return new SampleVO(562, "카메론", "제임스");
	}

}
