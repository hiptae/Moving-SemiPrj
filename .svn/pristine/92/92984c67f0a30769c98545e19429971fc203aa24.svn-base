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
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/member/favorite")
public class FavoriteController extends HttpServlet{
	private FavoriteService favoriteService = FavoriteService.getFavoriteService();
	private MovieImageService movieImageService = MovieImageService.getMovieImageService();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 현재로그인한 member
		Member member = (Member) req.getSession().getAttribute("member"); 
		
		if(member == null) {	// 비로그인시 메인으로 이동
            resp.sendRedirect("/");
            return;
        }
		  List<Favorite> favoriteList = favoriteService.getList(member.getUserno());
		  List<MovieImage> imageList = new ArrayList<>();
		
		  // 찜한 영화 포스터 
		  for (Favorite favorite : favoriteList) {
		        Long mno = favorite.getMno();
		        MovieImage image = movieImageService.getMovieImageListByCategory(mno, "poster");
		        if(image != null) {
		            String imagePath = image.getBackdroppath();
		            if (imagePath != null && !imagePath.startsWith("https://image.tmdb.org/t/p/w300")) {
		                image.setBackdroppath("https://image.tmdb.org/t/p/w300" + imagePath);
		            }
		           // log.info(image);
		        } else {
		            image = new MovieImage();
		           // log.info(image);
		            image.setMno(mno);
		            image.setImagecate("poster");
		            image.setBackdroppath("https://via.placeholder.com/300x450");
		        }
		        imageList.add(image);
		    }
		// log.info(imageList);

		// 영화포스터가져오기
		req.setAttribute("imageList", imageList);
		req.getRequestDispatcher("/WEB-INF/views/member/favorite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String fno = req.getParameter("fno");
	    String userno = req.getParameter("userno");
	    String mno = req.getParameter("mno");
	}
}