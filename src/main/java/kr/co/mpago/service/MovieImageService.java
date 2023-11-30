package kr.co.mpago.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import kr.co.mpago.domain.Movie;
import kr.co.mpago.domain.MovieImage;
import kr.co.mpago.mapper.MovieImageMapper;
import kr.co.mpago.util.DBUtils;
import kr.co.mpago.util.MovieJsonDataFetcher;
import lombok.Getter;
import lombok.extern.log4j.Log4j;

@Log4j
public class MovieImageService {
	@Getter
	public static MovieImageService movieImageService = new MovieImageService();
	private MovieImageMapper movieImageMapper = DBUtils.sqlSessionFactory().openSession(true).getMapper(MovieImageMapper.class);
	
	/**
	 * 이미지 pk로 그 이미지 정보 가져오기
	 * @param backdroppath
	 * @return
	 */
	public MovieImage getMovieImage(String backdroppath) {
		return movieImageMapper.selectMovieImage(backdroppath);
	}
	
	/**
	 * 이미지 추가
	 * @param movieImage
	 */
	public void addMovieImage(MovieImage movieImage) {
		movieImageMapper.insertMovieImage(movieImage);
	}
	
	/**
	 * 이미지 삭제
	 * @param backdroppath
	 * @return
	 */
	public int removeMovieImage(String backdroppath) {
		return movieImageMapper.deleteMovieImage(backdroppath);
	}
	
	/**
	 * 이미지 정보 변경
	 * @param mno
	 * @return
	 */
	public int removeAllMovieImage(Long mno) {
		return movieImageMapper.deleteAllMovieImage(mno);
	}
	
	/**
	 * mno번 영화의 이미지 리스트 조회
	 * @param mno
	 * @return
	 */
	public List<MovieImage> getMovieImageList(Long mno) {
		return movieImageMapper.selectMovieImageList(mno);
		
	}
	
	/**
	 * mno번 영화의 이미지 종류로 리스트 조회
	 * (사실상 단일조회) 
	 * @param mno
	 * @param imagecate
	 * @return
	 */
	public MovieImage getMovieImageListByCategory(Long mno, String imagecate) {
		return movieImageMapper.selectMovieImageListByImageCategory(mno, imagecate);
	}
	
	/**
	 * mno번 영화의 이미지 갯수
	 * @param mno
	 * @return
	 */
	public int getMovieImageTotal(Long mno) {
		return movieImageMapper.selectMovieImageTotal(mno);
	}
	
	public List<Map<String, Object>> getMovieGenreImg(String imagecate) {
		return movieImageMapper.selectMovieGenreImg(imagecate);
	}
	
	/**
	 * 영화 장르로 이미지 가져오기 10개
	 */
	public List<Map<String,Object>> getGenreListByMovieWithImages(Long gno) {
		return movieImageMapper.selectGenreListByMovieWithImages(gno);
	}
	
	/**
	 * @author gilho
	 * ApiUrl값(실제 https:// 주소값) 
	 * @param mno
	 * @param apiKey
	 * @return
	 */
	public String getMovieApiUrl(Long mno, String apiKey) {
		return "https://api.themoviedb.org/3/movie/" + mno + "?language=ko-kr&api_key=" + apiKey;
	}

	/**
	 * JSON 데이터를 파싱하여 데이터베이스에 저장
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
			MovieImage movieImage = gson.fromJson(jsonMovieData, MovieImage.class);
			movieImage.setImagecate("poster");
				try { movieImageMapper.insertMovieImage(movieImage);} catch (Exception e) {e.printStackTrace(); }				
		}
	}
}
