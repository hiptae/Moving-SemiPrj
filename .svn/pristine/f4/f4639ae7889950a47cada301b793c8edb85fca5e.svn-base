package kr.co.mpago.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import kr.co.mpago.domain.Board;
import kr.co.mpago.domain.Criteria;
import kr.co.mpago.util.DBUtils;
import lombok.extern.log4j.Log4j;

@Log4j
public class BoardMapperTests {
	private SqlSessionFactory factory = DBUtils.sqlSessionFactory();
	private BoardMapper mapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(BoardMapper.class);
	
	// 연결 테스트 (성공)
	@Test
	public void testMapper() {
		System.out.println(mapper);
		System.out.println(factory.getConfiguration());
	}
	
	// 목록 조회 테스트 (성공)
	@Test
	public void testGetList() {
		List<Board> boardList = mapper.getList();
		boardList.forEach(log::info);
	}
	
	// 단일 조회 테스트 (성공)
	@Test
	public void testGet() {
		Board board = mapper.get(53L);
		log.info(board);
	}
	
	// 카테고리 별 목록 조회 테스트 (성공)
	@Test
	public void testCategoryList() {
		List<Board> cateList = mapper.categoryList(1L);
		cateList.forEach(log::info);
	}
	
	// 등록 테스트 (성공)
	@Test
	public void testInsert() {
		Board board = Board.builder().bcate(1L).userno(160L).title("테스트 중").content("테스트 중").build();
		System.out.println(board);
		int count = mapper.insert(board);
		System.out.println(count);
	}
	
	// 수정 테스트 (성공)
	@Test
	public void testModify() {
		Board board = Board.builder().bno(53L).title("수정한제목").content("수정한내용").build();
		
		log.info(mapper.modify(board) == true ? "성공" : "실패");
	}
	
	// 삭제 테스트 (성공)
	@Test
	public void testDelete() {
		log.info(mapper.delete(60L) == true ? "삭제함" : "삭제할 게 없음");
	}
	
}