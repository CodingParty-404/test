package org.zerock.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {
	
	// 페이징 처리에 이용하는 PageMaker
	// PageMaker에 있는 정보는 board controller에 있는 /list가 model로 감싸서 list.jsp에 쏘고
	// list.jsp에서는 PageMaker를 EL로 받아서 페이징처리할 때 쓴다
	
	// pageMaker가
	// pageDTO 정보도 갖고 있게 한다
	private PageDTO pageDTO;
	
	// 데이터베이스에 있는 총 데이터 수
	private int total;
	
	// 시작 페이지, 끝 페이지
	private int start, end;
	
	// 이전, 다음은 boolean
	private boolean prev, next; // << , >> 버튼이다
	
	// 생성자가 변수들 초기화
	public PageMaker(PageDTO pageDTO, int total) {
		this.pageDTO = pageDTO;
		this.total = total;
		
		// 1. 임시로 마지막 번호를 구한 후에 '진짜 시작번호'를 구한 후에 (시작번호=진짜시작번호)
		// 2. '진짜 마지막 번호'를 구한다
		
		// 1. '시작번호'를 구하기 위한 임시 마지막 번호 구하기
		int tempEnd = (int)(Math.ceil(pageDTO.getPage() / 10.0))*10;
		// 임시마지막번호 - 9는 '진짜 시작번호'
		this.start = tempEnd - 9;
		// 2. 이제 '진짜 마지막 번호' 구하기
		// total은 db에 있는 총량
		// 총량 나누기 페이지어마운트 = 마지막 페이지
		int realEnd = (int)(Math.ceil(total / (double)pageDTO.getAmount()));
		// end를 real을 쓸지 temp를 쓸지 결정
		// realEnd가 tempEnd보다 더 작다면, 진짜 끝페이지는 realEnd
		this.end = realEnd < tempEnd ? realEnd : tempEnd;
		
		// 이전버튼
		// 시작페이지가 1이 아니라면 이전버튼은 늘 있다
		this.prev = start != 1;
		
		// 다음버튼
		// realEnd가 tempEnd보다 크다면 다음버튼은 늘 있다
		this.next = realEnd > tempEnd;
	}		
		

}
