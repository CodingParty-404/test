package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	// sql 이렇게 날려
	@Select("select now()")
	String getTime();
	
	// sql이 너무 길 땐 이렇게 한다
	String getTime2();

}
