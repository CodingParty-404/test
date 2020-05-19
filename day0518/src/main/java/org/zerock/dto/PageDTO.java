package org.zerock.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	// 페이징 처리에 이용하는 pageDTO
	
	private int page;
	private int amount;
	private String type;
	private String keyword;
	
	// 생성자로 제약 조건 걸기
	public PageDTO(Integer page, Integer amount, String type, String keyword) {
		
		// 검색창에서 파라미터가 null이면 default값으로 채우기
		// 이래야 sql 오류 피할 수 있음
		
		this.page = page == null || page <= 0 ? 1 : page; // page 디폴트는 1페이지
		this.amount = amount == null ||	amount <= 10 ? 10 : amount; // amount 디폴트는 10
		this.type = type == null ? "t" : type; 
		this.keyword = keyword == null? "" : keyword;
		
	}

	// boardController의 list가 service의 getList를 호출하고
	// service의 getList가 boardMapper의 getPagingList를 호출하는데
	// boardMapper의 getPagingList SQL 구문을 살펴보면
	// collection="typeArr"
	// #{skip}
	// 이 두개가 있다
	// 파라미터로 넘겨지는 PageDTO에 저 두개의 getter가 있어야 한다
	
	// collection="typeArr"의 getter
	public String[] getTypeArr() {
		return type == null? new String[] {} : type.split("");
	}
	
	
	// #{skip}의 getter
	public int getSkip() {
		
		// 앞단에 몇페이지를 건너뛰어야 하는지 계산
		// (현재 페이지 - 1) * amount만큼 건너뛰고 보여주면 된다
		return (page - 1) * amount;
	}
	
}
