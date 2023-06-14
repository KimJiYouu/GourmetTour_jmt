package com.gt.rvboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gt.comments.model.CommentsDAO;
import com.gt.comments.model.CommentsVO;
import com.gt.rvboard.model.RvboardDAO;
import com.gt.rvboard.model.RvboardVO;

public class RvboardServiceImpl implements RvboardService {

	// 글 등록
	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		// title, writer, content
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String writing = request.getParameter("writing");

		RvboardDAO dao = RvboardDAO.getInstance();
		dao.regist(id, title, writing);

	}

	//글 목록
	@Override
	public List<RvboardVO> getList(HttpServletRequest request, HttpServletResponse response) {
		RvboardDAO dao = RvboardDAO.getInstance();
		List<RvboardVO> list = dao.getList();

		return list;
	}

	//글 상세페이지
	@Override
	public RvboardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");

		RvboardDAO dao = RvboardDAO.getInstance();
		RvboardVO vo = dao.getContent(bno);

		return vo;
	}

	//글 수정
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String writing = request.getParameter("writing");

		RvboardDAO dao = RvboardDAO.getInstance();
		dao.update(bno, title, writing);

	}

	//글 삭제
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");

		RvboardDAO dao = RvboardDAO.getInstance();
		dao.delete(bno);

	}

	//글 검색
	@Override
	public List<RvboardVO> getSearchList(HttpServletRequest request, HttpServletResponse response) {
		List<RvboardVO> list = new ArrayList<>(); 
		String search = request.getParameter("search");
		RvboardDAO dao = RvboardDAO.getInstance();
		if(!search.equals("")) {
			for(RvboardVO v : dao.getList()) {
				if(v.getTitle().contains(search)) {
					list.add(v);
				}
			}
			return list;
		} else {
			return list;
		}
	}

	//댓 등록
	@Override
	public void comregist(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String comment_text = request.getParameter("comment");
		String bno = request.getParameter("bno");

		CommentsDAO dao = CommentsDAO.getInstance();
		dao.comregist(id, comment_text, bno);


	}

	//댓 목록
	@Override
	public List<CommentsVO> getComList(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");
		CommentsDAO dao = CommentsDAO.getInstance();
		List<CommentsVO> clist = dao.getComList(bno);


		return clist;
	}

	//댓 삭제
	@Override
	public void deleteCom(HttpServletRequest request, HttpServletResponse response) {
		String cno = request.getParameter("cno");
		CommentsDAO dao = CommentsDAO.getInstance();
		dao.deleteCom(cno);
	}

	//조회수증가
	public void hitCount(HttpServletRequest request, HttpServletResponse response) {
		String bno = request.getParameter("bno");

		RvboardDAO dao = RvboardDAO.getInstance();
		dao.hitCount(bno);

	}

	//내가 쓴 글목록
	@Override
	public List<RvboardVO> getMyList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("member_id");
		
		RvboardDAO dao = RvboardDAO.getInstance();
		List<RvboardVO> list = dao.getMyList(id);
		
		return list;

	}



}
