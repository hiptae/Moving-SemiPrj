package kr.co.mpago.controller.board;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mpago.domain.Board;
import kr.co.mpago.domain.Criteria;
import kr.co.mpago.service.BoardService;
import kr.co.mpago.util.WebUtils;
import lombok.extern.log4j.Log4j;

@Log4j
@WebServlet("/board/register")
public class Register extends HttpServlet{
	private BoardService boardService = BoardService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cate = req.getParameter("category");
		String pageNum = req.getParameter("pageNum");
		String amount = req.getParameter("amount");
		String type = req.getParameter("type");
		String keyword = req.getParameter("keyword");
		
		Criteria.CriteriaBuilder cb = Criteria.builder();
		if(cate != null) {
			cb.category(Integer.parseInt(cate));
		}
		if(pageNum != null) {
			cb.pageNum(Integer.parseInt(pageNum));
		}
		if(amount != null) {
			cb.amount(Integer.parseInt(amount));
		}
		if(type != null) {
			cb.type(type);
		}
		if(keyword != null) {
			cb.keyword(keyword);
		}
		
		Criteria criteria = cb.build();

		if(WebUtils.getMember(req) == null) {
			WebUtils.alert(resp, "로그인 후 사용할 수 있습니다.", req.getContextPath() + "/member/signin?href=" + URLEncoder.encode("/board/register?" + criteria.getLink(), "utf-8"));	
			return;                                                                     
		}
		req.setAttribute("cri", criteria);
		req.getRequestDispatcher("/WEB-INF/views/board/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			Board.BoardBuilder bb = Board.builder();
			Criteria.CriteriaBuilder cb = Criteria.builder();
			String userno = req.getParameter("userno");
		    String bcate = req.getParameter("category");
		    String title = req.getParameter("title");
		    String content = req.getParameter("content");	
		    if (userno != null && !userno.isEmpty()) {
		        try {
		            Long userId = Long.valueOf(userno);
		            bb.userno(userId);
		        } catch (NumberFormatException e) {
		            return;
		        }
		    }
		    if (bcate != null && !bcate.isEmpty()) {
		        try {
		            Long bcateValue = Long.valueOf(bcate);
		            bb.bcate(bcateValue);
		            cb.category(bcateValue.intValue());
		        } catch (NumberFormatException e) {
		            return;
		        }
		    }
		    if(title != null && !title.isEmpty()) {
		    	bb.title(title);
		    }else {
		    	 WebUtils.alertBack(resp, "제목을 입력해주세요");
		    	 return;
			}
		    if(content != null && !content.isEmpty()) {
		    	bb.content(content);
		    }else {
		    	 WebUtils.alertBack(resp, "내용을 입력해주세요");
		    	 return;
			}
		    
		Criteria criteria = cb.build();
	    Board board = bb.category(criteria.getCategory()).build();
	    boardService.insert(board);
	
    	req.setAttribute("criteria", criteria);
		WebUtils.alert(resp, "글 작성에 성공했습니다", req.getContextPath() + "/board/list?" + criteria.getLink());
		return;
	}
}
		