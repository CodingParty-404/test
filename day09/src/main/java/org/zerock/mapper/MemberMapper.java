package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;

public interface MemberMapper {
	
	@Insert("insert into tbl_member (userid, userpw, username) values( #{userid},#{userpw},#{userName} )")
	public int addMember(MemberVO member);
	
	@Insert("insert into tbl_member_auth(userid, auth) values(#{userid},#{auth} )" )
	public int addAuth(@Param("userid")String userid,  @Param("auth")String Auth);
	
	@Select("select * from tbl_member where userid = #{userid}")
	public MemberVO read(String userid);
	@Select("select * from tbl_member_auth where userid = #{userid}")
	public List<AuthVO> readAuth(String userid);
	
	
}
