package com.gt.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({ "/rvboard/rvboard_list.rvboard",
	         "/member/member_mypage.member",
	         "/member/member_modify.member",
	         "/member/member_update.member"})
public class MemberAuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 한글처리
		request.setCharacterEncoding("utf-8");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		 //세션을 얻음
		 HttpSession session = req.getSession();
		 //회원이 로그인할 때 저장한 인증값
		 String id = (String) session.getAttribute("member_id");
		 
		 //로그인이 안됨
		 if(id == null) {
			 String path = req.getContextPath() + "/member/member_login.member";
			// res.sendRedirect(path);
			 
			 response.setContentType("text/html; charset=UTF-8;");
			 PrintWriter out = res.getWriter();
			 out.println("<script>");
			 out.println("alert('로그인 후 이용해주세요');");
			 out.println("location.href='"+ path +"';");
			 out.println("</script>");
			 return; //필터 종료
		 }
			
			//다음 코드를 실행하거나 필터를 실행함
			chain.doFilter(request, response);
	}

}
