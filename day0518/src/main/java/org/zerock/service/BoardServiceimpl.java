package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;

@Service
@Setter
public class BoardServiceimpl implements BoardService {
		
	@Autowired
	private BoardMapper mapper;

	@Override
	public List<BoardVO> getList(PageDTO pageDTO) throws RuntimeException {
		// 1. 페이징 적용된 리스트 조회
		return mapper.getPagingList(pageDTO);
	}

	@Override
	public int getTotal(PageDTO pageDTO) throws RuntimeException {
		// 2. 데이터 전체량 조회
		return mapper.getTotal(pageDTO);
	}

	@Override
	public BoardVO getOne(Long bno) throws RuntimeException {
		// 3. 특정 글 조회
		return mapper.selectOne(bno);
	}

	@Override
	public int register(BoardVO vo) throws RuntimeException {
		// 4. 등록
		return mapper.insertBoard(vo);
	}

	@Override
	public int remove(Long bno) throws RuntimeException {
		// 5. 삭제
		return mapper.deleteBoard(bno);
	}

	@Override
	public int modify(BoardVO vo) throws RuntimeException {
		// 6. 수정
		return mapper.updateBoard(vo);
	}
	
	

}
