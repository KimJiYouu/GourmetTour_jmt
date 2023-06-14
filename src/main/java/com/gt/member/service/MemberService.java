package com.gt.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gt.member.model.MemberVO;


public interface MemberService {
	
	/*회원가입*/
	int join(HttpServletRequest request, HttpServletResponse response);
	/*로그인*/
	MemberVO login(HttpServletRequest request, HttpServletResponse response);
	/*회원정보 저장*/
	MemberVO getInfo(HttpServletRequest request, HttpServletResponse response);
	/*정보수정*/
	int updateInfo(HttpServletRequest request, HttpServletResponse response);
	/*회원탈퇴*/
	int deleteMember(HttpServletRequest request, HttpServletResponse response);
}
