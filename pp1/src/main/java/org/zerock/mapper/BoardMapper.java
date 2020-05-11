package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	@Select("select * from tbl_board where bno > 0 limit 10")
	public List<BoardVO> selectBoard();
	
	@Select("select * from tbl_board where bno = ${bno}")
	public BoardVO selectOne(String bno);
	
	@Insert("insert into tbl_board (title, content, writer) values (#{title}, #{content}, #{writer})")
	public int insertBoard(BoardVO vo);
	
	@Delete("delete from tbl_board where bno = #{bno}")
	public int deleteBoard(String bno);
	
//	@Update("update tbl_board set title=#{title}, content=#{content}, moddate = now() where bno = #{bno}")
//	public void updateBoard(BoardVO vo);
	
//	date_format(now(), '%y-%m-%d-%t'), '%y-%m-%d-%t'); 
	
	@Update("update tbl_board set title=#{title}, content=#{content}, moddate = now() where bno = #{bno}")
	public void updateBoard(BoardVO vo);

}
