package kr.co.mpago.service;

import java.io.IOException;

import org.junit.Test;

import kr.co.mpago.domain.Genre;
import kr.co.mpago.util.MovieJsonDataFetcher;
import lombok.extern.log4j.Log4j;

@Log4j
public class GenreServiceTests {
	GenreService genreService = GenreService.getGenreService();
	MovieJsonDataFetcher fetcher = new MovieJsonDataFetcher();

	@Test
	public void testGetGenreList() {
		genreService.getGenreList();
	}
	
	@Test
	public void testGetGenre() {
		Long gno = 2l;
		genreService.getGenre(gno);
	}
	
	@Test
	public void testAddGenre() {
		Long gno = 2l;
		Genre genre = genreService.getGenre(gno);
		genreService.addGenre(genre);
	}

	@Test
	public void testRemoveGenre() {
		Long gno = 2l;
		genreService.removeGenre(gno);
	}
	
	@Test
	public void testModifyGenre() {
		Long gno = 2l;
		Genre genre = genreService.getGenre(gno);
		genre.setGenre("장르이름");
		genreService.modifyGenre(genre);
	}

	
	//테스트 성공
	@Test
	public void testgetMovieApiUrl() {
		Long mno = 157336L;
		String apiKey = "60f92fc317ba11184216e66058a386e1";
		String apiurl = genreService.getMovieApiUrl(apiKey);
		log.info(apiurl);
	}
	
	//테스트 성공
	@Test
	public void testFetchJsonData() throws IOException {
		Long mno = 16l;
		String apiKey = "60f92fc317ba11184216e66058a386e1";
		log.info(apiKey);
		String apiUrl = genreService.getMovieApiUrl(apiKey);
		log.info(apiUrl);
		String jsonMovieData = fetcher.fetchJsonData(apiUrl);
		log.info(jsonMovieData);
	}
	
	//추가
	@Test
	public void testAddMovieImage() throws IOException {
//		for (Long mno = 16l; mno < 3000l; mno++) {
//		Long mno = 16l;	
		String apiKey = "60f92fc317ba11184216e66058a386e1";
		String apiUrl = genreService.getMovieApiUrl(apiKey);
		log.info(apiUrl);
		log.info(fetcher.fetchJsonData(apiUrl));
		genreService.addMovieDataFromJson(apiKey, genreService.getMovieApiUrl(apiKey));
//		log.info(movieServi/ce.getMovie(mno));
		}
//	}
}
