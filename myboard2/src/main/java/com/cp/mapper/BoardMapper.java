package com.cp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cp.domain.BoardVO;
import com.cp.dto.PageDTO;

@Mapper
public interface BoardMapper{

	//10���� ����Ʈ���
	public List<BoardVO> getList(PageDTO pageDTO);
	
	public BoardVO select(long bno);
	//insert
	public int insert(BoardVO vo);
	//delete
	public int delete(long bno);
	//update
	public int update(BoardVO vo);
	
	//total
	public int getTotal();
	
	
	
	
}
