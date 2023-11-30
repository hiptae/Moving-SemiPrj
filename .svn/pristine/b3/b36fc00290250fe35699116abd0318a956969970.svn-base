package kr.co.mpago.controller.movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.domain.Movie;
import kr.co.mpago.domain.MovieImage;
import kr.co.mpago.service.MovieCastService;
import kr.co.mpago.service.MovieImageService;
import kr.co.mpago.service.MovieService;
import kr.co.mpago.util.WebUtils;
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/movie/cast")
public class CastController extends HttpServlet {
	private MovieCastService movieCastService = MovieCastService.getMovieCastService();
	private MovieService movieService = MovieService.getMovieService();
	private MovieImageService movieImageService = MovieImageService.getMovieImageService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long mno = Long.valueOf(req.getParameter("m"));
		
		// 영화
		Movie movie = movieService.getMovie(mno);
		if(movie == null || req.getParameter("m") == null) {	
			WebUtils.alert(resp, "올바르지 못한 접근입니다." ,"/movie/list");
			return;
		}
		
		MovieImage image = movieImageService.getMovieImageListByCategory(mno, "backdrop");
		if(image != null) {
			String imagePath = image.getBackdroppath();
			if (imagePath != null && !imagePath.startsWith("https://image.tmdb.org/t/p/w300")) {
	            image.setBackdroppath("https://image.tmdb.org/t/p/w300" + imagePath);
	        }
		} else {
			image = new MovieImage();
			image.setMno(mno);
			image.setImagecate("poster");
			image.setBackdroppath("https://via.placeholder.com/300x169");
		}
		
		// 배우
		Map<String, List<Map<String, Object>>> groupedCasts = new HashMap<>();
		List<Map<String, Object>> castList = new ArrayList<>();
		Map<String, List<Map<String, Object>>> groupedActorList = new HashMap<>();
		
		List<String> casttypes = movieCastService.getCasttypes();
		for (String casttype : casttypes) {
			log.info(casttype);
			if (casttype.contains("Acting")) {
				castList = movieCastService.getMovieCastListByType(mno, casttype);
				groupedActorList.put(casttype, castList);
			}
			else {
				List<Map<String, Object>> crewList = movieCastService.getMovieCastListByType(mno, casttype);
				groupedCasts.put(casttype, crewList);
			}
		}
		
		// 배우 수
		int actors = movieCastService.getActingListCount(mno);
		int crews = movieCastService.getNotActingListCount(mno);
		log.info("groupedCasts" + groupedCasts);
		req.setAttribute("image", image);
		req.setAttribute("actors", actors);
		req.setAttribute("crews", crews);
		req.setAttribute("movie", movie);
		req.setAttribute("castList", castList);
		req.setAttribute("groupedCasts", groupedCasts);
		req.getRequestDispatcher("/WEB-INF/views/movie/movieCasts.jsp").forward(req, resp);
		
	}
	
}
