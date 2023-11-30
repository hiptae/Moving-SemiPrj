package kr.co.mpago.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import kr.co.mpago.domain.Criteria;
import kr.co.mpago.domain.Genre;
import kr.co.mpago.domain.Genres;
import kr.co.mpago.domain.MovieGenre;
import kr.co.mpago.domain.MovieVideo;
import kr.co.mpago.domain.MovieVideoResults;
import kr.co.mpago.mapper.MovieGenreMapper;
import kr.co.mpago.util.DBUtils;
import kr.co.mpago.util.MovieJsonDataFetcher;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

// test X
@Log4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieGenreService {
	@Getter
	private static MovieGenreService movieGenreService = new MovieGenreService();
	private MovieGenreMapper movieGenreMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(MovieGenreMapper.class);
	
	/**
	 * 장르 추가
	 * @param genre
	 */
	public void addMovieGenre(MovieGenre movieGenre) {
		movieGenreMapper.insertMovieGenreMapping(movieGenre);
	}
	
	/**
	 * mno번 영화의 List 조회 
	 * @param mno
	 * @return
	 */
	public List<MovieGenre> getListByMovie(Long mno) {
		return movieGenreMapper.selectListByMovie(mno);
	}
	
	/**
	 * gno번 장르의 List 조회
	 * @param gno
	 * @return
	 */
	public List<MovieGenre> getListByGenre(Long gno) {
		return movieGenreMapper.selectListByGenre(gno);
	}

	/**
	 * gno번 장르의 List 10개 조회
	 * @param gno
	 * @return
	 */
	public List<MovieGenre> getFirstTenByGenreList(Long gno) {
		return movieGenreMapper.selectFirstTenByGenreList(gno);
	}
	/**
	 * gno번 장르의 List 10개 조회 (언어별)
	 * @param gno
	 * @param language
	 * @return
	 */
	public List<Map<String, Object>> getFirstTenByGenreListWithLanguage(Long gno, String language) {
		return movieGenreMapper.selectFirstTenByGenreListWithLanguage(gno, language);
	}
	
	
	/**
	 * 장르 선택
	 * @param gno
	 * @return
	 */
	public List<Map<String, Object>> getMovieGenre(Long mno) {
		return movieGenreMapper.selectGenreListByMovie(mno);
	}
	
	/**
	 * 장르 삭제
	 * @param mgno
	 * @return
	 */
	public boolean removeMovieGenre(Long mgno) {
		return movieGenreMapper.deleteMovieGenreMapping(mgno) > 0;
	}
	
	/**
	 * 장르 변경
	 * @param movieGenre
	 * @return
	 */
	public boolean modifyMovieGenre(MovieGenre movieGenre) {
		return movieGenreMapper.updateMovieGenreMapping(movieGenre) > 0;
	}
	
	/**
	 * 장르, 언어에 따른 영화리스트 페이징 쿼리
	 * @param gno
	 * @param language
	 * @param criteria
	 * @return
	 */
	public List<MovieGenre> getMoviesByGenreAndLanguage(Long gno, String language, int offset, int amount) {
        return movieGenreMapper.selectMovieListByGenreAndLanguage(gno, language, offset, amount);
    }
	
	/**
	 * 장르, 언어에 따른 영화리스트 갯수
	 * @param gno
	 * @param language
	 * @return
	 */	
	public int getTotalByGenreAndLanguage(Long gno, String language) {
        return movieGenreMapper.selectTotalByGenreAndLanguage(gno, language);
    }
	
	/**
	 * 장르에 따른 영화리스트 페이징 쿼리
	 * @param gno
	 * @param criteria
	 * @return
	 */
	public List<Map<String, Object>> getMoviesByGenre(Long gno, String language) {
		return movieGenreMapper.selectMovieListByGenre(gno, language);
	}
	
	/**
	 * 장르에 따른 영화리스트 갯수
	 * @param gno
	 * @return
	 */
	public int getTotalByGenre(Long gno) {
		return movieGenreMapper.selectTotalByGenre(gno);
	}
	
	/**
	 * ApiUrl값(실제 https:// 주소값)
	 * @author gilho
	 * @param mno
	 * @param apiKey
	 * @return
	 */
	public String getMovieApiUrl(Long mno, String apiKey) {
		return "https://api.themoviedb.org/3/movie/" + mno + "?api_key=" + apiKey +"&language=ko-kr";
	}

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
			Genres genres = gson.fromJson(jsonMovieData, Genres.class);
			List<Genre> results = genres.getGenres();
			log.info(results);
			if (results != null) {
	            for (Genre genre : results) {
	            	MovieGenre movieGenre = MovieGenre.builder().gno(genre.getGno()).mno(mno)
	            			.build();
	            	
	            	try { movieGenreMapper.insertMovieGenreMapping(movieGenre); } catch (Exception e) {e.printStackTrace(); }		
	            }
	        }
		}
	}
	
}
