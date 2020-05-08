package org.zerock.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	
	private String mid, mpw, mname;
	
	private LocalDateTime regdate;

}
