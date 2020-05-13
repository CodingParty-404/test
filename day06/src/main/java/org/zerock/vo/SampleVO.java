package org.zerock.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {
	// NoArgsConstructor?Š” JSON?•  ?•Œ ?“¸ê±°ì•¼
	// p.361
	
	private Integer mno; // ?šŒ?›ë²ˆí˜¸
	private String firstName;
	private String lastName;

}
