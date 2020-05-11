package com.cp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cp.domain.BoardVO;

@Mapper
public interface BoardMapper{

	//10개의 리스트출력
	public List<BoardVO> getList();
	
	public BoardVO select(long bno);
	//insert
	public int insert(BoardVO vo);
	//delete
	public int delete(long bno);
	//update
	public int update(BoardVO vo);
	
	
	
}
