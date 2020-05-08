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
public class Restaurant implements Chef { // 1. ��ü �����
	
	// ����� ���ϴ� ��ü... ����������Ŭ�� �� �ֵ�? �ַ� ���� ������ ���̵��� ����������Ŭ�� ���
	// �������� ���� ����������Ŭ�� �� �ֵ�� ��´�
	
	// 2. �ʿ��� ��ü ������

	// private KoreanChef chef;
	// ������ ������ ������ �������̽��� �� ��Ʈ
	@Setter(onMethod_ = {@Autowired, @Qualifier("korean")})
	private Chef chef;
	
	// 3. �� ��ü�� ������
	// setter or ������
	
	// ������ �������� �����϶� ���� new�� ������ ���� �׷��� ����. root-context.xml���� property�� �����Ѵ�
		
}
