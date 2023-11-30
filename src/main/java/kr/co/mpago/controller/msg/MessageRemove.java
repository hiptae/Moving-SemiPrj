package kr.co.mpago.controller.msg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.service.MsgService;

@WebServlet("/message/remove")
public class MessageRemove extends HttpServlet{
	private MsgService msgService = MsgService.getMsgService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 단일수집
		String msgno = req.getParameter("msgno");
		/**
		 * 배열수집
		 * 논리삭제를 위한 받은쪽지함, 보낸쪽지함 구분
		 */
		String[] receiveMsgnos = req.getParameterValues("receiveMsgnos");
		String[] sendMsgnos = req.getParameterValues("sendMsgnos");
		
		// 단일 삭제
		if(msgno != null) {
			msgService.remove(Long.valueOf(msgno));
		}
		
		// 일괄삭제
		if(receiveMsgnos != null) {
			for(String m : receiveMsgnos) {
				System.out.println(m);
				msgService.deleteReceivedMsg(Long.valueOf(m));
			}
		}
		else {
			for(String m : sendMsgnos) {
				System.out.println(m);
				msgService.deleteSendedsdMsg(Long.valueOf(m));
			}
		}
		
	}

}
