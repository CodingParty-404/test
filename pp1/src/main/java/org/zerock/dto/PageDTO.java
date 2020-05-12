package org.zerock.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	// 페이징 처리에 사용하는 클래스 PageDTO
	
	private int page;
	private int amount;
	
	
	
	// 생성자로 제한을 건다
	// 반드시 두개의 파라미터를 받아야 하는데 안받을때도 있지
	// 최초에 한번만 셋팅만 할 수 있다
	// 이런 게 불변 객체
	public PageDTO(Integer page, Integer amount) {
		
		this.page = page == null || page <= 0 ? 1 : page;
		this.amount = amount == null || amount <= 10 ? 10 : amount;
	}
	
	
	// getter
	// mybatis는 set, get으로 움직이는 리플렉션
	// mybatis 의 limit 문법은 limit skip, size
	public int getSkip() {
		
		// list에서 쓸거야
		return (page - 1) * amount;
	}
	
	
	

}
