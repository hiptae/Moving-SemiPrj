package kr.co.mpago.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Msg {
	private Long msgno;
	private String title;
	private String content;
	private Date regdate;
	
	// fk 회원 닉네임
	private String fromnick;
	private String tonick;
}
