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

import com.gt.food.model.FoodVO;
import com.gt.food.service.FoodService;
import com.gt.food.service.FoodServiceImpl;
import com.gt.member.model.MemberVO;
import com.gt.member.service.MemberService;
import com.gt.member.service.MemberServiceImpl;
import com.gt.rvboard.model.RvboardVO;
import com.gt.rvboard.service.RvboardService;
import com.gt.rvboard.service.RvboardServiceImpl;

@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
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

		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println(command);

		MemberService service = new MemberServiceImpl();
		HttpSession session = request.getSession();

		//회원가입 페이지 연결
		if (command.equals("/member/member_join.member")) {
			request.getRequestDispatcher("member_join.jsp").forward(request, response);

		} 
		//로그인 페이지 연결
		else if (command.equals("/member/member_login.member")) {
			request.getRequestDispatcher("member_login.jsp").forward(request, response);
		}
		// 마이페이지 연결
	      else if (command.equals("/member/member_mypage.member")) {
	         
	         //마이페이지에서 글 리스트 보여주기
	         RvboardService service2 = new RvboardServiceImpl();
	         List<RvboardVO> list = service2.getMyList(request, response);
	         request.setAttribute("list", list);
	         
	         //마이페이지 JMT
	         FoodService service3 = new FoodServiceImpl();
	         List<FoodVO> list2 = service3.getJMTList(request, response);
	         request.setAttribute("list2", list2);
	         request.getRequestDispatcher("member_mypage.jsp").forward(request, response);
	      }

		
		// 회원가입 요청
		else if (command.equals("/member/joinForm.member")) { // user_join 페이지에서 submit하면 도착하는 주소

			// 가입
			int result = service.join(request, response);

			if (result == 1) { // 중복

				request.setAttribute("msg", "중복된 아이디입니다");
				request.getRequestDispatcher("member_join.jsp").forward(request, response);
			} else { // 가입성공
				response.setContentType("text/html; charset=utf-8;");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원가입이 완료되었습니다.')");
				out.println("location.href='member_login.member';");
				out.println("</script>");
			}

		}
		// 로그인
		else if (command.equals("/member/loginForm.member")) {
			MemberVO vo = service.login(request, response);

			if (vo == null) { // 로그인 실패
				request.setAttribute("msg", "아이디와 비밀번호가 맞지 않습니다.");
				request.getRequestDispatcher("member_login.jsp").forward(request, response);
			} else { // 로그인 성공
				// 세션에 회원정보 저장 (자바에서 세션을 얻는 방법)
				session.setAttribute("member_id", vo.getId());
	            session.setAttribute("member_name", vo.getName());
	            session.setAttribute("member_email", vo.getEmail());
	            session.setAttribute("member_gender", vo.getGender());
	            session.setAttribute("member_food", vo.getFood());
	            session.setAttribute("member_regdate", vo.getRegdate());

				response.sendRedirect("member_mypage.member");
			}
		}
		//로그아웃
		else if(command.equals("/member/member_logout.member")) {
			session.invalidate();
			response.sendRedirect("../index.jsp");
		}
		//회원정보 수정페이지
		else if(command.equals("/member/member_modify.member")) {
			MemberVO vo = service.getInfo(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("member_modify.jsp").forward(request, response);
		}
		//정보수정
		else if(command.equals("/member/member_update.member")) {
			int result = service.updateInfo(request, response);
			if(result == 1) {
				session.setAttribute("member_name", request.getParameter("name"));
				session.setAttribute("member_email", request.getParameter("email"));
				session.setAttribute("member_gender", request.getParameter("gender"));
				session.setAttribute("member_food", request.getParameter("food"));
				response.sendRedirect("member_mypage.member");
				
			} else {
				response.sendRedirect("member_modify.member");
			}
		}
		//회원탈퇴
		else if(command.equals("/member/member_delete.member")) {
			
			int result = service.deleteMember(request, response);
			if(result == 1) {
			session.invalidate();
			response.setContentType("text/html; charset=utf-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('탈퇴되었습니다. 다음에 만나요')");
			out.println("location.href='../index.jsp';");
			out.println("</script>");
			} else {
				response.sendRedirect("member_mypage.member");
			}
		}

	}
}
