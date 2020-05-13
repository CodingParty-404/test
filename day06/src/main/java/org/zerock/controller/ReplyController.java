package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.mapper.ReplyMapper;
import org.zerock.vo.ReplyVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies")
@Log4j
@AllArgsConstructor
public class ReplyController {
	
	private ReplyMapper mapper;
	
	@PostMapping(value="/new", produces = "text/plain")
	public ResponseEntity<String> add(@RequestBody ReplyVO vo ){
		
		log.info(vo);
		
		mapper.insert(vo);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
		
	}
	
	
	// 목록부터 본다
	// p.392
	// 레스트 컨트롤러의 모든 리턴 타입은 리스펀스 엔티티로 쓴다
	// 경로에 적은 의미: 특정 게시물의 변수명을 알아온다
	@GetMapping("/all/{bno}")
	public ResponseEntity<List<ReplyVO>> getAllReply(@PathVariable("bno") Long bno){
		
		// 리스펀스 엔티티 만들자
		// html 상태 코드
		// 브라우저가 잘 알아먹게 개발단계에서 상태코드를 조절해서 보내야함
		ResponseEntity<List<ReplyVO>> result =
				new ResponseEntity<List<ReplyVO>>(mapper.list(bno), HttpStatus.OK);
		
		return result;
		// 이 메서드 테스트는 YET ANOTHER REST Client로 한다
	}
}
