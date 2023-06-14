package com.gt.food.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gt.food.model.FoodVO;

public interface FoodService {
	void regist(HttpServletRequest request, HttpServletResponse response);
	List<FoodVO> getList(HttpServletRequest request, HttpServletResponse response); //글목록
	FoodVO getContent(HttpServletRequest request, HttpServletResponse response); //글상세 
	void update(HttpServletRequest request, HttpServletResponse response); //글수정
	void delete(HttpServletRequest request, HttpServletResponse response); //글삭제
	List<FoodVO> getSearchList(HttpServletRequest request, HttpServletResponse response); //글검색
	void hitCount(HttpServletRequest request, HttpServletResponse response);//조회수 증가
	List<FoodVO> getJMTList(HttpServletRequest request, HttpServletResponse response); 

}
