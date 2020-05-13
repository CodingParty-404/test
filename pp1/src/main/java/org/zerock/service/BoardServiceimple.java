package org.zerock.service;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
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
	public int register(BoardVO vo) throws RuntimeException {

		// 문제가 생기면 RuntimeException 발생할거니까 이렇게만 써도 됨
		return mapper.insertBoard(vo);

	}

	@Override
	public int modify(BoardVO vo) throws RuntimeException {
		
		 return mapper.updateBoard(vo);
	}

	@Override
	public int remove(Long bno) throws RuntimeException {
		
		 return mapper.deleteBoard(bno);

	}

	@Override
	public BoardVO get(Long bno) throws RuntimeException {
		
		return mapper.selectOne(bno);
	}

	@Override
	public List<BoardVO> getList(PageDTO pageDTO) throws RuntimeException {
		
		
		return mapper.getPagingList(pageDTO);
	}
	
	// 트렌젝션 처리가 되야할 필요가 있다
	@Override
	public int getTotal(PageDTO pageDTO) throws RuntimeException {
				
		return mapper.getTotal(pageDTO);
		
	}



}
