package com.gt.controller;

import java.io.IOException;
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

@WebServlet("*.fboard")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FoodController() {
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
		FoodService service = new FoodServiceImpl();
		HttpSession session = request.getSession();

//////////////////////////////////////////////중식///////////////////////////////////////////////////////////////////
		// 글쓰기 화면에 처리
		if (command.equals("/cfboard/cfboard_write.fboard")) {
			request.setAttribute("member_id", session.getAttribute("member_id"));
			request.getRequestDispatcher("cfboard_write.jsp").forward(request, response);

			// 목록 화면에 처리
		} else if (command.equals("/cfboard/cfboard_list.fboard")) {

			request.setAttribute("food", request.getParameter("food"));
			// 목록을 가지고 나옴
			List<FoodVO> list = service.getList(request, response);
			request.setAttribute("list", list);

			request.getRequestDispatcher("cfboard_list.jsp").forward(request, response);

			// 등록 작업
		} else if (command.equals("/cfboard/registForm.fboard")) {
			request.setAttribute("food", request.getParameter("food"));
			service.regist(request, response);

			request.getRequestDispatcher("cfboard_list.fboard").forward(request, response);

			// 상세 화면
		} else if (command.equals("/cfboard/cfboard_content.fboard")) {
			// getContent : fno
			FoodVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("cfboard_content.jsp").forward(request, response);

			// 수정 화면
		} else if (command.equals("/cfboard/cfboard_modify.fboard")) {
			// getContent : fno
			FoodVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);

			request.getRequestDispatcher("cfboard_modify.jsp").forward(request, response);

			// 글 수정
		} else if (command.equals("/cfboard/cfboard_update.fboard")) {

			service.update(request, response);

			String fno = request.getParameter("fno");
			// 상세페이지로 이동
			response.sendRedirect("cfboard_content.fboard?fno=" + fno);

			// 글 삭제
		} else if (command.equals("/cfboard/cfboard_delete.fboard")) {

			request.setAttribute("food", request.getParameter("food"));
			service.delete(request, response);
			request.getRequestDispatcher("cfboard_list.fboard").forward(request, response);

		}
		// 검색기능
		else if (command.equals("/cfboard/cfboard_search.fboard")) {
			if(request.getParameter("choice").equals("search1")) {
				System.out.println("제목");
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("search", request.getParameter("search"));
				List<FoodVO> list = service.getSearchList(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("cfboard_search.jsp").forward(request, response);
			} else if(request.getParameter("choice").equals("search2")) {
				System.out.println("내용");
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("search", request.getParameter("search"));
				
				List<FoodVO> list = service.getSearch2List(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("cfboard_search.jsp").forward(request, response);
			}
		}
	

		// 조회수 증가
		else if (command.equals("/cfboard/cfboard_hitCount.fboard")) {

			service.hitCount(request, response);

			String fno = request.getParameter("fno");

			response.sendRedirect("cfboard_content.fboard?fno=" + fno);

		}

//////////////////////////////////////////////한식///////////////////////////////////////////////////////////////////

		// 글쓰기 화면에 처리
		if (command.equals("/kfboard/kfboard_write.fboard")) {
		    request.setAttribute("member_id", session.getAttribute("member_id"));
		    request.getRequestDispatcher("kfboard_write.jsp").forward(request, response);
		} 
		// 목록 화면에 처리
		else if (command.equals("/kfboard/kfboard_list.fboard")) {
		    request.setAttribute("food", request.getParameter("food")); // 목록을 가지고 나옴
		    List<FoodVO> list = service.getList(request, response);
		    request.setAttribute("list", list);
		    request.getRequestDispatcher("kfboard_list.jsp").forward(request, response);
		} 
		// 등록 작업
		else if (command.equals("/kfboard/registForm.fboard")) {
		    request.setAttribute("food", request.getParameter("food"));
		    service.regist(request, response);
		    request.getRequestDispatcher("kfboard_list.fboard").forward(request, response);
		} 
		// 상세 화면
		else if (command.equals("/kfboard/kfboard_content.fboard")) {
		    // getContent : fno
		    FoodVO vo = service.getContent(request, response);
		    request.setAttribute("vo", vo);
		    request.getRequestDispatcher("kfboard_content.jsp").forward(request, response);
		} 
		// 수정 화면
		else if (command.equals("/kfboard/kfboard_modify.fboard")) {
		    // getContent : fno
		    FoodVO vo = service.getContent(request, response);
		    request.setAttribute("vo", vo);
		    request.getRequestDispatcher("kfboard_modify.jsp").forward(request, response);
		} 
		// 글 수정
		else if (command.equals("/kfboard/kfboard_update.fboard")) {
		    service.update(request, response);
		    String fno = request.getParameter("fno"); // 상세페이지로 이동
		    response.sendRedirect("kfboard_content.fboard?fno=" + fno);
		} 
		// 글 삭제
		else if (command.equals("/kfboard/kfboard_delete.fboard")) {
		    request.setAttribute("food", request.getParameter("food"));
		    service.delete(request, response);
		    request.getRequestDispatcher("kfboard_list.fboard").forward(request, response);
		} 
		// 검색 기능
		else if (command.equals("/kfboard/kfboard_search.fboard")) {
			if(request.getParameter("choice").equals("search1")) {
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("search", request.getParameter("search"));
				List<FoodVO> list = service.getSearchList(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("kfboard_search.jsp").forward(request, response);
			} else if(request.getParameter("choice").equals("search2")) {
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("search", request.getParameter("search"));
				
				List<FoodVO> list = service.getSearch2List(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("kfboard_search.jsp").forward(request, response);
			}
		} 
		// 조회수 증가
		else if (command.equals("/kfboard/kfboard_hitCount.fboard")) {
		    service.hitCount(request, response);
		    String fno = request.getParameter("fno");
		    response.sendRedirect("kfboard_content.fboard?fno=" + fno);
		}

		
		
		

//////////////////////////////////////////////양식///////////////////////////////////////////////////////////////////
		 // 글쓰기 화면에 처리 
		if (command.equals("/wfboard/wfboard_write.fboard")) {
		 request.setAttribute("member_id", session.getAttribute("member_id"));
		 request.getRequestDispatcher("wfboard_write.jsp").forward(request, response);
		 
		 // 목록 화면에 처리 
		 } else if (command.equals("/wfboard/wfboard_list.fboard")) {
		 
		 request.setAttribute("food", request.getParameter("food")); // 목록을 가지고 나옴
		 List<FoodVO> list = service.getList(request, response);
		 request.setAttribute("list", list);
		  
		 request.getRequestDispatcher("wfboard_list.jsp").forward(request, response);
		 
		 // 등록 작업 
		 } else if (command.equals("/wfboard/registForm.fboard")) {
		 request.setAttribute("food", request.getParameter("food"));
		 service.regist(request, response);
		  
		 request.getRequestDispatcher("wfboard_list.fboard").forward(request,response);
		 
		 // 상세 화면 
		 } else if (command.equals("/wfboard/wfboard_content.fboard")) { //getContent : fno 
		FoodVO vo = service.getContent(request, response);
		 request.setAttribute("vo", vo);
		 request.getRequestDispatcher("wfboard_content.jsp").forward(request,response);
		 
		 // 수정 화면 
		 } else if (command.equals("/wfboard/wfboard_modify.fboard")) { //getContent : fno 
		FoodVO vo = service.getContent(request, response);
		 request.setAttribute("vo", vo);
		  
		 request.getRequestDispatcher("wfboard_modify.jsp").forward(request,response);
		  
		 // 글 수정 
		 } else if (command.equals("/wfboard/wfboard_update.fboard")) {
		  
		 service.update(request, response);
		 
		 String fno = request.getParameter("fno"); // 상세페이지로 이동
		 response.sendRedirect("wfboard_content.fboard?fno=" + fno);
		  
		 // 글 삭제 
		 } else if (command.equals("/wfboard/wfboard_delete.fboard")) {
		  
		 request.setAttribute("food", request.getParameter("food"));
		 service.delete(request, response);
		 request.getRequestDispatcher("wfboard_list.fboard").forward(request,response);
		 
		 } // 검색기능 
		else if (command.equals("/wfboard/wfboard_search.fboard")) {
			if(request.getParameter("choice").equals("search1")) {
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("search", request.getParameter("search"));
				List<FoodVO> list = service.getSearchList(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("wfboard_search.jsp").forward(request, response);
			} else if(request.getParameter("choice").equals("search2")) {
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("search", request.getParameter("search"));
				
				List<FoodVO> list = service.getSearch2List(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("wfboard_search.jsp").forward(request, response);
			}
		 }
		 
		 // 조회수 증가 
		else if (command.equals("/wfboard/wfboard_hitCount.fboard")) {
		  
		 service.hitCount(request, response);
		  
		 String fno = request.getParameter("fno");
		  
		 response.sendRedirect("wfboard_content.fboard?fno=" + fno);
		  
		 }
		 
//////////////////////////////////////////////일식///////////////////////////////////////////////////////////////////

		// 글쓰기 화면에 처리
		if (command.equals("/jfboard/jfboard_write.fboard")) {
			request.setAttribute("member_id", session.getAttribute("member_id"));
			request.getRequestDispatcher("jfboard_write.jsp").forward(request, response);

			// 목록 화면에 처리
		} else if (command.equals("/jfboard/jfboard_list.fboard")) {

			request.setAttribute("food", request.getParameter("food")); // 목록을 가지고 나옴
			List<FoodVO> list = service.getList(request, response);
			request.setAttribute("list", list);

			request.getRequestDispatcher("jfboard_list.jsp").forward(request, response);

			// 등록 작업
		} else if (command.equals("/jfboard/registForm.fboard")) {
			request.setAttribute("food", request.getParameter("food"));
			service.regist(request, response);

			request.getRequestDispatcher("jfboard_list.fboard").forward(request, response);

			// 상세 화면
		} else if (command.equals("/jfboard/jfboard_content.fboard")) { // getContent : fno
			FoodVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("jfboard_content.jsp").forward(request, response);

			// 수정 화면
		} else if (command.equals("/jfboard/jfboard_modify.fboard")) { // * getContent : fno
			FoodVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);

			request.getRequestDispatcher("jfboard_modify.jsp").forward(request, response);

			// 글 수정
		} else if (command.equals("/jfboard/jfboard_update.fboard")) {

			service.update(request, response);

			String fno = request.getParameter("fno"); // 상세페이지로 이동
			response.sendRedirect("jfboard_content.fboard?fno=" + fno);

			// 글 삭제
		} else if (command.equals("/jfboard/jfboard_delete.fboard")) {

			request.setAttribute("food", request.getParameter("food"));
			service.delete(request, response);
			request.getRequestDispatcher("jfboard_list.fboard").forward(request, response);

		}
		// 검색기능
		else if (command.equals("/jfboard/jfboard_search.fboard")) {
			if(request.getParameter("choice").equals("search1")) {
				System.out.println("제목");
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("search", request.getParameter("search"));
				List<FoodVO> list = service.getSearchList(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("jfboard_search.jsp").forward(request, response);
			} else if(request.getParameter("choice").equals("search2")) {
				System.out.println("내용");
				request.setAttribute("food", request.getParameter("food"));
				request.setAttribute("search", request.getParameter("search"));
				
				List<FoodVO> list = service.getSearch2List(request, response);
				request.setAttribute("list", list);
				request.getRequestDispatcher("jfboard_search.jsp").forward(request, response);
			}
		}
	

		// 조회수 증가
		else if (command.equals("/jfboard/jfboard_hitCount.fboard")) {

			service.hitCount(request, response);

			String fno = request.getParameter("fno");

			response.sendRedirect("jfboard_content.fboard?fno=" + fno);

		}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	}

}
