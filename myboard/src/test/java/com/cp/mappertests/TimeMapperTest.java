package com.cp.mappertests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cp.commontest.CommonTest;
import com.cp.mapper.TimeMapper;

import lombok.extern.log4j.Log4j;


@Log4j
public class TimeMapperTest extends CommonTest {

	@Autowired
	TimeMapper ti;
	
	@Test
	public void timeTest()
	{
		log.info(ti.getTime());
	}
}
