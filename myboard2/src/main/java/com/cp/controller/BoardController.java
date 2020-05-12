package com.cp.controller;

import java.util.List;

import javax.jws.WebParam.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cp.domain.BoardVO;
import com.cp.dto.PageDTO;
import com.cp.service.BoardService;
import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	@Autowired
	BoardService boardService;

	@GetMapping("/list")
	public void list(PageDTO pageDTO, Model model) {
		log.info("list Get............................................");
		List<BoardVO> list = boardService.getList(pageDTO);
		model.addAttribute("list", list);
	}
	

	@GetMapping("/register")
	public void register() {
		log.info("register Get................");
	}

	@PostMapping({ "/register", "/modify" })
	public String register(BoardVO vo, RedirectAttributes rttr) {
		log.info("register post..................................");
		log.info(vo);
		boardService.register(vo);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/list";
	}

	@GetMapping({ "/read", "/modify" })
	public void read(Long bno, Model model) {
		log.info("READ get.........................");
		log.info(bno);
		BoardVO vo = boardService.get(bno);
		model.addAttribute("onePost", vo);
	}

	@GetMapping("/remove") // POST 방식으로 처리 할수있게.
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("remove get....................................");
		log.info(bno);
		boardService.remove(bno);
		rttr.addFlashAttribute("result", "success");
		return "redirect:/board/list";
	}
}
