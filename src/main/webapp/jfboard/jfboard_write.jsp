<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<div class="container">
	<div class="box">
		<div class="container">
			<h2>게시판 글 작성 페이지</h2>
			<form action="registForm.fboard" method="post">
			<input type="hidden" name="food" value="일식">
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
						<th style="width: 10%">지역</th>
							<td>	
						<select name="region" style="width: 100px; font-size: 17px;">
							<option value="서울" selected>서울</option>
							<option value="광주">광주</option>
							<option value="경기">경기</option>
							<option value="대구">대구</option>
							<option value="대전">대전</option>
							<option value="부산">부산</option>
							<option value="울산">울산</option>
							<option value="인천">인천</option>
							<option value="강원도">강원도</option>
							<option value="경상도">경상도</option>
							<option value="전라도">전라도</option>
							<option value="제주도">제주도</option>
							<option value="충청도">충청도</option>
						</select>
						</td>
					
					</tr>
					<tr>
						<th style="width: 10%">운영시간</th>
						<td><input type="text" name="open" style="width: 95%;"></td>
					
					</tr>
					<tr>
						<th style="width: 10%">주소</th>
						<td><input type="text" name="address" style="width: 95%;"></td>
					
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
							<input type="button" value="목록" class="btn btn-default" onclick="location.href='jfboard_list.fboard?food=일식'">
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