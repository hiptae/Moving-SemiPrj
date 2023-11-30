package kr.co.mpago.mapper;

import java.util.List;

import kr.co.mpago.domain.Member;

public interface AdminMapper {
	// 회원등록
	int insert(Member member);
	// 목록조회
	List<Member> getList();
	// 단일조회
	Member read(String userid);
	// 회원삭제
	int delete(String userid);
	// 회원정보수정
	int update(Member member);
}
