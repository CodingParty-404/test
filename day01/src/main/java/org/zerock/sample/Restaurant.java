package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Service
public class Restaurant implements Chef { // 1. 객체 만들어
	
	// 당신이 원하는 객체... 라이프사이클이 긴 애들? 주로 로직 위주의 아이들이 라이프사이클이 길다
	// 스프링의 빈은 라이프사이클이 긴 애들로 잡는다
	
	// 2. 필요한 객체 주입해

	// private KoreanChef chef;
	// 스프링 의존성 주입은 인터페이스와 한 세트
	@Setter(onMethod_ = {@Autowired, @Qualifier("korean")})
	private Chef chef;
	
	// 3. 그 객체를 설정해
	// setter or 생성자
	
	// 예전엔 의존적인 관계일때 직접 new를 했지만 이젠 그렇게 안해. root-context.xml에서 property로 설정한다
		
}
