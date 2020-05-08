package com.cp.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.ToString;

@Service
@Setter
@ToString
public class Restaurant {
	
	@Setter(onMethod_ = {@Autowired, @Qualifier("italian")})
	Chef chef;

}
