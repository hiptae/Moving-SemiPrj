package kr.co.mpago.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.domain.Criteria;
import kr.co.mpago.domain.Movie;
import kr.co.mpago.domain.PageDTO;
import kr.co.mpago.service.MovieService;
import lombok.extern.log4j.Log4j;

@WebServlet("/admin/movie/list")
@Log4j
public class AdminMovieList extends HttpServlet{
	MovieService movieService = MovieService.getMovieService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 사용자 입력을 받아옴
				String keyword = (req.getParameter("keyword") == null) ? "" : req.getParameter("keyword");
				String pageNumParam = req.getParameter("pageNum");
				
				// 기본 페이지 번호는 1로 설정
				int pageNum = 1;
				if (pageNumParam != null && !pageNumParam.isEmpty()) {
					try {
						pageNum = Integer.parseInt(pageNumParam);
					} catch (NumberFormatException e) {
						log.error("잘못된 페이지 번호 형식입니다. 기본 페이지 번호를 1로 설정합니다.");
					}
				}

				// 페이지당 표시할 회원 수
				int amount = 15; 
				Criteria criteria = Criteria.builder()
									.pageNum(pageNum)
									.amount(amount)
									.keyword(keyword)
									.build();
				
				// 페이징과 검색 조건을 이용하여 회원 목록을 가져옴
				List<Movie> searchResults = movieService.getMovieList(criteria);

				// 전체 회원 수를 가져옴
				int totalMovies = movieService.findTotal(criteria);

				// 페이징 정보 생성
				PageDTO pageDTO = new PageDTO(criteria, totalMovies);

				// 검색 결과와 페이징 정보를 request에 저장
				req.setAttribute("list", searchResults);
				req.setAttribute("pageDTO", pageDTO);
				
				req.getRequestDispatcher("/WEB-INF/views/admin/movieList.jsp").forward(req, resp);
			}
}
