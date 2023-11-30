package kr.co.mpago.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieGenre {
	private Long mgno;	// 장르 영화 Mapping Tbl 번호
	private Long gno;	// 장르 번호
	private Long mno;	// 영화 번호
}
