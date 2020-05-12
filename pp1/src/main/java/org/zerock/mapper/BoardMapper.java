package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;

public interface BoardMapper {
	
	// 파라미터로 페이징 처리
	@Select("select * from tbl_board where bno > 0 order by bno desc limit #{skip}, #{amount}")
	public List<BoardVO> getPagingList(PageDTO pageDTO);
	
	
	// 총페이지를 알아보는 SQL 추가
	@Select("select count(bno) from tbl_board")
	int getTotal();
	
	
	
	
	@Select("select * from tbl_board where bno > 0 order by bno desc limit 10")
	public List<BoardVO> selectBoard();
	
	@Select("select * from tbl_board where bno = ${bno}")
	public BoardVO selectOne(Long bno);
	
	@Insert("insert into tbl_board (title, content, writer) values (#{title}, #{content}, #{writer})")
	public int insertBoard(BoardVO vo);
	
	@Delete("delete from tbl_board where bno = #{bno}")
	public int deleteBoard(Long bno);
	
//	date_format(now(), '%y-%m-%d-%t'), '%y-%m-%d-%t'); 
	
	@Update("update tbl_board set title=#{title}, content=#{content}, moddate = now() where bno = #{bno}")
	public int updateBoard(BoardVO vo);
	


}
