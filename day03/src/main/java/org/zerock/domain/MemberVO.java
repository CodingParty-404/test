package org.zerock.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

@Data
public class MemberVO {
	
	private String mid, mpw, mname;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate regdate;

}
