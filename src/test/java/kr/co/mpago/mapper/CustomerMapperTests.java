package kr.co.mpago.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import kr.co.mpago.domain.Notice;
import kr.co.mpago.util.DBUtils;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomerMapperTests {
	private SqlSessionFactory factory = DBUtils.sqlSessionFactory();
	private CustomerMapper mapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(CustomerMapper.class);
	
	/*
	 * //DB연결 테스트 (성공)
	 * 
	 * @Test public void testMapper() { System.out.println(mapper);
	 * System.out.println(factory.getConfiguration()); }
	 * 
	 * // 목록 조회 테스트 (성공)
	 * 
	 * @Test public void testGetList() { List<Notice> list = mapper.getList();
	 * list.forEach(notice -> log.info(notice.toString())); }
	 * 
	 * // 단일 조회 테스트 (성공)
	 * 
	 * @Test public void testGet() { Notice notice = mapper.get(1L);
	 * log.info(notice); }
	 * 
	 * // 등록 테스트 (성공)
	 * 
	 * @Test public void testInsert() { Notice notice = Notice.builder()
	 * .nickname("관리자") .title("제목") .content("내용") .isAdmin(true) .build(); int
	 * count = mapper.insert(notice); System.out.println(count); }
	 * 
	 * // 수정 테스트 (성공)
	 * 
	 * @Test public void testModify() { Notice notice =
	 * Notice.builder().bno(1L).title("수정한제목").content("수정한내용").build();
	 * 
	 * log.info(mapper.modify(notice) == true ? "성공" : "실패"); }
	 */
	
	// 삭제 테스트 (성공)
	@Test
	public void testDelete() {
	    long result = mapper.delete(1L);
	    log.info(result > 0 ? "삭제함" : "삭제할 게 없음");
	}
}