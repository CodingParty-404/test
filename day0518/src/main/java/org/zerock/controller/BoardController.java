package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
import org.zerock.dto.PageMaker;
import org.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;

@RequestMapping("/board")
@Controller
@Log4j
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public void list(PageDTO pageDTO, Model model) {
		
		log.info("I'm in list Get.........");
		log.info(pageDTO);
		
		// 데이터베이스에서 데이터 총량을 조회한다
		int total = service.getTotal(pageDTO);
		// 총량 기준으로 PageMaker 만든다
		PageMaker pageMaker = new PageMaker(pageDTO, total);
		
		// 모델에 list, pageMaker 담아서
		// 뷰 list.jsp 로 보낸다
		model.addAttribute("list", service.getList(pageDTO));
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	@GetMapping("/read")
	public void read(Long bno, PageDTO pageDTO ,Model model) {
		
		log.info("I'm in read Get.........");
		
		BoardVO vo = service.getOne(bno);
		
		log.info(bno);
		log.info(vo);
		log.info(pageDTO.getPage());
		log.info(pageDTO.getAmount());
		log.info(pageDTO.getType());
		log.info(pageDTO.getKeyword());

		model.addAttribute("board", vo);
		model.addAttribute("pageDTO", pageDTO);	
	}
	
	@GetMapping("/register")
	public void registerG(PageDTO pageDTO, Model model) {
		
		log.info("I'm in register Get.........");
		log.info(pageDTO);
		
		model.addAttribute("pageDTO", pageDTO);
	}
	
	@PostMapping("/register")
	public String registerP(BoardVO vo, RedirectAttributes rttr) {
		// redirect to list.jsp
		
		log.info("I'm in register Post.........");
		log.info(vo);
		
		// 성공하면 1이 반환된다
		// result가 1이면 등록에 성공했다는 모달창을 띄우고
		// list로 리다이렉트 한다
		int result = service.register(vo);
		String answer = result == 1 ? "게시글이 등록 됐습니다." : "등록 실패";
		rttr.addFlashAttribute("result", answer);
		// rttr.addFlashAttribute("result", result == 1 ? "게시글이 등록됐습니다." : "");
		
		return "redirect:/board/list";
	}
	
	
	@GetMapping("/modify")
	public void modifyG(Long bno, PageDTO pageDTO, Model model) {
		
		log.info("I'm in modify Get.........");
		log.info(pageDTO);
		
		// bno 기준으로 BoardVO 만들기
		BoardVO vo = service.getOne(bno);
		
		model.addAttribute("board", vo);
		model.addAttribute("pageDTO", pageDTO);
	}
	
	
	@PostMapping("/modify")
	public String modifyP(Long bno, BoardVO vo,
			PageDTO pageDTO, RedirectAttributes rttr) {
		// redirect to list.jsp
		
		log.info("I'm in modify Post.........");
		log.info(bno);
		log.info(vo);
		log.info(pageDTO);
		
		int result = service.modify(vo);
		String answer = result == 1 ? "게시글이 수정 됐습니다." : "수정 실패";
				
		// 결과가 1이고 여기까진 잘 오는데
		log.info("수정 컨트롤러");
		log.info(pageDTO.getPage());
		log.info(pageDTO.getAmount());
		log.info(pageDTO.getType());
		log.info(pageDTO.getKeyword());
		
		log.info(pageDTO);
		// 여기까진 잘 살아있다가 list에서 못받는다

		// 리다이렉트로 전달할땐 문자열만 보낼 수 있다
		rttr.addAttribute("page", pageDTO.getPage());
		rttr.addAttribute("amount", pageDTO.getAmount());
		rttr.addAttribute("type", pageDTO.getType());
		rttr.addAttribute("keyword", pageDTO.getKeyword());
		rttr.addFlashAttribute("result", answer);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, PageDTO pageDTO,
			RedirectAttributes rttr) {
		// redirect to list.jsp
		log.info("I'm in remove Post.........");
		
		int result = service.remove(bno);
		String answer = result == 1 ? "게시글이 삭제 됐습니다." : "삭제 실패";
		log.info(answer);
		log.info(bno);
		log.info(pageDTO);
		
		// 리다이렉트로 전달할땐 문자열만 가능
		// pageDTO를 문자열로 전달
		rttr.addAttribute("page", pageDTO.getPage());
		rttr.addAttribute("amount", pageDTO.getAmount());
		rttr.addAttribute("type", pageDTO.getType());
		rttr.addAttribute("keyword", pageDTO.getKeyword());
		rttr.addFlashAttribute("result", answer);
		
		return "redirect:/board/list";
	}

}
