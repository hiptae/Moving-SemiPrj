package kr.co.mpago.controller.cs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.mpago.domain.Member;
import kr.co.mpago.domain.Notice;
import kr.co.mpago.service.CustomerService;
@WebServlet("/customer")
public class CustomerServiceController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    // 공지사항 리스트 가져오기
	    List<Notice> notices = CustomerService.getInstance().getNotices();  
	    req.setAttribute("notices", notices);  

	    // 세션에서 nickname과 member 가져오기
	    String nickname = (String) req.getSession().getAttribute("nickname");
	    Member mem = (Member) req.getSession().getAttribute("member");


	    req.getRequestDispatcher("/WEB-INF/views/cs/customer.jsp").forward(req, resp);
		}
}