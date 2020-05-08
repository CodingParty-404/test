package org.zerock.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.vo.MemberVO;

public interface MemberMapper {
	
	@Insert("insert into t_member(mid, mpw, mname) values (#{mid}, #{mpw}, #{mname})")
	int addMember(MemberVO memberVO);
	
	
	// 조회할땐 pk가 있어야 해
	// 값이 하나일땐 바인딩 된다
	@Select("select * from t_member where mid = #{mid}")
	MemberVO getMember(String mid);
	// mybatis는 getter, setter다
	// EL도 그랬지
	
	
	// dml는 항상 테이블에 영향을 줌
	// insert , update , delete
	// 몇개가 영향을 받았는지 int로 반환함
	// ddl은 void
	// select는 무조건 vo 타입
	@Delete("delete from t_member where mid = #{mid}")
	int deleteMember(String mid);
	
	@Update("update t_member set mpw = #{mpw}, mname = #{mname} where mid = #{mid}")
	int updateMember(MemberVO vo);
	// 여러개니까 MemberVO로 넣음

}
