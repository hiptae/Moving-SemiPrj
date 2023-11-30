package kr.co.mpago.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.mpago.domain.Member;
import kr.co.mpago.domain.Movie;
import kr.co.mpago.service.MovieService;

@WebServlet("/admin/movie/update")
public class AdminMovieModify extends HttpServlet {
	MovieService movieService = MovieService.getMovieService();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//view에서 보낸 JSON 데이터를 읽어서 Java 객체(movie)로 변환
        Movie movie = new Gson().fromJson(req.getReader(), Movie.class);
        boolean result = movieService.modifyMovie(movie);
        
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        //결과값 json으로 변환
        resp.getWriter().write(new Gson().toJson(result));
    }
}