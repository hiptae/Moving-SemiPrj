package kr.co.mpago.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.service.MemberService;

@WebServlet("/member/duplcheck")
public class DuplCheck extends HttpServlet{
	MemberService memberService = MemberService.getInstance();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cnt = 0;
		String id = req.getParameter("userid");
		String email = req.getParameter("email");
		String nick = req.getParameter("nickname");
		
		
		// 중복체크 중복일시 cnt = 1 아닐떄 0
		// 아이디 중복체크
		if(id != null) {
			cnt = memberService.idCheck(id);
		}
		// 닉네임 중복체크
		if(nick != null) {
			cnt = memberService.nickCheck(nick);
		}
		// 이메일 중복체크
		if(email != null) {
			cnt = memberService.emailCheck(email);
		}
        resp.setContentType("application/json");
		resp.getWriter().write("{\"available\":" + cnt + "}");
	}

}
