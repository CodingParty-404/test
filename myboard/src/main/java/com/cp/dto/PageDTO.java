package com.cp.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int page;
	private int amount;

	public PageDTO(Integer page, Integer amount) {
		super();
		this.page = page == null || page < 0 ? 1 : page;
		this.amount = page == null || amount < 10 ? 10 : amount;
	}

	public int getSkip() {
		return (page - 1) * amount;
	}

}
