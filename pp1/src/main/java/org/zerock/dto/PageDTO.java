package org.zerock.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	// 페이징 처리에 사용하는 클래스 PageDTO
	
	private int page;
	private int amount;
	
	// 0513 추가
	private String type; // tcw
	private String keyword;
	
	
	// 생성자로 제한을 건다
	// 반드시 두개의 파라미터를 받아야 하는데 안받을때도 있지
	// 최초에 한번만 셋팅만 할 수 있다
	// 이런 게 불변 객체
	public PageDTO(Integer page, Integer amount) {
		
		this.page = page == null || page <= 0 ? 1 : page;
		this.amount = amount == null || amount <= 10 ? 10 : amount;
		this.type = type == null ? "" : type;
		this.keyword = keyword == null ? "" : keyword;
	}
	
	
	// getter
	// mybatis는 set, get으로 움직이는 리플렉션
	// mybatis 의 limit 문법은 limit skip, size
	public int getSkip() {
		
		// list에서 쓸거야
		return (page - 1) * amount;
	}
	
	
	// 0513 추가
	// select에서 선택되면
	// 루프를 돌려야 하니까 배열로 만든다
	public String[] getTypeArr() {
		
		// 검색조건이 없다면 빈문자배열을 반환한다
		// 검색조건이 있다면 split으로 끊는다
		// 빈 배열 만들때 new 써서 만들어야 한다
		// 근데 어노테이션에서 url 경로를 배열로 만들땐 예외가 있다. 이땐 new 안써도 된다
		return type == null? new String[] {} : type.split("");
	}
	

}
