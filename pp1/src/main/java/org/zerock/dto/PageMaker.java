package org.zerock.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {

	private PageDTO pageDTO;
	private int total; // 데이터베이스에 있는 총 데이터 개수
	// 시작페이지는 임시 연산에서 결정됨
	private int start, end;
	// 이전, 다음은 boolean
	private boolean prev, next; // < , > 버튼이다


	// 생성자에서 필요한 변수들 셋팅
	public PageMaker(PageDTO pageDTO, int total) {
		this.pageDTO = pageDTO;
		this.total = total;


		// 임시로 마지막 번호를 구한다
		// amount 디폴트는 10
		int tempEnd = (int)(Math.ceil(pageDTO.getPage() / 10.0)) * 10;
		// 시작페이지는 임시 연산에서 결정됨
		this.start = tempEnd - 9;
		
		// 이제 진짜 end 구하기
		int realEnd = (int)(Math.ceil(total/(double)pageDTO.getAmount()));
		
		// 이제 tempEnd를 쓸지 realEnd를 쓸지 결정
		if(realEnd < tempEnd) {
			this.end = realEnd;
		} else {
			this.end = tempEnd;
		}
		
		// 시작페이지가 1이 아닐때에는 이전 버튼이 있어야 한다
		// 이전 버튼, 다음 버튼은 boolean 처리한다
		this.prev = start != 1; // <- 버튼이 있는 경우
		// 실제End가 임시End보다 크면 무조건 다음이 있는거다
		this.next = realEnd > tempEnd; // -> 버튼이 있는 경우


	}

}
