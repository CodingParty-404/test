package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;

public interface BoardMapper {
	
	// 파라미터로 BoardVO, PageDTO를 주고 받음
	
	// 1. select 페이징처리 적용된 게시판 목록 조회
	// getPagingList
	public List<BoardVO> getPagingList(PageDTO pageDTO);
		
	// 2. select 데이터베이스에 있는 총 데이터량 조회
	// getTotal
	int getTotal(PageDTO pageDTO);
		
	// 3. select 선택한 글 조회
	public BoardVO selectOne(Long bno);
	///////////////////////////////////// 컨트롤러 list get
	
	// 4. insert 새글 등록
	public int insertBoard(BoardVO vo);
	///////////////////////////////////// 컨트롤러 register post
		
	// 5. delete 선택한 글 삭제
	public int deleteBoard(Long bno);
	///////////////////////////////////// 컨트롤러 remove post
	
	// 6. update 선택한 글 수정
	///////////////////////////////////// 컨트롤러 modify post
	public int updateBoard(BoardVO vo);

}
