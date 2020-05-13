package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.zerock.vo.ReplyVO;

public interface ReplyMapper {
	@Insert("insert into tbl_reply (bno,reply,replyer) values (#{bno},#{reply},#{replyer})")
	int insert(ReplyVO replyVO);
	
	@Select("select * from tbl_reply where bno = #{bno}")
	List<ReplyVO> getList(Long bno);
}
