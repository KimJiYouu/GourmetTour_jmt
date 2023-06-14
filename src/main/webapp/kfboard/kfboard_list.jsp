<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../include/header.jsp"%>
<div class="container">
	<div class="box">
		<div class="container">
			<h2 style="font-family: 'Charmonman', cursive;">Korean jmt</h2>
			<br>
			           <div id="map" style="width:1080px;height:300px;"></div>
            <div>
                   <input type="text" id="keyword" placeholder="장소를 입력하세요">
                   <button type="button" onclick="searchPlaces()">검색</button>
               </div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e410866e806867c545d02e24dae6d354&libraries=services"></script>

   <script>
      // 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
      var infowindow = new kakao.maps.InfoWindow({zIndex:1});
      
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
          mapOption = {
              center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
              level: 3 // 지도의 확대 레벨
          };  
      
      // 지도를 생성합니다    
      var map = new kakao.maps.Map(mapContainer, mapOption); 
      
      // 장소 검색 객체를 생성합니다
      var ps = new kakao.maps.services.Places(); 
      
      // 키워드로 장소를 검색합니다
      ps.keywordSearch(placesSearchCB); 
      
      function searchPlaces() {
           var keyword = document.getElementById('keyword').value;

           if (keyword === '') {
               alert('장소를 입력하세요');
               return;
           }

           // 검색어로 장소를 검색합니다
           ps.keywordSearch(keyword, placesSearchCB);
       }
      
      // 키워드 검색 완료 시 호출되는 콜백함수 입니다
      function placesSearchCB (data, status, pagination) {
          if (status === kakao.maps.services.Status.OK) {
      
              // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
              // LatLngBounds 객체에 좌표를 추가합니다
              var bounds = new kakao.maps.LatLngBounds();
      
              for (var i=0; i<data.length; i++) {
                  displayMarker(data[i]);    
                  bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
              }       
      
              // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
              map.setBounds(bounds);
          } 
      }
   
      // 지도에 마커를 표시하는 함수입니다
      function displayMarker(place) {
          
          // 마커를 생성하고 지도에 표시합니다
          var marker = new kakao.maps.Marker({
              map: map,
              position: new kakao.maps.LatLng(place.y, place.x) 
          });
      
          // 마커에 클릭이벤트를 등록합니다
          kakao.maps.event.addListener(marker, 'click', function() {
              // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
              infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
              infowindow.open(map, marker);
          });
      }
   </script>
			<br>
			
			<table class="table table-hover" style="width: 95%">
				<thead>
					<tr>
						<th>번호</th>
						<!-- <th>글 번호</th> -->
						<th>작성자</th>
						<th>지역</th>
						<th>제목</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list }" varStatus="x">
						<tr>
							<td>${fn:length(list) - x.index}</td>
							<td style="width: 12%">${vo.id }</td>
							<td>${vo.region }</td>
							<td style="width: 35%"><a href="kfboard_content.fboard?fno=${vo.fno }" onclick="location.href='kfboard_hitCount.fboard?fno=${vo.fno}'">${vo.title }</a></td>
							<td><fmt:formatDate value="${vo.regdate }"
									pattern="yyyy-MM-dd (E) hh시mm분" /></td>
							<td>${vo.hit }</td>
						</tr>
					</c:forEach>
				</tbody>
				<tbody>
					<tr>
						<td colspan="6" align="center">
							<form action="kfboard_search.fboard" class="form-inline">
							<input type="hidden" name="food" value="한식">
								<div class="form-group">
									<input type="text" name="search" placeholder="제목검색"
										class="form-control"> <input type="submit" value="검색"
										class="btn btn-default"> 
										<c:if test="${sessionScope.member_id != null }">
										<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='kfboard_write.fboard'">
										</c:if>
								</div>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>






