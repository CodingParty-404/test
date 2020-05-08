package org.zerock.domain;

import org.springframework.stereotype.Repository;


public class PagingVO {
	
	private int skip, amount;

	public void setSkip(int skip) {
		this.skip = (skip-1)*10;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	

}
