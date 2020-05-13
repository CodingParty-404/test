package org.zerock.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {
	// NoArgsConstructor는 JSON할 때 쓸거야
	// p.361
	
	private Integer mno; // 회원번호
	private String firstName;
	private String lastName;

}
