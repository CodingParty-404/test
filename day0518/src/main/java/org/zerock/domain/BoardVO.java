package org.zerock.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardVO {

	
	private long bno;
	private String title, content, writer;
	
	private LocalDateTime regdate;
	private LocalDateTime moddate;
	
}
