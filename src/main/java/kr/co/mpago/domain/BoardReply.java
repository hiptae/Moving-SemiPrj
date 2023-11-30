package kr.co.mpago.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Alias("reply")
@NoArgsConstructor
@AllArgsConstructor
public class BoardReply {
	private Long rno;
	private Long bno;
	private Long userno;
	private Date regDate;
	private String comment;
	private	 String nickname;
}
