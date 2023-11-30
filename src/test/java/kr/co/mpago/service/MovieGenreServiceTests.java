package kr.co.mpago.service;

import java.io.IOException;

import org.junit.Test;

import kr.co.mpago.util.MovieJsonDataFetcher;
import lombok.extern.log4j.Log4j;

@Log4j
public class MovieGenreServiceTests {
	MovieGenreService movieGenreService = MovieGenreService.getMovieGenreService();
	MovieJsonDataFetcher fetcher = new MovieJsonDataFetcher();
	
	//테스트 성공
		@Test
		public void testgetMovieApiUrl() {
			Long mno = 157336L;
			String apiKey = "60f92fc317ba11184216e66058a386e1";
			String apiurl = movieGenreService.getMovieApiUrl(mno, apiKey);
			log.info(apiurl);
		}
		
		//테스트 성공
		@Test
		public void testFetchJsonData() throws IOException {
			Long mno = 16l;
			String apiKey = "60f92fc317ba11184216e66058a386e1";
			log.info(apiKey);
			String apiUrl = movieGenreService.getMovieApiUrl(mno, apiKey);
			log.info(apiUrl);
			String jsonMovieData = fetcher.fetchJsonData(apiUrl);
			log.info(jsonMovieData);
		}
		
		//추가
		@Test
		public void testAddMovieImage() throws IOException {
			Long[] type = {492008l, 961268l, 606403l, 851644l, 290098l, 799379l, 852881l, 496243l, 750209l, 581528l, 615173l, 396535l, 633374l, 588108l, 204553l, 387824l, 995612l, 397567l, 843794l, 601796l, 390845l, 705996l, 800345l, 481871l, 619803l, 727209l, 670l, 399905l, 938008l, 727340l, 729854l, 110415l, 707610l, 518068l, 59421l, 474412l, 626872l, 482036l, 897160l, 333167l, 581392l, 773867l, 286687l, 479718l, 614696l, 508642l, 698779l, 340819l, 530254l, 75432l, 736545l, 628704l, 386716l, 581387l, 269955l, 736732l, 865463l, 784941l, 200085l, 49797l, 255709l, 16318l, 4552l, 716263l, 581389l, 965143l, 629028l, 826945l, 849869l, 372921l, 491584l, 662237l, 33196l, 405817l, 1148154l, 955555l, 845222l, 11423l, 293670l, 122126l};
			for (Long mno : type) {
			String apiKey = "60f92fc317ba11184216e66058a386e1";
			String apiUrl = movieGenreService.getMovieApiUrl(mno, apiKey);
			log.info(apiUrl);
			log.info(fetcher.fetchJsonData(apiUrl));
			movieGenreService.addMovieDataFromJson(mno, apiKey, movieGenreService.getMovieApiUrl(mno, apiKey));
//			log.info(movieServi/ce.getMovie(mno));
			}
		}
		
		@Test
		public void testgetFirstTenByGenreListWithLanguage() {
			Long gno = 12l;
			String language = "en";
			movieGenreService.getFirstTenByGenreListWithLanguage(gno, language);
		}
		
		@Test
		public void testgetMoviesByGenre() {
			Long gno = 12l;
			String language = "en";
			movieGenreService.getMoviesByGenre(gno, language);
		}
}
