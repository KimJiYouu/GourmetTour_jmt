<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<section>
	<div class="container">
		<div class="box">
			<div align="center">
				<h2 style="font-family: 'Charmonman', cursive;">SIGN UP</h2>
				<hr>
				<form role="form" action="joinForm.member" method="post">
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<label>ID:</label><input class="form-control" type="text"
								name="id" placeholder="아이디">
						<div style="color: red;">${msg }</div>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<label>Password: </label> <input class="form-control"
								type="password" name="pw" placeholder="비밀번호">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<label>Name: </label> <input class="form-control"
								type="text" name="name" placeholder="이름">
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<label>Email: </label> <input class="form-control"
								type="email" name="email" placeholder="이메일">
						</div>
					</div>
					<br>
					<div class="radio">
						<label><strong>Gender:</strong></label><br> <select
							name="gender" style="width: 350px; font-size: 15px;">
							<option value="M" selected>남자</option>
							<option value="F">여자</option>
						</select>
					</div>
					<br>
					<div class="radio">
						<label><strong>Favorite Food:</strong></label><br> 
						<select name="food" style="width: 350px; font-size: 15px;">
							<option value="한식" selected>한식</option>
							<option value="양식">양식</option>
							<option value="중식">중식</option>
							<option value="일식">일식</option>
						</select>
					</div>
					<button type="submit" class="btn btn-default">가입하기</button>
					<button type="reset" class="btn btn-default">초기화</button>

				</form>

			</div>
		</div>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>