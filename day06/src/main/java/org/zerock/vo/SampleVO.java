package org.zerock.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {
	// NoArgsConstructor? JSON?  ? ?Έκ±°μΌ
	// p.361
	
	private Integer mno; // ??λ²νΈ
	private String firstName;
	private String lastName;

}
