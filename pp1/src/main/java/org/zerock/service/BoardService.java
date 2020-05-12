package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;

public interface BoardService {
	
	// 이 인터페이스는 비즈니스 계층
	// 이 인터페이스는 고객의 용어로 작성한다 (비즈니스 계층은 그렇다)
	
	int register(BoardVO vo) throws RuntimeException;
	
	int modify(BoardVO vo) throws RuntimeException;
	
	int remove(Long bno) throws RuntimeException;
	
	BoardVO get(Long bno) throws RuntimeException;
	
	List<BoardVO> getList(PageDTO pageDTO) throws RuntimeException;
	
	int getTotal() throws RuntimeException;
  
}
