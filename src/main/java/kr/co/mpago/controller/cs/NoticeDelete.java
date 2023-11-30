package kr.co.mpago.controller.cs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.mpago.service.CustomerService;

@WebServlet("/customer/delete")
public class NoticeDelete extends HttpServlet{
	 	@Override
	    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        // 요청 본문 읽기
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = req.getReader().readLine()) != null) {
	            sb.append(line);
	        }

	        // JSON 파싱
	        JsonObject jsonObject = JsonParser.parseString(sb.toString()).getAsJsonObject();
	        Long bno = jsonObject.get("bno").getAsLong();

	        // 세션에서 nickname 가져오기
	        String nickname = (String) req.getSession().getAttribute("nickname");

	        if (nickname == null) {
	            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	            return;
	        }

	        Boolean isAdmin = (Boolean) req.getSession().getAttribute("isAdmin");

	        if (Boolean.TRUE.equals(isAdmin)) {
	            CustomerService.getInstance().delete(bno);
	            resp.setStatus(HttpServletResponse.SC_OK);
	        } else {
	            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
	        }
	    }
	}
