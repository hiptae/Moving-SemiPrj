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
public class Notice {
	private Long bno;
	private String nickname;
	private String title;
	private String content;
	private Date regDate;
	private boolean isAdmin;
	
	public boolean getIsAdmin() {
        return this.isAdmin;
	}
}
