package com.cp.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMaker {

	private PageDTO pageDTO;
	private int total;
	private int start;
	private int end;
	private boolean prev, next;

	public PageMaker(PageDTO pageDTO, int total) {
		this.pageDTO = pageDTO;
		this.total = total;

		int tempEnd = (int) (Math.ceil(pageDTO.getPage() / 10.0)) * 10;
		// 시작페이지
		this.start = tempEnd - 9;
		// realEnd total = 123 -> 13
		int realEnd = (int) Math.ceil(total / pageDTO.getAmount());

		// end값 구하기
		if (realEnd < tempEnd) {
			this.end = realEnd;
		} else {
			this.end = tempEnd;
		}

		// 이전, 다음 링크 존재 유무
		this.prev = (start != 1) ? true : false;
		this.next = (realEnd > tempEnd) ? true : false;
	}

}
