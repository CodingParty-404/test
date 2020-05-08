package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PagingVO;

public interface BoardMapper {
	
	// 리스트 처리도 가능
	@Select("select * from tbl_board where bno > 0 order by bno desc limit #{skip}, #{amount}")
	public List<BoardVO> getList(
			@Param("skip") int skip,
			@Param("amount") int amount);
	
	
	// VO로 처리
	@Select("select * from tbl_board where bno > 0 order by bno desc limit #{skip}, #{amount}")
	public List<BoardVO> getList2(PagingVO vo);

}
