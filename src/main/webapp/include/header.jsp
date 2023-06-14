<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-idth, initial-scale=1">


<title>Gourmet Tour</title>

<!-- Bootstrap Core CSS -->
<link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=request.getContextPath()%>/css/business-casual.css" rel="stylesheet">

<!-- Fonts -->
<!-- <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css"> -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Font+Name&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Kaushan Script&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Charmonman&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Gowun Dodum&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nanum Brush Script&display=swap">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nanum Pen Script&display=swap">


<!-- jQuery -->
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script>
	$('.carousel').carousel({
		interval : 2000
	//changes the speed
	})
</script>
<style>
.abc {
	position: sticky;
	top: 0px;
	width: 100%;
	z-index: 10;
}
</style>


</head>

<body>
	<!-- header -->
	<div class="brand" style="font-family: 'Charmonman', cursive;"><a href="<%=request.getContextPath()%>/index.jsp"  style="text-decoration:none;color: darkblue">GOURMET TOUR</a></div>
	<div class="address-bar" style="font-family: 'Charmonman', cursive;">Welcome to the Journey For Gourmet</div>

	<nav class="navbar navbar-default abc" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="/hong">GURMET TOUR</a>
			</div>


			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav" style="font-family: 'Charmonman', cursive;font-weight: bold; ">

					<li><a href="<%=request.getContextPath()%>/index.jsp">HOME</a>
					</li>
					<li><a href="<%=request.getContextPath()%>/jmtplace.jsp">JMT PLACE</a>
					</li>
					<li><a href="<%=request.getContextPath()%>/rvboard/rvboard_list.rvboard">Community</a></li>

					<c:choose>
						<c:when test="${sessionScope.member_id != null }"> <!-- 로그인 됨 -->
							<li><a href="<%=request.getContextPath()%>/member/member_mypage.member" style="color: purple">MY PAGE</a></li>
							<li><a href="<%=request.getContextPath()%>/member/member_logout.member" style="color: orange">LOGOUT</a></li>
						</c:when>

						<c:otherwise> <!-- 로그인 전 -->
							<li><a href="<%=request.getContextPath()%>/member/member_login.member" style="color: Teal">LOGIN</a></li>
							<li><a href="<%=request.getContextPath()%>/member/member_join.member" style="color: Tomato">JOIN</a></li>
						</c:otherwise>

					</c:choose>
				</ul>
			</div>


			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<!-- end header -->