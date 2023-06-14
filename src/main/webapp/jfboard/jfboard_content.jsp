<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="box">
		<div class="container">
			<h2>${vo.title }</h2>
			<br>
			<table class="table" style="width: 95%">

				<tr>
					<th style="width: 10%">글번호</th>
					<td style="width: 35%">${vo.fno }</td>

					<th style="width: 10%">조회수</th>
					<td>${vo.hit }</td>

				</tr>
				<tr>
					<th style="width: 10%">작성자</th>
					<td style="width: 35%">${vo.id }</td>

					<th style="width: 10%">작성일</th>
					<td><fmt:formatDate value="${vo.regdate }"
							pattern="yyyy-MM-dd(E)" /></td>

				</tr>
				
						<tr>
						<th style="width: 10%">글 제목</th>
						<td colspan="6">${vo.title }</td>

					</tr>
					<tr>
						<th style="width: 10%">지역</th>
						<td colspan="6">${vo.region }</td>

					</tr>
						<tr>
						<th style="width: 10%">운영시간</th>
						<td colspan="6">${vo.open }</td>

					</tr>
					<tr>
						<th style="width: 10%">주소</th>
						<td colspan="6">${vo.address }</td>

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
											onclick="location.href='jfboard_list.fboard?food=일식'">목록</button>
										<button type="button" class="btn btn-default"
											onclick="location.href='jfboard_modify.fboard?fno=${vo.fno}&food=일식'">수정</button>
										<button type="button" class="btn btn-default"
											onclick="location.href='jfboard_delete.fboard?fno=${vo.fno}&food=일식'">삭제</button>
									</c:when>
									<c:otherwise>
										<button type="button" class="btn btn-default"
											onclick="location.href='jfboard_list.fboard?food=일식'">목록</button>
									</c:otherwise>
								</c:choose>
							</div>

						</td>
					</tr>
				</tbody>
			</table>

		</div>
	</div>
</div>


<%@ include file="../include/footer.jsp"%>