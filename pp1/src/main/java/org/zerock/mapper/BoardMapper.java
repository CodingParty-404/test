package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;



@Mapper
public interface BoardMapper{

	//10개의 리스트출력
	public List<BoardVO> getList(PageDTO pageDTO);
	
	public BoardVO select(long bno);
	//insert
	public int insert(BoardVO vo);
	//delete
	public int delete(long bno);
	//update
	public int update(BoardVO vo);
	
	//total
	public int getTotal(PageDTO pageDTO);
	
	//find
	public List<BoardVO> getFindList(PageDTO dto);
	
	
	
}
