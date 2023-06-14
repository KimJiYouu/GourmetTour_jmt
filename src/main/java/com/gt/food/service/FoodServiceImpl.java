package com.gt.food.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gt.food.model.FoodDAO;
import com.gt.food.model.FoodVO;

public class FoodServiceImpl implements FoodService{
	// 글 등록
	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		// title, writer, content
		String id = request.getParameter("id");
		String food = request.getParameter("food");
		String title = request.getParameter("title");
		String region = request.getParameter("region");
		String open = request.getParameter("open");
		String address = request.getParameter("address");
		String writing = request.getParameter("writing");

		FoodDAO dao = FoodDAO.getInstance();
		dao.regist(id, food, title, writing, region, address, open);

	}

	//글 목록
	@Override
	public List<FoodVO> getList(HttpServletRequest request, HttpServletResponse response) {
		FoodDAO dao = FoodDAO.getInstance();
		String food = request.getParameter("food");
		List<FoodVO> list = dao.getList(food);
		System.out.println(food);
		return list;
	}

	//글 상세페이지
	@Override
	public FoodVO getContent(HttpServletRequest request, HttpServletResponse response) {
		String fno = request.getParameter("fno");

		FoodDAO dao = FoodDAO.getInstance();
		FoodVO vo = dao.getContent(fno);

		return vo;
	}

	//글 수정
	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		String fno = request.getParameter("fno");
		String region = request.getParameter("region");
		String title = request.getParameter("title");
		String open = request.getParameter("open");
		String address = request.getParameter("address");
		String writing = request.getParameter("writing");

		FoodDAO dao = FoodDAO.getInstance();
		dao.update(fno, region, title, writing, address, open);

	}

	//글 삭제
	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String fno = request.getParameter("fno");

		FoodDAO dao = FoodDAO.getInstance();
		dao.delete(fno);

	}

	//글 검색
	@Override
	public List<FoodVO> getSearchList(HttpServletRequest request, HttpServletResponse response) {
		String food = (String) request.getAttribute("food");
		List<FoodVO> list = new ArrayList<>(); 
		String search = request.getParameter("search");
		FoodDAO dao = FoodDAO.getInstance();
		if(!search.equals("")) {
			for(FoodVO v : dao.getList(food)) {
				if(v.getTitle().contains(search)) {
					list.add(v);
				}
			}
			return list;
		} else {
			return list;
		}
	}
	public List<FoodVO> getSearch2List(HttpServletRequest request, HttpServletResponse response) {
		String food = (String) request.getAttribute("food");
		List<FoodVO> list = new ArrayList<>(); 
		String search = request.getParameter("search");
		System.out.println(search);
		FoodDAO dao = FoodDAO.getInstance();
		if(!search.equals("")) {
			for(FoodVO v : dao.getList(food)) {
				if(v.getWriting().contains(search)) {
					list.add(v);
				}
			}
			return list;
		} else {
			return list;
		}
	}

	@Override
	public void hitCount(HttpServletRequest request, HttpServletResponse response) {
	String fno = request.getParameter("fno");
		
	    FoodDAO dao = FoodDAO.getInstance();
		dao.hitCount(fno);
		
	}
	
	public List<FoodVO> getJMTList(HttpServletRequest request, HttpServletResponse response) {
	      HttpSession session = request.getSession();
	      String id = (String) session.getAttribute("member_id");
	      FoodDAO dao = FoodDAO.getInstance();
	      List<FoodVO> list = dao.getJMTList(id);
	      
	      return list;
	   }

	@Override
	public void FBDelete(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		FoodDAO dao = FoodDAO.getInstance();
		dao.FBDelete(id);
		
	}
}
