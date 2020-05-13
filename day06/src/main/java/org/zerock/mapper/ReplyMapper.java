package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.zerock.vo.ReplyVO;

public interface ReplyMapper {
	
	@Insert("insert into tbl_reply (bno, reply, replyer) values (#{bno}, #{reply}, #{replyer})")
	int insert(ReplyVO reply);
	
	// 게시글 번호 주면 그 게시글에 붙은 모든 댓글들을 좌라락 보여줘
	@Select("select * from tbl_reply where bno = #{bno}")
	List<ReplyVO> list(Long bno);
	
	
	

}
