package org.zerock.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardVO {

	//p.138
	
	private long bno;
	private String title;
	private String content;
	private String writer;
	
	private LocalDateTime regdate;
	private LocalDateTime moddate;
	
	
}
