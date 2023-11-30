package kr.co.mpago.controller.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.co.mpago.domain.Member;
import kr.co.mpago.domain.Rate;
import kr.co.mpago.service.MemberService;

@WebServlet("/member/profileModify")
public class profileModifyController extends HttpServlet {
    private final MemberService memberService = MemberService.getInstance();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = (Member) req.getSession().getAttribute("member");

        req.setAttribute("myMember", memberService.findBy(((Member) member).getUserid()));
        req.getRequestDispatcher("/WEB-INF/views/member/profileModify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = new BufferedReader(new InputStreamReader(req.getInputStream())).lines().collect(Collectors.joining());
        Member member = gson.fromJson(str, Member.class);

        boolean updateMember = memberService.modify(member);

        if (updateMember) {
            resp.setStatus(200); // 200 : 성공
            resp.getWriter().print(member.getNickname());
            
            req.getSession().setAttribute("member", member);
            resp.sendRedirect("/member/profileModify");
        } else {
            resp.setStatus(500); // 500 : 오류메세지
        }
    }
    
	// 닉네임 수정
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Member member = new Gson().fromJson(req.getReader(), Member.class);
	        boolean result = memberService.modify(member);
	        member = memberService.getByUserno(member.getUserno()+"");
	        
	        req.getSession().setAttribute("member", member);
			req.getSession().setAttribute("isAdmin", member.getIsAdmin());
	        req.getSession().setAttribute("nickname", member.getNickname());
	        
	        resp.setContentType("application/json");
	        resp.setCharacterEncoding("UTF-8");
	        //결과값 json으로 변환
	        resp.getWriter().write(new Gson().toJson(result));
	
	}
}
