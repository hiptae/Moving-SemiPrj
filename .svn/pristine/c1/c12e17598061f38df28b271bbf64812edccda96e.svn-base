package kr.co.mpago.controller.member;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.util.MailUtils;

@WebServlet("/member/emailverify")
public class EmailVerify extends HttpServlet {
	private MailUtils mail = new MailUtils();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String veriCode = req.getParameter("vericode");
		// 이메일 인증요청 클릭시 이메일 발송
		if(veriCode == null) {
			try {
				// 이메일 발송
				mail.sendEmail(email);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 인증코드 입력시 일치하면 true
		String codever = null;
		codever = mail.codeVeri;
		System.out.println("인증메일 : " + mail.codeVeri);
		if(codever.equals(veriCode)) {
			resp.setContentType("application/json");
			resp.getWriter().write("{\"available\":" + true + "}");
		}
	}

}
