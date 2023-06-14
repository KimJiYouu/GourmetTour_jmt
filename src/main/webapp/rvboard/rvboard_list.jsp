<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="box">
		<div class="container">
			<h2 style="font-family: 'Charmonman', cursive;">Community</h2>
			<br>
			<table class="table table-hover" style="width: 95%">
				<thead>
					<tr>
						<th>번호</th>
						<th style="width: 17%">작성자</th>
						<th style="width: 50%" align="center">제목</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list }" varStatus="x">
						<tr>
							<td>${fn:length(list) - x.index}</td>
							<td style="width: 17%">${vo.id }</td>
							<td style="width: 50%"><a href="rvboard_content.rvboard?bno=${vo.bno }" onclick="location.href='rvboard_hitCount.rvboard?bno=${vo.bno}'">${vo.title }</a></td>
							<td><fmt:formatDate value="${vo.regdate }"
									pattern="yyyy-MM-dd (E) hh시mm분" /></td>
							<td>${vo.hit }</td>
						</tr>
					</c:forEach>
				</tbody>
				<tbody>
					<tr>
						<td colspan="6" align="center">
							<form action="rvboard_search.rvboard" class="form-inline">
								<div class="form-group">
									<input type="text" name="search" placeholder="제목검색"
										class="form-control"> <input type="submit" value="검색"
										class="btn btn-default"> <input type="button"
										value="글 작성" class="btn btn-default"
										onclick="location.href='rvboard_write.rvboard'">
								</div>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>






