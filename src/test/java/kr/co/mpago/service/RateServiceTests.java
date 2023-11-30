 package kr.co.mpago.service;
 
 import org.junit.Test;
 
 import kr.co.mpago.domain.Rate;
 import kr.co.mpago.mapper.RateMapper;
 import kr.co.mpago.util.DBUtils;
 
 public class RateServiceTests {
 	RateService rateService = RateService.getRateService();
 	private RateMapper rateMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(RateMapper.class);
 	
 	// 평점(점수, 댓글)등록 Test(성공)
 	@Test
 	public void testRegister() {
 //		Rate rate = Rate.builder().rate(3.0).userno(162L).mno(1L).tcomment("영화 감상평").build();
 //			rateMapper.insert(rate);
 	}
 	
 	// 영화별(mno) 평점 조회 Test(성공)
// 	@Test
// 	public void testGetMovie() {
// 		rateService.getOne(20L);
// 	}
 	
 	// 유저별(userno) 평점 조회 Test(성공)
// 	@Test
// 	public void testGetUser() {
// 		rateService.getUser(160L);
// 	}
 	
 	// 목록 조회 Test (전체 리뷰 조회) (성공)

//	@Test
//	public void testGetList() {
//		rateService.getList();
//	}
 	
 	// 수정 Test 
 	@Test 
 	public void testModify() {
 //		Rate rate = Rate.builder().tno(11L).userno(162L).mno(85L).rate(5.0).tcomment("승현테스트").build();
 //		rateService.modify(rate);		
 	}
 	
 	// 삭제 Test (성공)
 	@Test
 	public void testDelete() {
 		rateService.delete(12L);
 	}
 }