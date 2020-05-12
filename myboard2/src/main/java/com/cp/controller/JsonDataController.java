package com.cp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.domain.BoardVO;
import com.cp.dto.PageDTO;
import com.cp.service.BoardService;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/json")
@Log4j
public class JsonDataController {

	@Autowired
	BoardService boardService;
	
	@CrossOrigin
	@GetMapping(value="/getlist",produces = "text/plain; charset=utf-8")
	public String getList(Integer pageNum)
	{
		//Json으로 만들어서
		if(pageNum ==null || pageNum <=0)
			pageNum = 1;
		PageDTO pageDTO = new PageDTO(pageNum, 50);
		Gson gson = new Gson();
		return 	gson.toJson(boardService.getList(pageDTO));
	}
	@GetMapping(value="/getsample",produces = {MediaType.APPLICATION_JSON_VALUE,
												MediaType.APPLICATION_XML_VALUE})
	public BoardVO getSample()
	{
		log.info("getSample;..............................................");
		return 	boardService.get(4849599);
	}
	
}
