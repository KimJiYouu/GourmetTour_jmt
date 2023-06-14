package com.gt.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gt.member.model.MemberDAO;
import com.gt.member.model.MemberVO;



public class MemberServiceImpl implements MemberService{

	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String food = request.getParameter("food");
		
		//아이디 중복 검사
		//싱글톤 객체를 얻는 방법
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.idCheck(id);
		
		if(result == 1) { //중복
			return 1;
		} else { //가입처리
			MemberVO vo =  new MemberVO(id, pw, name, email, gender, food, null); 
			dao.join(vo);
			return 0;
		}
	}

	@Override
	public MemberVO login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//로그인
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.login(id, pw);
		
		return vo;
	}

	@Override
	public MemberVO getInfo(HttpServletRequest request, HttpServletResponse response) {
		//회원아이디 - 이전화면에서 필요한 값을 넘겨주기 VS 세션에 기록된 회원아이디를 반환받기
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("member_id");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.getInfo(id);
				
		return vo;
	}

	@Override
	public int updateInfo(HttpServletRequest request, HttpServletResponse response) {
		int result;
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		vo.setGender(request.getParameter("gender"));
		vo.setFood(request.getParameter("food"));
		
		result = dao.updateInfo(vo);
		
		return result;
	}

	@Override
	public int deleteMember(HttpServletRequest request, HttpServletResponse response) {
		int result;
		MemberDAO dao = MemberDAO.getInstance();
		result = dao.deleteMember(request.getParameter("id"));
		
		return result;
		
	}

}
