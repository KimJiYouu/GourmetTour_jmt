<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section>
	<div class="container">
		<div class="box">
			<div align="center">
				<h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">회원정보 수정하기</h2>
				<b>${sessionScope.member_name }님의 회원정보를 수정합니다.</b>
				<hr>
				<form role="form" action="member_update.member" method="post">
					<div class="form-group">
						<label>ID:</label> <input type="text" class="form-control"
							name="id" value="${vo.id }" readonly="readonly">
					</div>
					<div class="form-group">
						<label>Password:</label> <input type="password"
							class="form-control" name="pw" placeholder="Enter password" required="required">
					</div>
					<div class="form-group">
						<label>Name:</label> <input type="text" class="form-control"
							name="name" value="${vo.name }">
					</div>
					<div class="form-group">
						<label>Email:</label> <input type="email" class="form-control"
							name="email" value="${vo.email }">
					</div>

					<div class="radio">
						<label><strong>Gender:</strong></label><br>
						<select name="gender" style="width:1110px;font-size:15px;">
							<option value="M" ${vo.gender=='M' ? 'selected' : '' }>남자</option>
							<option value="F" ${vo.gender=='F' ? 'selected' : '' }>여자</option>
						</select>
					</div>

					<div class="radio">
						<label><strong>Favorite Food:</strong></label><br>
						<select name="food" style="width:1110px;font-size:15px;">
							<option value="한식" ${vo.food=='한식' ? 'selected' : '' }>한식</option>
							<option value="양식" ${vo.food=='양식' ? 'selected' : '' }>양식</option>
							<option value="중식" ${vo.food=='중식' ? 'selected' : '' }>중식</option>
							<option value="일식" ${vo.food=='일식' ? 'selected' : '' }>일식</option>
						</select>
					</div>
					<button type="submit" class="btn btn-default">정보수정</button>
					<button type="button" class="btn btn-default" onclick="location.href='member_mypage.member'">마이페이지</button>
					
				</form>

			</div>
		</div>
	</div>
</section>




<%@ include file="../include/footer.jsp"%>