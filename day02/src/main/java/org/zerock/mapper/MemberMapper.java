package org.zerock.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.vo.MemberVO;

public interface MemberMapper {
	
	@Insert("insert into t_member(mid, mpw, mname) values (#{mid}, #{mpw}, #{mname})")
	int addMember(MemberVO memberVO);
	
	
	// ��ȸ�Ҷ� pk�� �־�� ��
	// ���� �ϳ��϶� ���ε� �ȴ�
	@Select("select * from t_member where mid = #{mid}")
	MemberVO getMember(String mid);
	// mybatis�� getter, setter��
	// EL�� �׷���
	
	
	// dml�� �׻� ���̺� ������ ��
	// insert , update , delete
	// ��� ������ �޾Ҵ��� int�� ��ȯ��
	// ddl�� void
	// select�� ������ vo Ÿ��
	@Delete("delete from t_member where mid = #{mid}")
	int deleteMember(String mid);
	
	@Update("update t_member set mpw = #{mpw}, mname = #{mname} where mid = #{mid}")
	int updateMember(MemberVO vo);
	// �������ϱ� MemberVO�� ����

}
