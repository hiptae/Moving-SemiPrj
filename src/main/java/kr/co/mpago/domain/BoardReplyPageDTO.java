package kr.co.mpago.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardReplyPageDTO {
	private int replyCnt;
	private List<BoardReply> list;
}
