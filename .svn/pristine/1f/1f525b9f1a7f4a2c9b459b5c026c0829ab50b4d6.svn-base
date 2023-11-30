package kr.co.mpago.controller.msg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.domain.Member;
import kr.co.mpago.domain.Msg;
import kr.co.mpago.service.MsgService;
import kr.co.mpago.util.WebUtils;


@WebServlet("/message")
public class Message extends HttpServlet{
	private MsgService msgService = MsgService.getMsgService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 정보
		Member mem = (Member) req.getSession().getAttribute("member");
		
		// 받은쪽지함
		req.setAttribute("receiList", msgService.getReceiMsg(mem.getNickname()));
		
		// 보낸쪽지함
		req.setAttribute("sendList", msgService.getSendMsg(mem.getNickname()));
		req.getRequestDispatcher("/WEB-INF/views/message/msgMain.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String fromnick	= req.getParameter("fromnick");
		String tonick	= req.getParameter("tonick");
	
		// 쪽지 전송
		Msg msg = Msg.builder().title(title).content(content).fromnick(fromnick).tonick(tonick).build();
		msgService.send(msg);
		WebUtils.alert(resp, "쪽지를 전송했습니다.", "/message");
	}
	
}
