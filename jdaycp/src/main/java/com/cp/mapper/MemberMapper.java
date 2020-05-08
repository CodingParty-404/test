package com.cp.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cp.vo.MemberVO;

public interface MemberMapper {

	@Insert("insert into t_member (mid, mpw, mname) values (#{mid}, #{mpw}, #{mname})")
	int addMember(MemberVO member);
	
	@Select("select * from t_member where mid = #{mid}")
	MemberVO getMember(String mid);
	
	@Delete("delete from t_member where mid = #{mid}")
	int deleteMember(String mid);
	
	@Update("update t_member set mpw = #{mpw} , mname = #{mname} where mid = #{mid}")
	int updateMember(MemberVO member);
	
	
	int addMember2(MemberVO member);
	MemberVO getMember2(String mid);
	int deleteMember2(String mid);
	int updateMember2(MemberVO member);
	
}
