package kr.co.mpago.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import kr.co.mpago.service.BoardCategoryService;

@WebFilter("/*")
public class BoardCategoryFilter implements Filter {
	private BoardCategoryService boardcategory = new BoardCategoryService();
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setAttribute("categories", boardcategory.getList());
		chain.doFilter(request, response);
	}
}

