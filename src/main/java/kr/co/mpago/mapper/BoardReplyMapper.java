package kr.co.mpago.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.mpago.domain.BoardReply;
import kr.co.mpago.domain.Criteria;

public interface BoardReplyMapper {
	// 댓글목록 조회
	List<BoardReply> getListWithPaging(@Param("cri") Criteria criteria, @Param("bno") Long bno);
	
	// 댓글 단일 조회
	BoardReply get(Long rno);
	
	// 댓글 갯수 조회
	int getTotal(@Param("cri") Criteria criteria, @Param("bno") Long bno);	
	
	// 댓글 작성
	int insert(BoardReply reply);

	// 댓글 수정
	int modify(BoardReply reply);
	
	// 댓글 삭제
	int remove(Long rno);
}
