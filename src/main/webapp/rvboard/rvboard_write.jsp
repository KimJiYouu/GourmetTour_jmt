<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">
	<div class="box">
		<div class="container">
			<h2>게시판 글 작성 페이지</h2>
			<form action="registForm.rvboard" method="post">
			<table class="table" style="width: 95%">
				
					<tr>
						<th style="width: 10%">작성자</th>
						<td><input type="text" name="id" value="${member_id }" readonly="readonly"></td>
					
					</tr>
					<tr>
						<th style="width: 10%">글 제목</th>
						<td><input type="text" name="title" style="width: 95%;"></td>
					
					</tr>
				
					<tr>
						<th style="width: 10%">글 내용</th>
						<td><textarea rows="10" style="width: 95%;" name="writing"></textarea></td>
					
					</tr>
				
				<tbody>
				<tr>
					<td colspan="6" align="center">
						
						  <div class="form-group">
						  	<input type="submit" value="작성완료" class="btn btn-default">
							<input type="button" value="목록" class="btn btn-default" onclick="location.href='rvboard_list.rvboard'">
						  </div>
						 
					</td>
				</tr>
			</tbody>
			</table>
			</form>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>