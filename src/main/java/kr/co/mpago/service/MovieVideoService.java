package kr.co.mpago.service;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import kr.co.mpago.domain.MovieImage;
import kr.co.mpago.domain.MovieVideo;
import kr.co.mpago.domain.MovieVideoResults;
import kr.co.mpago.mapper.MovieVideoMapper;
import kr.co.mpago.util.DBUtils;
import kr.co.mpago.util.MovieJsonDataFetcher;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
public class MovieVideoService {
	@Getter
	public static MovieVideoService movieVideoService = new MovieVideoService();
	private MovieVideoMapper movieVideoMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(MovieVideoMapper.class);

	/**
	 * 영화의 비디오 추가
	 * @param movieVideo
	 */
	public void addMovieVideoMovieVideo(MovieVideo movieVideo) {
		movieVideoMapper.insertMovieVideo(movieVideo);
	}
	
	/**
	 * 비디오 키로 영화 정보 찾기
	 * @param videoKey
	 * @return
	 */
	public MovieVideo getMovieVideo(String videoKey) {
		return movieVideoMapper.selectMovieVideo(videoKey);
	}
	
	/**
	 * 영화의 비디오 비디오 키로 삭제
	 * @param videoKey
	 * @return
	 */
	public int removeMovieVideo(String videoKey) {
		return movieVideoMapper.deleteMovieVideo(videoKey);
	}

	/**
	 * 영화의 비디오 전부 삭제
	 * @param mno
	 * @return
	 */
	public int removeAllMovieVideo(Long mno) {
		return movieVideoMapper.deleteAllMovieVideo(mno);
	}
	
	/**
	 * 영화의 비디오 url 정보 수정
	 * @param movieVideo
	 * @return
	 */
	public int modifyMovieVideo(MovieVideo movieVideo) {
		return movieVideoMapper.updateMovieVideo(movieVideo);
	}
	
	/**
	 * mno번 영화의 비디오 리스트 가져오기
	 * @param mno
	 * @return
	 */
	public List<MovieVideo> getMovieVideoList(Long mno) {
		return movieVideoMapper.selectMovieVideoList(mno);
	}
	
	/**
	 * mno번 영화의 비디오 + 그 비디오의 타입으로 리스트 조회
	 * @param mno
	 * @param type
	 * @return
	 */
	public List<MovieVideo> getMovieVideoListByMovieType(Long mno, String type) {
		return movieVideoMapper.selectMovieVideoListByMovieType(mno, type);
	}
	
	/**
	 * mno번 영화의 비디오 갯수 조회
	 * @param mno
	 * @return
	 */
	public int getMovieVideoTotal(Long mno) {
		return movieVideoMapper.selectMovieVideoTotal(mno);
	}
	
	
	/**
	 * @author gilho
	 * ApiUrl값(실제 https:// 주소값)
	 * @param mno
	 * @param apiKey
	 * @return
	 */
	public String getMovieApiUrl(Long mno, String apiKey) {
		return "https://api.themoviedb.org/3/movie/" + mno + "/videos?api_key=" + apiKey +"&append_to_response=videos";
	}

	/**
	 * JSON 데이터를 파싱하여 데이터베이스에 저장 (Map 형태이므로 Image랑은 조금 다름)
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
			MovieVideoResults movieVideoResults = gson.fromJson(jsonMovieData, MovieVideoResults.class);
			List<MovieVideo> results = movieVideoResults.getResults();
			log.info(results);
			if (results != null) {
	            for (MovieVideo movieVideo : results) {
	            	log.info(movieVideo);
	            	movieVideo.setMno(mno);
	            	try { movieVideoMapper.insertMovieVideo(movieVideo); } catch (Exception e) {e.printStackTrace(); }		
	            }
	        }
		}
	}
}
