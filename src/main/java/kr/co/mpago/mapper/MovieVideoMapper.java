package kr.co.mpago.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.co.mpago.domain.Movie;
import kr.co.mpago.domain.MovieImage;
import kr.co.mpago.domain.MovieVideo;

/**
 * 테스트 성공
 * @author gilho
 *
 */
public interface MovieVideoMapper {
	void insertMovieVideo(MovieVideo movieVideo); // 영화 비디오 insert
	MovieVideo selectMovieVideo(String videoKey); // 영화 비디오 select
	int deleteMovieVideo(String videoKey); // 영화 비디오 삭제
	int deleteAllMovieVideo(Long mno); // mno번 영화 비디오 전체 삭제
	int updateMovieVideo(MovieVideo movieVideo); // 영화 비디오 update
	List<MovieVideo> selectMovieVideoList(Long mno); // mno번 영화 비디오 전체 보기
	
	// mno번 영화의 비디오 종류별 리스트 보기
	List<MovieVideo> selectMovieVideoListByMovieType(@Param("mno") Long mno, @Param("type") String type);
	
	// mno번 영화의 비디오 갯수 전체보기
	int selectMovieVideoTotal(Long mno);
	
	// 비디오가 없는 영화의 리스트
	@Select("select * from tbl_movieVideo right join tbl_movie using(mno) where videokey is null order by mno")
	List<Movie> moviesWithoutVideos();
	
}
