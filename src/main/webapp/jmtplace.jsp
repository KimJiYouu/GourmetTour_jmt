<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<div class="container">
	<div class="row">
			<div class="col-lg-3">
		<div class="box">

			<!-- 소제목 -->
				<hr>
				<h2 class="intro-text text-center" style="font-family: 'Nanum Pen Script';">
					<strong style="font-size:270%;">한식</strong>
				</h2>
				<hr>
	         <a href="<%=request.getContextPath()%>/kfboard/kfboard_list.fboard?food=한식"><img class="img-responsive" src="img/kfood.jpg" alt=""></a>
		</div><!-- box끝 -->
			</div>

	
			<div class="col-lg-3">
		<div class="box">

			<!-- 소제목 -->
				<hr>
				<h2 class="intro-text text-center" style="font-family: 'Nanum Pen Script';">
					<strong style="font-size:270%;">양식</strong>
				</h2>
				<hr>
				<a href="<%=request.getContextPath()%>/wfboard/wfboard_list.fboard?food=양식"><img class="img-responsive" src="img/wfood.png" alt=""></a>
		</div><!-- box끝 -->
			</div>
	
			<div class="col-lg-3">
		<div class="box">

			<!-- 소제목 -->
				<hr>
				<h2 class="intro-text text-center" style="font-family: 'Nanum Pen Script';">
					<strong style="font-size:270%;">중식</strong>
				</h2>
				<hr>
				 <a href="<%=request.getContextPath()%>/cfboard/cfboard_list.fboard?food=중식"><img class="img-responsive" src="img/cfood.jpg"></a>
		</div><!-- box끝 -->
			</div>


			<div class="col-lg-3">
		<div class="box">

			<!-- 소제목 -->
				<hr>
				<h2 class="intro-text text-center" style="font-family: 'Nanum Pen Script';">
					<strong style="font-size:270%;">일식</strong>
				</h2>
				<hr>
			<a href="<%=request.getContextPath()%>/jfboard/jfboard_list.fboard?food=일식"><img class="img-responsive" src="img/jfood.jpg" alt=""></a>
			
		</div><!-- box끝 -->
			</div>
	


	<!-- /.container -->
</div>
</div>

<%@ include file="../include/footer.jsp"%>