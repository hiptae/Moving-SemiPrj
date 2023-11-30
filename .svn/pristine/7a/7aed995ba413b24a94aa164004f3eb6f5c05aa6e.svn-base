package kr.co.mpago.mapper;


import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import kr.co.mpago.domain.MovieCast;
import kr.co.mpago.util.DBUtils;
import lombok.extern.log4j.Log4j;


@Log4j
public class MovieCastMapperTests {
	
	private SqlSessionFactory factory = DBUtils.sqlSessionFactory();
	private MovieCastMapper movieCastMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(MovieCastMapper.class);	
	
	// Mapper 연결 Test (성공)
	@Test
	public void testMapper() {
		log.info(movieCastMapper);
		log.info(factory.getConfiguration());
	}
	
	// Mapping insert (성공)
	@Test
	public void testInsert() {
		MovieCast movieCast = MovieCast.builder()
				.mno(1L).castno(6L).casting("test배역명").castType("test조연")
				.build();
		
		log.info(movieCast);
		movieCastMapper.insertMovieCastMapping(movieCast);
		log.info(movieCast);
	}
	
	// Mapping삭제 test (성공)
	@Test
	public void testDelete() {
		movieCastMapper.deleteMovieCastMapping(22L);
	}
	
	// 단일변경 없음
	
	
	// 특정 영화의 배우 전체 조회	
	@Test
	public void testSelectCastForMovieList() {
		movieCastMapper.selectCastListByMovie(1L).forEach(log::info);
	}
	
	// mno번 영화의 <List> 조회
	@Test
	public void testSelectListByMovie() {
		movieCastMapper.selectListByMovie(1L).forEach(log::info);
	}
	
	// 특정 배우의 영화 전체 조회
	@Test
	public void testSelectMovieForCastList() {
		movieCastMapper.selectMovieListByCast(2L).forEach(movieCast -> log.info(movieCast));
	}
	
	// castno번 배우의 <List> 조회
	@Test
	public void testSelectListByCast() {
		movieCastMapper.selectListByCast(2L).forEach(log::info);
	}
	
}
