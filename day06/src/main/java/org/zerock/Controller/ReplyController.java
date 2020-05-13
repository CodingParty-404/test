package org.zerock.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/all/{bno}")
	public ResponseEntity<List<ReplyVO>> getAllReply(@PathVariable("bno") Long bno){
		ResponseEntity<List<ReplyVO>> result = new ResponseEntity<>(mapper.getList(bno), HttpStatus.OK);
		return result;
	}
}
