package kr.co.mpago.mapper;

import java.util.List;

import kr.co.mpago.domain.Criteria;
import kr.co.mpago.domain.IndexMovie;
import kr.co.mpago.domain.Movie;

public interface MovieMapper {
	
	// 테스트 완료
	void insertMovie(Movie movie);	// 영화 추가
	Movie selectMovie(Long mno); // 영화 선택(개별)
	int deleteMovie(Long mno); // 영화 삭제
	int updateMovie(Movie movie); // 영화 수
	List<Movie> selectMovieList(); // 영화 가져오기, 최신순
	List<Movie> selectMovieListByLanguage(String language); // 영화 가져오기, 언어별
	List<Movie> selectTenMovieListByLanguage(String language); // 영화 가져오기, 언어별
	int selectMovieTotal();	// 영화의 총 갯수
	int selectMovieTotal(Criteria criteria); //관리자 페이지 영화 총 갯수
	String selectMovieTitle(Long mno);	// 번호로 영화의 제목 가져오기
	List<Movie> searchMoviMain(String search); // 헤더 검색기능
	List<Movie> searchMoviList(String search); // 헤더 검색기능(영화만)
	int getTotalWithKeyword(Criteria criteria); // 관리자 검색페이징
	List<Movie> getListWithPaging(Criteria criteria); // 관리자 목록 페이징
	int deleteAll(List<Long> mnos); // 영화 선택 삭제
	List<IndexMovie> selectIndexMovieList(); // 메인에서 쓰는 영화 리스트 불러오기
}
