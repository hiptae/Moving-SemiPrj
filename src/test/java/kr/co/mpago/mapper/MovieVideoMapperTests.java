package kr.co.mpago.mapper;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import kr.co.mpago.domain.MovieImage;
import kr.co.mpago.domain.MovieVideo;
import kr.co.mpago.util.DBUtils;
import lombok.extern.log4j.Log4j;

/**
 * 테스트 성공
 * @author gilho
 *
 */
@Log4j
public class MovieVideoMapperTests {
	
	private SqlSessionFactory factory = DBUtils.sqlSessionFactory();
	private MovieVideoMapper movieVideoMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(MovieVideoMapper.class);

	@Test
	public void testinsertMovieVideo() {
		MovieVideo movieVideo = MovieVideo.builder().mno(1l).videoKey("d").type("typetest1")
				.build();
		movieVideoMapper.insertMovieVideo(movieVideo); // 영화 비디오 insert
	//	movieVideoMapper.selectMovieVideo("ABCD");
	}
	
	@Test
	public void testselectMovieVideo() {
		movieVideoMapper.selectMovieVideo("ABCD");
	}
	@Test
	public void testdeleteMovieVideo() {
		movieVideoMapper.deleteMovieVideo("ABCD");
	}
	@Test
	public void testdeleteAllMovieVideo() {
		movieVideoMapper.deleteAllMovieVideo(1l);
	}
	@Test
	public void testupdateMovieVideo() {
		MovieVideo movieVideo = MovieVideo.builder().mno(1l).videoKey("ABCD").type("typetest1")
				.build();
		movieVideoMapper.updateMovieVideo(movieVideo);
	}
	@Test
	public void testselectMovieVideoList() {
		movieVideoMapper.selectMovieVideoList(1l);
	}
	@Test
	public void testselectMovieVideoListByMovieType() {
		Long mno = 1l;
		String type = "typetest1";
		 List<MovieVideo> result = movieVideoMapper.selectMovieVideoListByMovieType(mno, type);
		 log.info(result);
	}
	@Test
	public void testselectMovieVideoTotal() {
		movieVideoMapper.selectMovieVideoTotal(1l);
		
	}
}
