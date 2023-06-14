<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="box">
		<div class="container">
			<h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">게시글 수정하기</h2>
			<form action="jfboard_update.fboard" method="post">
				<input type="hidden" name="fno" value="${vo.fno }"> <input
					type="hidden" name="food" value="일식">
				<table class="table" style="width: 95%">

					<tr>
						<th style="width: 10%">작성자</th>
						<td><input type="text" name="id" value="${vo.id }"></td>

					</tr>
					<tr>
						<th style="width: 10%">글 제목</th>
						<td><input type="text" name="title" value="${vo.title }" style="width: 95%;"></td>

					</tr>
					<tr>
						<th style="width: 10%">지역</th>
						<td>
						<select name="region" style="width: 100px; font-size: 18px;">
							<option value="서울" ${vo.region=='서울' ? 'selected' : '' }>서울</option>
							<option value="광주" ${vo.region=='광주' ? 'selected' : '' }>광주</option>
							<option value="경기" ${vo.region=='경기' ? 'selected' : '' }>경기</option>
							<option value="대구" ${vo.region=='대구' ? 'selected' : '' }>대구</option>
							<option value="대전" ${vo.region=='대전' ? 'selected' : '' }>대전</option>
							<option value="부산" ${vo.region=='부산' ? 'selected' : '' }>부산</option>
							<option value="울산" ${vo.region=='울산' ? 'selected' : '' }>울산</option>
							<option value="인천" ${vo.region=='인천' ? 'selected' : '' }>인천</option>
							<option value="강원도" ${vo.region=='강원도' ? 'selected' : '' }>강원도</option>
							<option value="경상도" ${vo.region=='경상도' ? 'selected' : '' }>경상도</option>
							<option value="전라도" ${vo.region=='전라도' ? 'selected' : '' }>전라도</option>
							<option value="제주도" ${vo.region=='제주도' ? 'selected' : '' }>제주도</option>
							<option value="충청도" ${vo.region=='충청도' ? 'selected' : '' }>충청도</option>
						</select>
						
						
						
						</td>

					</tr>
					<tr>
						<th style="width: 10%">운영시간</th>
						<td><input type="text" name="open" value="${vo.open }" style="width: 95%;"></td>

					</tr>
					<tr>
						<th style="width: 10%">주소</th>
						<td><input type="text" name="address" value="${vo.address }" style="width: 95%;"></td>

					</tr>

					<tr>
						<th style="width: 10%">글 내용</th>
						<td><textarea rows="10" style="width: 95%;" name="writing">${vo.writing }</textarea></td>

					</tr>

					<tbody>
						<tr>
							<td colspan="6" align="center">

								<div class="form-group">
									<input type="submit" value="수정하기" class="btn btn-default">
									<input type="button" value="목록" class="btn btn-default"
										onclick="location.href='jfboard_list.fboard?food=일식'">
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