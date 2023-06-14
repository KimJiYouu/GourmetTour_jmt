package com.gt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gt.comments.model.CommentsVO;
import com.gt.rvboard.model.RvboardVO;
import com.gt.rvboard.service.RvboardService;
import com.gt.rvboard.service.RvboardServiceImpl;

@WebServlet("*.rvboard")
public class RvboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RvboardController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 한글처리
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println(command);

		// 게시글 서비스 선언
		RvboardService service = new RvboardServiceImpl();
		HttpSession session = request.getSession();

		// 글쓰기 화면에 처리
		if (command.equals("/rvboard/rvboard_write.rvboard")) {
			request.setAttribute("member_id", session.getAttribute("member_id"));
			request.getRequestDispatcher("rvboard_write.jsp").forward(request, response);

			// 목록 화면에 처리
		} else if (command.equals("/rvboard/rvboard_list.rvboard")) {


				// 목록을 가지고 나옴
				List<RvboardVO> list = service.getList(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("rvboard_list.jsp").forward(request, response);

			// 등록 작업
		} else if (command.equals("/rvboard/registForm.rvboard")) {
			
			if(request.getParameter("title").equals("") || request.getParameter("writing").equals("")) {
				response.sendRedirect("rvboard_write.rvboard");
			} else {

			service.regist(request, response);
			response.setContentType("text/html; charset=utf-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글이 등록되었습니다.')");
			out.println("location.href='rvboard_list.rvboard';");
			out.println("</script>");
			}

			// 상세 화면
		} else if (command.equals("/rvboard/rvboard_content.rvboard")) {
			// getContent : bno
			service.hitCount(request, response);
			request.setAttribute("bno", request.getParameter("bno"));
			RvboardVO vo = service.getContent(request, response);
			List<CommentsVO> clist = service.getComList(request, response);
			request.setAttribute("clist", clist);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("rvboard_content.jsp").forward(request, response);

			// 수정 화면
		} else if (command.equals("/rvboard/rvboard_modify.rvboard")) {
			// getContent : bno
			RvboardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);

			request.getRequestDispatcher("rvboard_modify.jsp").forward(request, response);

			// 글 수정
		} else if (command.equals("/rvboard/rvboard_update.rvboard")) {

			service.update(request, response);

			String bno = request.getParameter("bno");
			// 상세페이지로 이동
			response.sendRedirect("rvboard_content.rvboard?bno=" + bno);

			// 글 삭제
		} else if (command.equals("/rvboard/rvboard_delete.rvboard")) {

			service.delete(request, response);
			response.setContentType("text/html; charset=utf-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('해당 글이 삭제되었습니다.')");
			out.println("location.href='rvboard_list.rvboard';");
			out.println("</script>");
		}
		// 검색기능
		else if (command.equals("/rvboard/rvboard_search.rvboard")) {
			
			if(request.getParameter("choice").equals("search1")) {
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("search", request.getParameter("search"));
				List<RvboardVO> list = service.getSearchList(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("rvboard_search.jsp").forward(request, response);
			} else if(request.getParameter("choice").equals("search2")) {
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("search", request.getParameter("search"));
				
				List<RvboardVO> list = service.getSearch2List(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("rvboard_search.jsp").forward(request, response);
			}
		}

		// 댓글기능
		else if (command.equals("/rvboard/comment.rvboard")) {
			if(!request.getParameter("comment").equals("")) {
				
				service.comregist(request, response);
				List<CommentsVO> clist = service.getComList(request, response);
				request.setAttribute("clist", clist);
				RvboardVO vo = service.getContent(request, response);
				request.setAttribute("vo", vo);
				request.getRequestDispatcher("rvboard_content.jsp").forward(request, response);
				// 목록에 추가하는 기능으로..?
				// 상세페이지로 이동
			} else {
				List<CommentsVO> clist = service.getComList(request, response);
				request.setAttribute("clist", clist);
				RvboardVO vo = service.getContent(request, response);
				request.setAttribute("vo", vo);
				request.getRequestDispatcher("rvboard_content.jsp").forward(request, response);
				
			}
		}

		// 댓글삭제

		else if(command.equals("/rvboard/deleteCom.rvboard")) {

			service.deleteCom(request, response); String bno =
					request.getParameter("bno"); //상세페이지로 이동
			response.sendRedirect("rvboard_content.rvboard?bno=" + bno ); 
		}
		


	}
}