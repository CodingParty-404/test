package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
import org.zerock.dto.PageMaker;
import org.zerock.service.BoardService;
import org.zerock.service.BoardServiceimple;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board")
@Log4j
public class BoardController {

	@Autowired
	BoardService service;


	@GetMapping("/list")
	public void list(PageDTO pageDTO, Model model) {
		
		// db에서 total 가져오기
		int total = service.getTotal();
		
		model.addAttribute("list", service.getList(pageDTO)); // view에 pageDTO 보내고
		model.addAttribute("pageMaker", new PageMaker(pageDTO, total)); // view에 pageMaker 보내
		
	}


	@GetMapping("/register")
	public void register() {

		log.info("register.....");
	}


	// 포스트 방식으로 들어오면
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		// post로 들어오면 리다이렉트할거야

		log.info(vo);

		int result = service.register(vo);
		log.info("등록된 게시글 수 result = "+result);
		// result가 1이면 등록에 성공

		// 새 글이 등록했다고 성공을 알려줄거야
		// FlashAttribute니까 세션에 저장됨
		rttr.addFlashAttribute("result", result == 1 ? "게시글이 등록됐습니다." : "");

		return "redirect:/board/list";
	}

	@GetMapping({"/read", "/modify"})
	public void read(Long bno, Model model) {

		BoardVO vo = new BoardVO(); 

		vo = service.get(bno);
		log.info(bno);
		log.info(vo);

		model.addAttribute("board", vo);
	}

	@PostMapping("/modify")
	public String modify(Long bno, BoardVO vo, RedirectAttributes rttr) {
		log.info("modify post....");
		log.info("modifiy BoardVO = "+vo);
		//service 호출해서 성공시  리다이렉트의 플래시 파라미터에 문자열을 추가한다.

		int resultNum = service.modify(vo);
		log.info(resultNum);

		rttr.addFlashAttribute("result", resultNum == 1 ? "게시글이 수정됐습니다." : "");

		return "redirect:/board/list";
	}



	@PostMapping(value = "/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		int resultNum = service.remove(bno);
		log.info(resultNum);

		rttr.addFlashAttribute("result", resultNum == 1 ? "게시글이 삭제됐습니다." : "");

		return "redirect:/board/list";

	}


}
