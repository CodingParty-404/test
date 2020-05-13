package org.zerock.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
	// db tbl_reply 湲곗�?
	
	private Long rno;
	private Long bno;
	private String reply, replyer;
	
	private LocalDateTime replyDate, updateDate;

}
