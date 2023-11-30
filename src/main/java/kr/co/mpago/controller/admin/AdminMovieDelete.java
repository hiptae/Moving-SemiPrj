package kr.co.mpago.controller.admin;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.mpago.domain.Criteria;
import kr.co.mpago.domain.Movie;
import kr.co.mpago.domain.PageDTO;
import kr.co.mpago.service.MovieGenreService;
import kr.co.mpago.service.MovieService;
import lombok.extern.log4j.Log4j;

@WebServlet("/admin/movie/delete")
@Log4j
public class AdminMovieDelete extends HttpServlet{
	MovieService movieService = MovieService.getMovieService();
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = (req.getParameter("keyword") == null) ? "" : req.getParameter("keyword");
        String pageNumParam = req.getParameter("pageNum");
        int pageNum = 1;
        if (pageNumParam != null && !pageNumParam.isEmpty()) {
            try {
                pageNum = Integer.parseInt(pageNumParam);
            } catch (NumberFormatException e) {
                log.error("잘못된 페이지 번호 형식입니다. 기본 페이지 번호를 1로 설정합니다.");
            }
        }
        int amount = 15; 
        Criteria criteria = Criteria.builder()
							.pageNum(pageNum)
							.amount(amount)
							.keyword(keyword)
							.build();     
        
		List<Movie> searchResults = movieService.getMovieList(criteria);
		int totalMovies = movieService.findTotal(criteria);
		PageDTO pageDTO = new PageDTO(criteria, totalMovies);

		req.setAttribute("list", searchResults);
		req.setAttribute("pageDTO", pageDTO);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/movieDelete.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        
        try (BufferedReader br = req.getReader()) {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        //문자열 배열 변환
        String[] mnos = new Gson().fromJson(sb.toString(), String[].class);

        boolean result = true;
        //유효값 있을때 삭제
        if (mnos != null && mnos.length > 0) {
         try {
        	List<Long> moviemnos = Arrays.stream(mnos)
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        		MovieGenreService.getMovieGenreService();
        		result = movieService.removeAll(moviemnos);
         }catch (NumberFormatException e) {  
        	  log.error("Invalid mno format");
              result = false;
         	}
       } else {
            result = false;
        }
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(new Gson().toJson(result));
    }
}