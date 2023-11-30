package kr.co.mpago.service;

import java.util.List;

import kr.co.mpago.domain.Board;
import kr.co.mpago.domain.Criteria;
import kr.co.mpago.mapper.BoardMapper;
import kr.co.mpago.util.DBUtils;

public class BoardService {
	private static final BoardService boardService = new BoardService();
	private BoardMapper boardMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(BoardMapper.class);
	public static BoardService getInstance() {
	        return boardService;
	    }
	
	// 목록 조회
	public List<Board> getList(Criteria criteria) {
		return boardMapper.getListWithPaging(criteria);
	}
	
	// 단일 조회
	public Board get(Long bno) {
		return boardMapper.get(bno);
	}
	
	// 카테고리 목록 조회
	public List<Board> categoryList(Long bcate) {
		return boardMapper.categoryList(bcate);
	}
	
	// 게시글 등록
	public void insert(Board board) {
		boardMapper.insert(board);
	}	

	// 게시글 수정
	public boolean modify(Board board) {
		return boardMapper.modify(board);
	}
	
	// 게시글 삭제
	public boolean delete(Long bno) {
		return boardMapper.delete(bno);
	}
	
	// 게시글 총 갯수
	public int getTotal(Criteria criteria) {
		return boardMapper.getTotal(criteria);
	}

	
	//
}
