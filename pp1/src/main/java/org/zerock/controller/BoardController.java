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
		
		// db�뿉�꽌 total 媛��졇�삤湲�
		int total = service.getTotal(pageDTO);
		
		model.addAttribute("list", service.getList(pageDTO)); // view�뿉 pageDTO 蹂대궡怨�
		model.addAttribute("pageMaker", new PageMaker(pageDTO, total)); // view�뿉 pageMaker 蹂대궡
		
	}


	@GetMapping("/register")
	public void register() {

		log.info("register.....");
	}


	// �룷�뒪�듃 諛⑹떇�쑝濡� �뱾�뼱�삤硫�
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		// post濡� �뱾�뼱�삤硫� 由щ떎�씠�젆�듃�븷嫄곗빞

		log.info(vo);

		int result = service.register(vo);
		log.info("�벑濡앸맂 寃뚯떆湲� �닔 result = "+result);
		// result媛� 1�씠硫� �벑濡앹뿉 �꽦怨�

		// �깉 湲��씠 �벑濡앺뻽�떎怨� �꽦怨듭쓣 �븣�젮以꾧굅�빞
		// FlashAttribute�땲源� �꽭�뀡�뿉 ���옣�맖
		rttr.addFlashAttribute("result", result == 1 ? "寃뚯떆湲��씠 �벑濡앸릱�뒿�땲�떎." : "");

		return "redirect:/board/list";
	}

	@GetMapping({"/read", "/modify"})
	public void read(Long bno, Model model, Integer  page, Integer amount) {

		BoardVO vo = new BoardVO(); 
		log.info(page);
		log.info(amount);
		PageDTO dto = new PageDTO(page, amount);
		log.info("readPage................................................................................");
		log.info(dto);
		vo = service.get(bno);
		log.info(bno);
		log.info(vo);

//		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("board", vo);
	}

	@PostMapping("/modify")
	public String modify(Long bno, BoardVO vo, RedirectAttributes rttr) {
		log.info("modify post....");
		log.info("modifiy BoardVO = "+vo);
		//service �샇異쒗빐�꽌 �꽦怨듭떆  由щ떎�씠�젆�듃�쓽 �뵆�옒�떆 �뙆�씪誘명꽣�뿉 臾몄옄�뿴�쓣 異붽��븳�떎.

		int resultNum = service.modify(vo);
		log.info(resultNum);

		rttr.addFlashAttribute("result", resultNum == 1 ? "寃뚯떆湲��씠 �닔�젙�릱�뒿�땲�떎." : "");

		return "redirect:/board/list";
	}



	@PostMapping(value = "/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		int resultNum = service.remove(bno);
		log.info(resultNum);

		rttr.addFlashAttribute("result", resultNum == 1 ? "寃뚯떆湲��씠 �궘�젣�릱�뒿�땲�떎." : "");

		return "redirect:/board/list";

	}


}
