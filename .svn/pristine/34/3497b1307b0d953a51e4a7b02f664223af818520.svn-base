package kr.co.mpago.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.transaction.Transaction;

import com.google.gson.Gson;

import kr.co.mpago.domain.Cast;
import kr.co.mpago.domain.Casts;
import kr.co.mpago.domain.Genre;
import kr.co.mpago.domain.Genres;
import kr.co.mpago.domain.MovieCast;
import kr.co.mpago.domain.MovieCasts;
import kr.co.mpago.domain.MovieGenre;
import kr.co.mpago.mapper.CastMapper;
import kr.co.mpago.mapper.MovieCastMapper;
import kr.co.mpago.mapper.MovieMapper;
import kr.co.mpago.util.DBUtils;
import kr.co.mpago.util.MovieJsonDataFetcher;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

// test X
@Log4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieCastService {
	@Getter
	private static MovieCastService movieCastService = new MovieCastService();
	private MovieCastMapper movieCastMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(MovieCastMapper.class);
	private CastMapper castMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(CastMapper.class);
	
	/**
	 * 배우 추가
	 * @param genre
	 */
	public void addMovieCast(MovieCast movieCast) {
		movieCastMapper.insertMovieCastMapping(movieCast);
	}
	/** 
	 * 배우 리스트조회
	 * @return
	 */
	public List<Map<String, Object>> getMovieCastList(Long castno) {
		return movieCastMapper.selectMovieListByCast(castno);
	}
	
	/**
	 * mno번 영화의 배우 List 조회 
	 * @param mno
	 * @return
	 */
	public List<MovieCast> getListByMovie(Long mno) {
		return movieCastMapper.selectListByMovie(mno);
	}
	
	/**
	 * castno번 배우의 영화 List 조회
	 * @param castno
	 * @return
	 */
	public List<MovieCast> getListByCast(Long castno) {
		return movieCastMapper.selectListByCast(castno);
	}
	/**
	 * 배우 선택
	 * @param castno
	 * @return
	 */
	public List<Map<String, Object>> getMovieCast(Long mno) {
		return movieCastMapper.selectCastListByMovie(mno);
	}
	
	/**
	 * 배우 삭제
	 * @param mcno
	 * @return
	 */
	public boolean removeMovieCast(Long mcno) {
		return movieCastMapper.deleteMovieCastMapping(mcno) > 0;
	}
	
	/**
	 * 장르 변경
	 * @param movieCast
	 * @return
	 */
	public boolean modifyMovieCast(MovieCast movieCast) {
		return movieCastMapper.updateMovieCastMapping(movieCast) > 0;
	}
	
	/**
	 * 중복되는 영화-배우데이터 한개만 남기고 삭제
	 * @return
	 */
	public boolean removeDistinctMovieCastData() {
		return movieCastMapper.deleteDistinctMovieCastData() > 0;
	}
	
	/**
	 * 영화 상세보기 페이지에서 사용할 배우 8명 조회
	 * @param mno
	 * @return
	 */
	public List<Map<String, Object>> getMovieOneToEightCastList(Long mno) {
		return movieCastMapper.selectMovieOneToEightCastList(mno);
	}
	
	/**
	 * 배우 리스트에서 사용할 배우 & 비 배우 타입별 조회
	 * @param mno
	 * @return
	 */
	public List<Map<String, Object>> getMovieCastListByType(Long mno, String casttype) {
		return movieCastMapper.selectMovieCastListByType(mno, casttype);
	}
	
	/**
	 * 배우 리스트에서 사용할 배우 인원 수
	 * @param mno
	 * @return
	 */
	public int getActingListCount(Long mno) {
		return movieCastMapper.selectActingListCount(mno);
	}
	
	/**
	 * 배우 리스트에서 사용할 비 배우 인원 수
	 * @param mno
	 * @return
	 */
	public int getNotActingListCount(Long mno) {
		return movieCastMapper.selectNotActingListCount(mno);
	}
	
	public List<String> getCasttypes() {
		return movieCastMapper.selectCasttypes();
	}
	
	/**
	 * ApiUrl값(실제 https:// 주소값)
	 * @author gilho
	 * @param mno
	 * @param apiKey
	 * @return
	 */
	public String getMovieApiUrl(Long mno, String apiKey) {
		return "https://api.themoviedb.org/3/movie/" + mno + "/credits?api_key=" + apiKey +"&language=ko-kr";
	}
	/**
	 * 관리자 페이지 영화 삭제시 참조 테이블 삭제
	 * @author youngmin
	 * @param mno
	 * @return
	 */
	/*
	 * public void deleteByMovieNos(List<Long> movieNos) {
	 * movieCastMapper.deleteByMovieNos(movieNos); }
	 */
	/**
	 * JSON 데이터를 파싱하여 데이터베이스에 저장 (Map 형태)
	 * @author gilho
	 * @param mno
	 * @param apiKey
	 * @param jsonMovieData 
	 * @throws IOException
	 */
	public void addMovieDataFromJson(Long mno, String apiKey, String apiUrl) throws IOException {
		MovieJsonDataFetcher fetcher = new MovieJsonDataFetcher();
		String jsonMovieData = fetcher.fetchJsonData(apiUrl);
		log.info(jsonMovieData);
		if(jsonMovieData != null) {
			Gson gson = new Gson();
			Casts casts = gson.fromJson(jsonMovieData, Casts.class);
			List<Cast> results = casts.getCasts();
			List<Cast> results2 = casts.getCrews();
			log.info(results);
			// 캐스트 멤버 처리
			if (results != null) {
			    for (Cast cast : results) {
			        // ID를 castno에 매핑하고 다른 세부 정보 설정
			        cast.setCastno(cast.getCastno()); // ID를 castno로 설정
			        try {
			            castMapper.insertCastWithCastno(cast);
			        } catch (Exception e) {
			            log.info(cast.getCastno() + "(배우)번 실패");
			        }
			    }
			}

			// 작업 스태프(crew) 멤버 처리 (results2)
			if (results2 != null) {
			    for (Cast crew : results2) {
			        // ID를 castno에 매핑하고 작업 스태프(crew)의 다른 세부 정보 설정
			        crew.setCastno(crew.getCastno()); // ID를 castno로 설정
			        try {
			            castMapper.insertCastWithCastno(crew);
			        } catch (Exception e) {
			            log.info(crew.getCastno() + "(배우)번 실패");
			        }
			    }
			}
        	 
			try {
		        Thread.sleep(1000); // 5초 대기
		    } catch (InterruptedException e) {
		        // 슬립이 중단되는 경우 예외 처리
		        e.printStackTrace();
		    }
        	
		}
	}
	public void addMovieDataFromJson2(Long mno, String apiKey, String apiUrl) throws IOException {
		MovieJsonDataFetcher fetcher = new MovieJsonDataFetcher();
		String jsonMovieData = fetcher.fetchJsonData(apiUrl);
		log.info(jsonMovieData);
		if(jsonMovieData != null) {
			Gson gson = new Gson();
			MovieCasts movieCasts = gson.fromJson(jsonMovieData, MovieCasts.class);
			List<MovieCast> results = movieCasts.getMovieCasts();
			List<MovieCast> results2 = movieCasts.getMovieCrews();
			log.info(results);
			if (results != null) {
	            for (MovieCast movieCast : results) {
	            	movieCast = MovieCast.builder().order(movieCast.getOrder()).casting(movieCast.getCasting()).castno(movieCast.getCastno()).castType(movieCast.getCastType()).mno(mno).build();
	            	try {movieCastMapper.insertMovieCastMapping(movieCast);} catch (Exception e) {log.info(movieCast.getCastno() + "(배우)번 실패");}
	            	
	            }
	        }
			log.info(results2);
			if (results2 != null) {
				for (MovieCast movieCrew : results2) {
					movieCrew = MovieCast.builder().order(movieCrew.getOrder()).casting(movieCrew.getCasting()).castno(movieCrew.getCastno()).castType(movieCrew.getCastType()).mno(mno).build();
	            	try {movieCastMapper.insertMovieCastMapping(movieCrew);} catch (Exception e) {log.info(movieCrew.getCastno() + "(배우)번 실패");}
	            	
	            }
			}
        	 
        	
        	
		}
	}
	
}
