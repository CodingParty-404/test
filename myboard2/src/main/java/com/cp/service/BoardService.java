package com.cp.service;

import java.util.List;

import com.cp.domain.BoardVO;
import com.cp.dto.PageDTO;

public interface BoardService {
	
	void register(BoardVO vo) throws RuntimeException;
	void modify(BoardVO vo) throws RuntimeException;
	void remove(long bno) throws RuntimeException;
	BoardVO get(long bno) throws RuntimeException;
	List<BoardVO> getList(PageDTO pageDTO) throws RuntimeException;
}
