package kr.co.mpago.controller.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.domain.Favorite;
import kr.co.mpago.service.FavoriteService;

/**
 * 
 * @author 백승현
 *  mno와 userno에 따른 찜 버튼(하트) 구현
 */
@WebServlet("/favToggle")
public class FavoriteToggle extends HttpServlet{
	FavoriteService favoriteService = FavoriteService.getFavoriteService(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long mno = Long.valueOf(req.getParameter("mno"));
		Long userno = Long.valueOf(req.getParameter("userno"));
		favoriteService.toggle(Favorite.builder().userno(userno).mno(mno).build());
	}
	
}
