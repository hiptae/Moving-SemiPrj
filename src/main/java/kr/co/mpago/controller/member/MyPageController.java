package kr.co.mpago.controller.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.domain.Favorite;
import kr.co.mpago.domain.Member;
import kr.co.mpago.domain.MovieImage;
import kr.co.mpago.service.FavoriteService;
import kr.co.mpago.service.MovieImageService;
import kr.co.mpago.service.MovieService;
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/member/myPage")
public class MyPageController extends HttpServlet{
	private FavoriteService favoriteService = FavoriteService.getFavoriteService();
	private MovieService movieService = MovieService.getMovieService();
	private MovieImageService movieImageService = MovieImageService.getMovieImageService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = (Member)req.getSession().getAttribute("member");	
		
		if(member == null)     { // 비로그인시 메인으로 이동
            resp.sendRedirect("/");
            return;
        }
		  List<Favorite> favoriteList = favoriteService.getList(member.getUserno()); // userno에 따른 찜한 영화 리스트
		  List<MovieImage> imageList = new ArrayList<>(); // 영화 이미지 리스트
		
		  for (Favorite favorite : favoriteList) {
		        Long mno = favorite.getMno(); // 찜한 영화번호
		        MovieImage image = movieImageService.getMovieImageListByCategory(mno, "poster"); // poster형식의 영화 이미지 가져오기
		        if(image != null) {
		            String imagePath = image.getBackdroppath();
		            if (imagePath != null && !imagePath.startsWith("https://image.tmdb.org/t/p/w300")) {
		                image.setBackdroppath("https://image.tmdb.org/t/p/w300" + imagePath);
		            }
		            //log.info(image);
		        } else {
		            image = new MovieImage();
		           // log.info(image);
		            image.setMno(mno);
		            image.setImagecate("poster");
		            image.setBackdroppath("https://via.placeholder.com/300x450");
		        }
		        imageList.add(image);
		    }
		  
		//log.info(imageList);
		
		req.setAttribute("imageList", imageList);
		req.getRequestDispatcher("/WEB-INF/views/member/myPage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
