<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<section>
   <div class="container">
      <div class="box">
         <div align="center">

            <h2 class="intro-text text-center"
               style="font-family: 'Nanum Pen Script';">
               <strong style="font-size: 300%; font-family: 'Nanum Pen Script'">${sessionScope.member_name  }님의 마이페이지</strong><br>
            </h2>

	<table class="table" style="width: 70%">

				<tr>
					<th>● 아이디</th>
					<td>${sessionScope.member_id }</td>

				</tr>
				<tr>
					<th>● 이메일</th>
					<td>${sessionScope.member_email }</td>

				</tr>

				<tr>
					<th>● 성별</th>
					<td>${sessionScope.member_gender }</td>
				</tr>
				<tr>
					<th>● 선호음식</th>
					<td>${sessionScope.member_food }</td>
				</tr>
				<tr>
					<th>● 가입일</th>
					<td><fmt:formatDate value="${sessionScope.member_regdate }" pattern="yyyy-MM-dd (E)" /></td>
				</tr>


</table>


         </div>
      </div>

      <div class="box">
         <h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">내가 작성한 글</h2>
         <table class="table table-hover" style="width: 95%">
            <thead>
               <tr>
                  <th>번호</th>
                  <!-- <th>글 번호</th> -->
                  <th style="width: 17%">작성자</th>
                  <th style="width: 50%" align="center">제목</th>
                  <th>날짜</th>
                  <th>조회수</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="vo" items="${list }">
                  <tr>
                     <td>${vo.bno}</td>
                     <td style="width: 17%">${vo.id }</td>
                     <td style="width: 50%"><a
                        href="<%=request.getContextPath() %>/rvboard/rvboard_content.rvboard?bno=${vo.bno }"
                        onclick="location.href='<%=request.getContextPath() %>/rvboard/rvboard_hitCount.rvboard?bno=${vo.bno}'">${vo.title }</a></td>
                     	<td><fmt:formatDate value="${vo.regdate }"
									pattern="yyyy-MM-dd (E) hh시mm분" /></td>
                     <td>${vo.hit }</td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>



      <div class="box">
         <h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">내가 작성한 JMT</h2>
         <table class="table table-hover" style="width: 95%">
            <thead>
               <tr>
                  <th>번호</th>
                  <th>음식종류</th>
                  <th>작성자</th>
                  <th>지역</th>
                  <th>제목</th>
                  <th>날짜</th>
                  <th>조회수</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="vo" items="${list2 }">
                  <tr>
                     <td style="width: 5%">${vo.fno}</td>
                     <td style="width: 10%">${vo.food }</td>
                     <td style="width: 10%">${vo.id }</td>
                     <td>${vo.region }</td>
                     <c:choose>
                     <c:when test="${vo.food == '한식' }">
                     <td style="width: 45%">
                     <a href="<%=request.getContextPath() %>/kfboard/kfboard_content.fboard?fno=${vo.fno }" 
                     onclick="location.href='<%=request.getContextPath() %>/kfboard/kfboard_hitCount.fboard?fno=${vo.fno}'">${vo.title }</a></td>
                     
                     </c:when>
                     <c:when test="${vo.food == '양식' }">
                       <td style="width: 45%">
                     <a href="<%=request.getContextPath() %>/wfboard/wfboard_content.fboard?fno=${vo.fno }" 
                     onclick="location.href='<%=request.getContextPath() %>/wfboard/wfboard_hitCount.fboard?fno=${vo.fno}'">${vo.title }</a></td>
                     </c:when>
                     <c:when test="${vo.food == '중식' }">
                       <td style="width: 45%">
                     <a href="<%=request.getContextPath() %>/cfboard/cfboard_content.fboard?fno=${vo.fno }" 
                     onclick="location.href='<%=request.getContextPath() %>/cfboard/cfboard_hitCount.fboard?fno=${vo.fno}'">${vo.title }</a></td>
                     </c:when>
                     <c:when test="${vo.food == '일식' }">
                       <td style="width: 45%">
                     <a href="<%=request.getContextPath() %>/jfboard/jfboard_content.fboard?fno=${vo.fno }" 
                     onclick="location.href='<%=request.getContextPath() %>/jfboard/jfboard_hitCount.fboard?fno=${vo.fno}'">${vo.title }</a></td>
                     </c:when>
                     
                   
                     </c:choose>
                     	<td><fmt:formatDate value="${vo.regdate }"
									pattern="yyyy-MM-dd (E) hh시mm분" /></td>
                     <td>${vo.hit }</td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>

      
      <div class="box" style="font-size: 120%;">
         <div align="center">
            <a href="member_modify.member" style="margin-right: 20px">회원정보수정</a>
            <a href="member_logout.member" style="margin-right: 20px">로그아웃</a> <a
               href="member_delete.member?id=${sessionScope.member_id }"
               style="margin-right: 20px">회원탈퇴</a>
         </div>
      </div>
   </div>
</section>



<%@ include file="../include/footer.jsp"%>