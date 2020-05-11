package com.cp.domain;

import java.time.LocalDateTime;

import lombok.Data;



@Data
public class BoardVO {

	private Long bno;
	private String title,content,writer;
	private LocalDateTime regdate, moddate;
}
