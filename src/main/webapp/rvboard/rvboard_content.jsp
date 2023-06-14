<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="box">
		<div class="container">
			<h2>${vo.title }</h2>
			<br>
			<table class="table" style="width: 95%">

				<tr>
					<th style="width: 10%">글번호</th>
					<td>${vo.bno }</td>

					<th style="width: 10%">조회수</th>
					<td>${vo.hit }</td>

				</tr>
				<tr>
					<th style="width: 10%">작성자</th>
					<td>${vo.id }</td>

					<th style="width: 10%">작성일</th>
					<td><fmt:formatDate value="${vo.regdate }"
							pattern="yyyy-MM-dd(E)" /></td>

				</tr>

				<tr>
					<th style="width: 10%">글 내용</th>
					<td colspan="3" height="200px">${vo.writing }</td>


				</tr>

				<tbody>
					<tr>
						<td colspan="6" align="center">

							<div class="form-group">
								<c:choose>
									<c:when test="${sessionScope.member_id == vo.id }">
										<!-- 로그인된 아이디와 글작성한 아이디가 같을 때 -->
										<button type="button" class="btn btn-default"
											onclick="location.href='rvboard_list.rvboard'">목록</button>
										<button type="button" class="btn btn-default"
											onclick="location.href='rvboard_modify.rvboard?bno=${vo.bno}'">수정</button>
										<button type="button" class="btn btn-default"
											onclick="location.href='rvboard_delete.rvboard?bno=${vo.bno}'">삭제</button>
									</c:when>
									<c:otherwise>
										<button type="button" class="btn btn-default"
											onclick="location.href='rvboard_list.rvboard'">목록</button>
									</c:otherwise>
								</c:choose>
							</div>

						</td>
					</tr>
				</tbody>
			</table>


			<!-- 댓글창  -->
			<form action="comment.rvboard" method="post">
				<input type="hidden" name="bno" value='${vo.bno }'> <input
					type="hidden" name="id" value='${sessionScope.member_id }'>
				<table class="table" style="width: 95%">

					<tr>
						<th style="width: 7%">댓글(${fn:length(clist) })</th>
						<td><textarea rows="3" style="width: 140%;" name="comment"></textarea></td>

						<td align="right"><input type="submit" value="댓글등록"
							class="btn btn-default"></td>
					</tr>

				</table>

			</form>
			
			
			<table class="table" style="width: 95%">

				<tbody>
					<c:forEach var="cvo" items="${clist }" varStatus="x">
						<tr>
							
							<td style="width: 7%">${cvo.id }</td>
							<td style="width: 60%" align="center">${cvo.comment_text }</td>
							<td style="width: 25%" align="center"><fmt:formatDate value="${cvo.regdate }"
									pattern="yyyy-MM-dd hh:mm" /></td>
										<c:choose>
									<c:when test="${sessionScope.member_id == cvo.id }">
										<!-- 로그인된 아이디와 댓글 작성한 아이디가 같을 때 -->
							<td style="width: 10%"><input type="button" style="font-size: 8px" value="삭제" class="btn btn-default" onclick="location.href='deleteCom.rvboard?cno=${cvo.cno}&bno=${cvo.bno }'"></td>
									
									</c:when>
									<c:otherwise>
										<td></td>
									</c:otherwise>
								</c:choose>
						</tr>
					</c:forEach>
				</tbody>

			</table>


		</div>
	</div>
</div>


<%@ include file="../include/footer.jsp"%>