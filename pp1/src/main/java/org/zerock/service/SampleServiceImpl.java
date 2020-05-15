package org.zerock.service;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public void doA() {
		
		System.out.println("doA()..................................................................");
		System.out.println("doA()..................................................................");
		System.out.println("doA()..................................................................");
		System.out.println("doA()..................................................................");
	}

}
