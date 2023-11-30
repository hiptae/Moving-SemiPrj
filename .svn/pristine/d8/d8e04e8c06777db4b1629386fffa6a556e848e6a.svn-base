package kr.co.mpago.controller.movie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.domain.Board;
import kr.co.mpago.domain.Favorite;
import kr.co.mpago.domain.Genre;
import kr.co.mpago.domain.Member;
import kr.co.mpago.domain.Movie;
import kr.co.mpago.domain.MovieGenre;
import kr.co.mpago.domain.MovieImage;
import kr.co.mpago.domain.Rate;
import kr.co.mpago.service.FavoriteService;
import kr.co.mpago.service.GenreService;
import kr.co.mpago.service.MovieCastService;
import kr.co.mpago.service.MovieGenreService;
import kr.co.mpago.service.MovieImageService;
import kr.co.mpago.service.MovieService;
import kr.co.mpago.service.RateService;
import kr.co.mpago.util.WebUtils;
import lombok.extern.log4j.Log4j;

/**
 * @WebServlet 
 * 
 * @author tj
 *
 */
@Log4j
@WebServlet({"/movie"})
// 미완성
public class MovieController extends HttpServlet {
	private MovieService movieService = MovieService.getMovieService();
	private MovieImageService movieImageService = MovieImageService.getMovieImageService();
	private RateService rateService = RateService.getRateService(); 
	private FavoriteService favoriteService = FavoriteService.getFavoriteService();
	private MovieCastService movieCastService = MovieCastService.getMovieCastService();
	private MovieGenreService movieGenreService = MovieGenreService.getMovieGenreService();
	private GenreService genreService = GenreService.getGenreService();
	
	/**
	 * 1. 영화 상세보기 page 
	 * @return "/movie?m={mno}"
	 * 
	 * 2. 영화 언어별 보기 page (메인화면 헤더 카테고리에서 한국영화, 외국영화 클릭시)
	 * @return "/movie/list?lang={language}"s
	 * 
	 * 3. 영화 카테고리별 보기 (메인화면 가로스크롤에서 더보기 누르면 나오는 화면)
	 * @return "/movie/list?g={gno}"
	 * 
	 * "/movie" : 인기 영화 페이지로 또는 전체 영화 페이지로
	 * "/movie/? : 구현예정 또는 구현필요X
	 * 				(필수구현-예정) ko(한국영화), en(외국영화) 
	 * 				(필수구현-예정) {mno}(영화번호, 상세조회)
	 * 			 	(구현예정 또는 구현필요X) top-rated(평점순), now-playing(현재상영중), upcoming(개봉예정), 등
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 영화
		Long mno = null;
		Movie movie = null;
		try {
			mno = Long.valueOf(req.getParameter("m"));
			movie = movieService.getMovie(mno);
			if(movie == null || req.getParameter("m") == null) {	
				WebUtils.alert(resp, "올바르지 못한 접근입니다." ,"/movie/list");
				return;
			}
		} catch (NumberFormatException | NullPointerException e) {
		    // 숫자로의 변환이 실패했거나 파라미터 "m"이 null일 때 실행
		    WebUtils.alert(resp, "올바르지 못한 입력입니다.", "/movie/list");
		    return;
		}
		
		// language가 en 이면 영어, ko 이면 한국어
		movie.setLanguage(movie.getLanguage().equals("en") ? "영어" : (movie.getLanguage().equals("ko") ? "한국어" : movie.getLanguage()));

		// 이미지 처리
		MovieImage image = movieImageService.getMovieImageListByCategory(mno, "poster");
		if(image != null) {
			String imagePath = image.getBackdroppath();
			if (imagePath != null && !imagePath.startsWith("https://image.tmdb.org/t/p/w300")) {
	            image.setBackdroppath("https://image.tmdb.org/t/p/w300" + imagePath);
	        }
		} else {
			image = new MovieImage();
			image.setMno(mno);
			image.setImagecate("poster");
			image.setBackdroppath("https://via.placeholder.com/300x450");
		}
		
		// 장르
		List<Genre> genre = genreService.getGenreList();
		List<MovieGenre> movieGenre = movieGenreService.getListByMovie(mno);
		
		// 배우 
		List<Map<String, Object>> casts = movieCastService.getMovieOneToEightCastList(mno);
		List<Map<String, Object>> modifiedCasts = new ArrayList<>();
		for (Map<String, Object> cast : casts) {
			Object profileImageValue = cast.get("profileImage");
			if (profileImageValue != null) {
				profileImageValue = "https://image.tmdb.org/t/p/w138_and_h175_face" + profileImageValue;
            }
			else {
				profileImageValue = "https://via.placeholder.com/138x175";
			}
			Map<String, Object> modifiedCast = new HashMap<>(cast);
			modifiedCast.put("profileImage", profileImageValue);
			modifiedCasts.add(modifiedCast);
		}
//		
		// 찜 구현
		Member member = null;
		Favorite favorite = null;
		try {
			member = (Member) req.getSession().getAttribute("member");  // 로그인한 사람
			if(member != null) {
				favorite = favoriteService.find(Favorite.builder().userno(member.getUserno()).mno(mno).build());
			}
			else {
				// 세션에 사용자 정보가 없을때 처리
			}
		} catch (NullPointerException e) {
			// NullPointException에 대한 처리
		}
		
		// 평점
		Map<String, Double> rate = rateService.getCountAndAvg(mno); 
		
		req.setAttribute("genres", genre);
		req.setAttribute("movieGenres", movieGenre);
		req.setAttribute("casts", modifiedCasts);
		req.setAttribute("image", image);
		req.setAttribute("movie", movie);
		req.setAttribute("rate", rate);
		req.setAttribute("favorite", favorite);
		req.getRequestDispatcher("/WEB-INF/views/movie/movieDetails.jsp").forward(req, resp);
	}
	


}
