package kr.co.mpago.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.mpago.domain.Movie;
import kr.co.mpago.service.MovieService;

@WebServlet("/admin/movie/detail")
public class AdminMovieDetail extends HttpServlet {
	MovieService movieService = MovieService.getMovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mno = req.getParameter("mno");
        if (mno != null && !mno.isEmpty()) {
    	try {
        	Long mvno = Long.parseLong(mno);
        	Movie movie = movieService.getMovie(mvno);    		
            if (movie != null) {
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(new Gson().toJson(movie));
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("Cannot find the movie");
            }
    	} catch (NumberFormatException e) {
    		   resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
               resp.getWriter().write("Invalid mno");
    		}
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Invalid mno");
        }
    }
}