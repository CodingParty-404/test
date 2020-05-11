package com.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.domain.BoardVO;
import com.cp.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	@Override
	public void register(BoardVO vo) throws RuntimeException {
		mapper.insert(vo);
	}

	@Override
	public void modify(BoardVO vo) throws RuntimeException {
		mapper.update(vo);
	}

	@Override
	public void remove(long bno) throws RuntimeException {
		mapper.delete(bno);
	}

	@Override
	public BoardVO get(long bno) throws RuntimeException {
		log.info("Service Get......................................");
		BoardVO vo = mapper.select(bno);
		log.info(vo);
		return vo;
	}

	@Override
	public List<BoardVO> getList() throws RuntimeException {
		// TODO Auto-generated method stub
		return mapper.getList();
	}
	
	
	
}
