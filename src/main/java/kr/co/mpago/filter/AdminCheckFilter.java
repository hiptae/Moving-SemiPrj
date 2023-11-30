package kr.co.mpago.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mpago.domain.Member;

@WebFilter("/admin/*")
public class AdminCheckFilter implements Filter{

	@Override
	 public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp; 
        HttpSession session = request.getSession();
        System.out.println(session);
        System.out.println(session.getId());
        if (session.getAttribute("member") == null || !((Member)session.getAttribute("member")).getIsAdmin()) {
            // 유저는 홈 페이지로 리다이렉트
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            // 관리자는 관리자페이지로 진행
            chain.doFilter(req, resp);
        }
    }
}