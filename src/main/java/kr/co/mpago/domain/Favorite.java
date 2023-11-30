package kr.co.mpago.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Favorite {
	private Long fno;	// 찜
	private Long userno;	// 유저번호
	private Long mno;	// 영화번호
	
}
