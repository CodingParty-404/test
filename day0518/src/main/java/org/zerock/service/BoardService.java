package org.zerock.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
import org.zerock.mapper.BoardMapper;

public interface BoardService {
	
	// 인터페이스는 비즈니스 계층이니까
	// 고객이 사용하는 용어로 쓴다
		
	// 1. 페이징 리스트 조회
	List<BoardVO> getList(PageDTO pageDTO) throws RuntimeException;
	
	// 2. db 내 데이터 총량 조회
	int getTotal(PageDTO pageDTO) throws RuntimeException;
	
	// 3. 특정 게시물 조회
	BoardVO getOne(Long bno) throws RuntimeException;
	
	// 4. 새 글 등록
	int register(BoardVO vo) throws RuntimeException;
	
	// 5. 선택한 글 삭제
	int remove(Long bno) throws RuntimeException;
	
	// 6. 선택한 글 수정
	int modify(BoardVO vo) throws RuntimeException;
	
	
}
