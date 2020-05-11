package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	
	// 이 인터페이스는 비즈니스 계층
	// 이 인터페이스는 고객의 용어로 작성한다 (비즈니스 계층은 그렇다)
	
	void register(BoardVO vo) throws RuntimeException;
	
	void modify(BoardVO vo) throws RuntimeException;
	
	void remove(Long bno) throws RuntimeException;
	
	BoardVO get(Long bno) throws RuntimeException;
	
	List<BoardVO> getList() throws RuntimeException;
  
}
