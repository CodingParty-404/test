package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	// sql �̷��� ����
	@Select("select now()")
	String getTime();
	
	// sql�� �ʹ� �� �� �̷��� �Ѵ�
	String getTime2();

}
