<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>

<section>

	<div class="container">
		<div class="box">
			<div align="center">
				<h2 style="font-family: 'Charmonman', cursive;">LOGIN</h2>
				<hr>
				<form role="form" action="loginForm.member" method="post">
					<div class="form-group">
						
						<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<label>ID: </label><input class="form-control" type="text" name="id" placeholder="아이디">
						</div>
						</div>
						<br>
						<div class="row">
						<div class="col-xs-4"></div>
						<div class="col-xs-4">
							<label>Password: </label> <input class="form-control" type="password" name="pw" placeholder="비밀번호">
						</div>
						</div>
					</div>
					<div style="color: red;">${msg }</div>
					<br>
					<button type="submit" class="btn btn-default">로그인</button>
					<button type="button" class="btn btn-default" onclick="location.href='member_join.member'">회원가입</button>
				</form>
			</div>
		</div>
	</div>

</section>

<%@ include file="../include/footer.jsp"%>
