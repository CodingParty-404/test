package org.zerock.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	// �럹�씠吏� 泥섎━�뿉 �궗�슜�븯�뒗 �겢�옒�뒪 PageDTO

	private int page;
	private int amount;
	
	@Setter
	private String type;
	@Setter
	private String keyword;

	// �깮�꽦�옄濡� �젣�븳�쓣 嫄대떎
	// 諛섎뱶�떆 �몢媛쒖쓽 �뙆�씪誘명꽣瑜� 諛쏆븘�빞 �븯�뒗�뜲 �븞諛쏆쓣�븣�룄 �엳吏�
	// 理쒖큹�뿉 �븳踰덈쭔 �뀑�똿留� �븷 �닔 �엳�떎
	// �씠�윴 寃� 遺덈� 媛앹껜
	public PageDTO(Integer page, Integer amount) {

		this.page = page == null || page <= 0 ? 1 : page;
		this.amount = amount == null || amount <= 10 ? 10 : amount;
	}

	// getter
	// mybatis�뒗 set, get�쑝濡� ��吏곸씠�뒗 由ы뵆�젆�뀡
	// mybatis �쓽 limit 臾몃쾿�� limit skip, size
	public int getSkip() {

		// list�뿉�꽌 �벝嫄곗빞
		return (page - 1) * amount;
	}

	public String[] getTypeArr() {
		return (type == null) ? new String[] {} : type.split("") ;
	}

}
