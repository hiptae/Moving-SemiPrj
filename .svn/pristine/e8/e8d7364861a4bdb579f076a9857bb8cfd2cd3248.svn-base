package kr.co.mpago.controller.msg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.service.MemberService;

@WebServlet("/message/memberCheck")
public class MsgNickCheck extends HttpServlet{
	private MemberService memberService = MemberService.getInstance();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String tonick = req.getParameter("tonick");
		
		// 쪽지 작성시 받는 회원유무 확인
		int cnt = memberService.nickCheck(tonick);
		
		resp.setContentType("application/json");
		resp.getWriter().write("{\"available\":" + cnt + "}");
	}

}
