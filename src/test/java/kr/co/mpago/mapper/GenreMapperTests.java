package kr.co.mpago.mapper;


import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import kr.co.mpago.domain.Genre;
import kr.co.mpago.util.DBUtils;
import lombok.extern.log4j.Log4j;


@Log4j
public class GenreMapperTests {
	
	private SqlSessionFactory factory = DBUtils.sqlSessionFactory();
	private GenreMapper genreMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(GenreMapper.class);	

	// Mapper 연결 Test (성공)
	@Test
	public void testMapper() {
		log.info(genreMapper);
		log.info(factory.getConfiguration());
	}
	
	// insert (성공)
	@Test
	public void testInsert() {
		Genre genre = Genre.builder().genre("testgenre10").build();
		
		log.info(genre);
		genreMapper.insertGenre(genre);
		log.info(genre);
	}

	// 단일조회 test (성공)
	@Test
	public void testSelect() {
		genreMapper.selectGenre(4L);
	}
	
	// 단일삭제 test (성공)
	@Test
	public void testDelete() {
		testSelect();
		genreMapper.deleteGenre(5L);
		testSelect();
	}
	
	// 단일변경 test (성공)	
	@Test
	public void testUpdate() {
		Genre genre = genreMapper.selectGenre(4L);
		
		genre.setGenre("testgenre5");
		genreMapper.updateGenre(genre);
		log.info(genre);
		
		genre = genreMapper.selectGenre(4L);
		log.info(genre);
	}
	
	// 전체조회 (성공)
	@Test
	public void testselectList() {
		genreMapper.selectGenreList().forEach(genre -> log.info(genre));
	}
	
}
