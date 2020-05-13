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

		// 臾몄젣媛� �깮湲곕㈃ RuntimeException 諛쒖깮�븷嫄곕땲源� �씠�젃寃뚮쭔 �뜥�룄 �맖
		return mapper.insert(vo);

	}

	@Override
	public int modify(BoardVO vo) throws RuntimeException {
		
		 return mapper.update(vo);
	}

	@Override
	public int remove(Long bno) throws RuntimeException {
		
		 return mapper.delete(bno);

	}

	@Override
	public BoardVO get(Long bno) throws RuntimeException {
		
		return mapper.select(bno);
	}

	@Override
	public List<BoardVO> getList(PageDTO pageDTO) throws RuntimeException {
		
		
		return mapper.getList(pageDTO);
	}
	
	@Override
	public int getTotal(PageDTO pageDTO) throws RuntimeException {
		
		
		return mapper.getTotal(pageDTO);
		
	}


}
