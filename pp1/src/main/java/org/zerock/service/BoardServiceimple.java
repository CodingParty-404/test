package org.zerock.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Service
@Log4j
@Setter
public class BoardServiceimple implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;



	@Override
	public void register(BoardVO vo) throws RuntimeException {

		// 문제가 생기면 RuntimeException 발생할거니까 이렇게만 써도 됨
		mapper.insertBoard(vo);

	}

	@Override
	public void modify(BoardVO vo) throws RuntimeException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Long bno) throws RuntimeException {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO get(Long bno) throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> getList() throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}



}
