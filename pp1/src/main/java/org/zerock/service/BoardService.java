package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.dto.PageDTO;

public interface BoardService {
	
	// �씠 �씤�꽣�럹�씠�뒪�뒗 鍮꾩쫰�땲�뒪 怨꾩링
	// �씠 �씤�꽣�럹�씠�뒪�뒗 怨좉컼�쓽 �슜�뼱濡� �옉�꽦�븳�떎 (鍮꾩쫰�땲�뒪 怨꾩링�� 洹몃젃�떎)
	
	int register(BoardVO vo) throws RuntimeException;
	
	int modify(BoardVO vo) throws RuntimeException;
	
	int remove(Long bno) throws RuntimeException;
	
	BoardVO get(Long bno) throws RuntimeException;
	
	List<BoardVO> getList(PageDTO pageDTO) throws RuntimeException;
	
	int getTotal(PageDTO pageDTO) throws RuntimeException;
  
}
