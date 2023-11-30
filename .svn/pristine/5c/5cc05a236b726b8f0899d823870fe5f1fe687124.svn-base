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

@WebServlet("/customer/write")
public class NoticeWrite extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   // 요청 본문 읽기
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = req.getReader().readLine()) != null) {
            sb.append(line);
        }

        // JSON 파싱
        JsonObject jsonObject = JsonParser.parseString(sb.toString()).getAsJsonObject();
        String title = jsonObject.get("title").getAsString();
        String content = jsonObject.get("content").getAsString();

        // 세션에서 nickname 가져오기
        String nickname = (String) req.getSession().getAttribute("nickname");
        // 세션에서 nickname 가져오기
        Boolean isAdmin = (Boolean) req.getSession().getAttribute("isAdmin");
        if (nickname == null || isAdmin == null) {
            resp.sendRedirect("/error");
            return;
        }


        if (Boolean.TRUE.equals(isAdmin)) {
            CustomerService.getInstance().addNotice(nickname, title, content, isAdmin.toString());
            resp.sendRedirect("/customer");
        } else {
            resp.sendRedirect("/error");
        }
    }
}
