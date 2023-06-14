package com.gt.rvboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gt.comments.model.CommentsVO;
import com.gt.rvboard.model.RvboardVO;

public interface RvboardService {

	void regist(HttpServletRequest request, HttpServletResponse response); //글등록
	List<RvboardVO> getList(HttpServletRequest request, HttpServletResponse response); //글목록
	RvboardVO getContent(HttpServletRequest request, HttpServletResponse response); //글상세 
	void update(HttpServletRequest request, HttpServletResponse response); //글수정
	void delete(HttpServletRequest request, HttpServletResponse response); //글삭제
	List<RvboardVO> getSearchList(HttpServletRequest request, HttpServletResponse response); //글검색
	void hitCount(HttpServletRequest request, HttpServletResponse response);//조회수 증가
	List<RvboardVO> getMyList(HttpServletRequest request, HttpServletResponse response); //내가 쓴 글목록
	
	void comregist(HttpServletRequest request, HttpServletResponse response); //댓등록
	List<CommentsVO> getComList(HttpServletRequest request, HttpServletResponse response); //댓 목록
	void deleteCom(HttpServletRequest request, HttpServletResponse response);//댓 삭제
	void RBDelete(HttpServletRequest request, HttpServletResponse response);//유저 삭제시 삭제

}
