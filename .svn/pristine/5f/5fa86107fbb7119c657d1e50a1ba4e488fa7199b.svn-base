package kr.co.mpago.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import kr.co.mpago.domain.Board;
import kr.co.mpago.domain.Cast;
import kr.co.mpago.domain.Favorite;
import kr.co.mpago.domain.Rate;
import kr.co.mpago.util.DBUtils;
import lombok.extern.log4j.Log4j;

@Log4j
public class FavoriteMapperTests {
	private SqlSessionFactory factory = DBUtils.sqlSessionFactory();
	private FavoriteMapper favoritemapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(FavoriteMapper.class);

	// Mapper 연결 Test (성공)
	@Test
	public void testMapper() {
		System.out.println(favoritemapper);
		log.info(favoritemapper);
//		System.out.println(factory.getConfiguration());
		log.info(factory.getConfiguration());
	}

	// 등록 Test (성공)
	@Test
	public void testInsert() {
		Favorite favorite = Favorite.builder().userno(18L).mno(7L).build();
		favoritemapper.insert(favorite);
		log.info(favorite);
	}
	
	// 단일 조회 Test 
	@Test
	public void testGetFavorite() {
		favoritemapper.get(10L);
	}
	
	// 내가 쓴 찜한 목록 조회 Test (성공)
	@Test
	public void testGetList() {
		favoritemapper.getList(18L);

//		List<Favorite> getFavorites = favoritemapper.getFavorites();
//		log.info(getFavorites);
	}
	
	
	// 삭제 Test (성공)
	@Test
	public void testDelete() {
		favoritemapper.delete(10L);
	}
	
	// 삭제 Test ()
//		@Test
//		public void testDelete() {
//			favoritemapper.delete(3L, 8L);
//		}
}
