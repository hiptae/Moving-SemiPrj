package kr.co.mpago.service;

import org.junit.Test;

import kr.co.mpago.domain.Favorite;
import kr.co.mpago.mapper.FavoriteMapper;
import kr.co.mpago.util.DBUtils;
import lombok.extern.log4j.Log4j;

@Log4j
public class FavoriteServiceTests {
	FavoriteService favoriteService = FavoriteService.getFavoriteService(); // 싱글톤
	private FavoriteMapper favoriteMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(FavoriteMapper.class);
	
	// 등록 Test (성공)
	@Test
	public void testRegister() { 
		Favorite favorite = Favorite.builder().userno(12L).mno(12L).build();
		favoriteService.register(favorite);
//		favoriteMapper.get(21L); // fno 21의 정보를 가져온다.
	}
	
	// 단일 조회 Test
	@Test
	public void testget() {
		favoriteService.get(12L);
	}
	
	
	// 내가 찜한 목록 조회 Test (성공)
	@Test
	public void testList() {	
		favoriteService.getList(12L);
	}
	
	// 삭제 Test (성공)
	@Test
	public void testdelete() {
		favoriteService.delete(11L);
	}
	
	
	
}
