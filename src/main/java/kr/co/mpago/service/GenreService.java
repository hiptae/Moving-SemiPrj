package kr.co.mpago.service;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import kr.co.mpago.domain.Genre;
import kr.co.mpago.domain.Genres;
import kr.co.mpago.domain.MovieVideo;
import kr.co.mpago.domain.MovieVideoResults;
import kr.co.mpago.mapper.GenreMapper;
import kr.co.mpago.util.DBUtils;
import kr.co.mpago.util.MovieJsonDataFetcher;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenreService {
	@Getter
	private static GenreService genreService = new GenreService();
	private GenreMapper genreMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(GenreMapper.class);
	
	/**
	 * 장르 추가
	 * @param genre
	 */
	public void addGenre(Genre genre) {
		genreMapper.insertGenre(genre);
	}
	
	/**
	 * 장르 선택
	 * @param gno
	 * @return
	 */
	public Genre getGenre(Long gno) {
		return genreMapper.selectGenre(gno);
	}
	
	/**
	 * 장르 삭제
	 * @param gno
	 * @return
	 */
	public boolean removeGenre(Long gno) {
		return genreMapper.deleteGenre(gno) > 0;
	}
	
	/**
	 * 장르 변경
	 * @param genre
	 * @return
	 */
	public boolean modifyGenre(Genre genre) {
		return genreMapper.updateGenre(genre) > 0;
	}
	
	/** 
	 * 장르 리스트조회
	 * @return
	 */
	public List<Genre> getGenreList() {
		return genreMapper.selectGenreList();
	}

	/**
	 * 메인에서 사용할 장르 리스트
	 * @return
	 */
	public List<Genre> getGenreMain() {
		return genreMapper.selectGenreMain();
	}
	
	/**
	 * ApiUrl값(실제 https:// 주소값)
	 * @author gilho
	 * @param mno
	 * @param apiKey
	 * @return
	 */
	public String getMovieApiUrl(String apiKey) {
		return "https://api.themoviedb.org/3/genre/movie/list?api_key=" + apiKey +"&language=ko-kr";
	}

	/**
	 * JSON 데이터를 파싱하여 데이터베이스에 저장 (Map 형태)
	 * @author gilho
	 * @param mno
	 * @param apiKey
	 * @param jsonMovieData 
	 * @throws IOException
	 */
	public void addMovieDataFromJson(String apiKey, String apiUrl) throws IOException {
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
	            	log.info(genre);
	            	try { genreMapper.insertGenre(genre); } catch (Exception e) {e.printStackTrace(); }		
	            }
	        }
		}
	}
}
