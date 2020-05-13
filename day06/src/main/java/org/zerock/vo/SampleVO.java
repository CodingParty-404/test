package org.zerock.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {
	// NoArgsConstructor?�� JSON?�� ?�� ?��거야
	// p.361
	
	private Integer mno; // ?��?��번호
	private String firstName;
	private String lastName;

}
