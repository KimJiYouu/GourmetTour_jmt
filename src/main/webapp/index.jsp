<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>

<div class="container">

      <c:choose>
         <c:when test="${sessionScope.member_id == null}">
      <div class="row "  style="float: none; ">

      <div class="box">
      <div class="col-lg-12">
          
            <div class="inner" align="center" >
   
             <img class="img-responsive img-center" src="img/intro.jpg" alt="">
   
            </div>
         </div>
      </div>
      </div>    
         </c:when>
         
         
         
         <c:when test="${sessionScope.member_food == '한식'}">
            <div class="row ">
              <div class="box">
                <div class="col-lg-12 text-center">
            <h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">한식 맛집 확인하러 가기</h2>   
            ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼
            <a href="<%=request.getContextPath()%>/kfboard/kfboard_list.fboard?food=한식">
            
            <div id="carousel-example-generic" class="carousel slide"
               data-ride="carousel">
               <!-- data-ride="carousel" 자동 슬라이드 기능 -->

               <ol class="carousel-indicators hidden-xs">
                  <li data-target="#carousel-example-generic" data-slide-to="0"
                     class="active"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="3"></li>

               </ol>


               <div class="carousel-inner">
                  <div class="item active">
                     <a href="<%=request.getContextPath()%>/kfboard/kfboard_list.fboard?food=한식"><img class="img-responsive img-full" src="img/kfood01.jpg" style="width:200px;height:600px;"></a>
                  </div>
                  <div class="item">
                     <a href="<%=request.getContextPath()%>/kfboard/kfboard_list.fboard?food=한식"><img class="img-responsive img-full" src="img/kfood02.jpg" style="width:200px;height:600px;"></a>
                     <!-- img-full 옵션 class -->
                  </div>
                  <div class="item">
                     <a href="<%=request.getContextPath()%>/kfboard/kfboard_list.fboard?food=한식"><img class="img-responsive img-full" src="img/kfood03.jpg" style="width:200px;height:600px;"></a>
                  </div>
                  <div class="item">
                     <a href="<%=request.getContextPath()%>/kfboard/kfboard_list.fboard?food=한식"><img class="img-responsive img-full" src="img/kfood04.jpg" style="width:200px;height:600px;"></a>
                  </div>
               </div>


               <a class="left carousel-control" href="#carousel-example-generic"
                  data-slide="prev"> <span class="icon-prev"></span>
               </a> <a class="right carousel-control" href="#carousel-example-generic"
                  data-slide="next"> <span class="icon-next"></span>
               </a>
            </div>
            
            </a>
            </div>
            </div>
            </div>
            
            <div class="row ">
              <div class="box">
                <div class="col-lg-12 text-center"><h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">오늘의 추천 영상</h2></div>
                <hr>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/qYQgpycJBk0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/QM1wx1cnF30" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/gmSbFfLR1c4" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                </div>
                </div>
            
         </c:when>
         
         
 <c:when test="${sessionScope.member_food == '양식'}">
               <div class="row ">
              <div class="box">
                <div class="col-lg-12 text-center">
            <h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">양식 맛집 확인하러 가기</h2>   
            ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼
            <a href="<%=request.getContextPath()%>/wfboard/wfboard_list.fboard?food=양식">
            
            <div id="carousel-example-generic" class="carousel slide"
               data-ride="carousel">
               <!-- data-ride="carousel" 자동 슬라이드 기능 -->

               <ol class="carousel-indicators hidden-xs">
                  <li data-target="#carousel-example-generic" data-slide-to="0"
                     class="active"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="2"></li>

               </ol>


               <div class="carousel-inner">
                  <div class="item active">
                     <a href="<%=request.getContextPath()%>/wfboard/wfboard_list.fboard?food=양식"><img class="img-responsive img-full" src="img/wfood01.jpg" style="width:200px;height:600px;"></a>
                  </div>
                  <div class="item">
                     <a href="<%=request.getContextPath()%>/wfboard/wfboard_list.fboard?food=양식"><img class="img-responsive img-full" src="img/wfood02.jpg" style="width:200px;height:600px;"></a>
                     <!-- img-full 옵션 class -->
                  </div>
                  <div class="item">
                     <a href="<%=request.getContextPath()%>/wfboard/wfboard_list.fboard?food=양식"><img class="img-responsive img-full" src="img/wfood03.jpg" style="width:200px;height:600px;"></a>
                  </div>
                
               </div>


               <a class="left carousel-control" href="#carousel-example-generic"
                  data-slide="prev"> <span class="icon-prev"></span>
               </a> <a class="right carousel-control" href="#carousel-example-generic"
                  data-slide="next"> <span class="icon-next"></span>
               </a>
            </div>
            
            </a>   
            </div>
            </div>
            </div>
            
            <div class="row ">
              <div class="box">
                <div class="col-lg-12 text-center"><h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">오늘의 추천 영상</h2></div>
                <hr>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/x9LuOYLENHc" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/jQR-9a5Apsk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/LI2E_cC49YQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                </div>
                </div>
                
               
         </c:when>
         
         
          <c:when test="${sessionScope.member_food == '중식'}">
               <div class="row ">
              <div class="box">
                <div class="col-lg-12 text-center">
            <h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">중식 맛집 확인하러 가기</h2>   
            ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼
            <a href="<%=request.getContextPath()%>/cfboard/cfboard_list.fboard?food=중식">
            
            <div id="carousel-example-generic" class="carousel slide"
               data-ride="carousel">
               <!-- data-ride="carousel" 자동 슬라이드 기능 -->

               <ol class="carousel-indicators hidden-xs">
                  <li data-target="#carousel-example-generic" data-slide-to="0"
                     class="active"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="2"></li>

               </ol>


               <div class="carousel-inner">
                  <div class="item active">
                     <a href="<%=request.getContextPath()%>/cfboard/cfboard_list.fboard?food=중식"><img class="img-responsive img-full" src="img/cfood01.jpg" style="width:200px;height:600px;"></a>
                  </div>
                  <div class="item">
                     <a href="<%=request.getContextPath()%>/cfboard/cfboard_list.fboard?food=중식"><img class="img-responsive img-full" src="img/cfood02.jpg" style="width:200px;height:600px;"></a>
                     <!-- img-full 옵션 class -->
                  </div>
                  <div class="item">
                     <a href="<%=request.getContextPath()%>/cfboard/cfboard_list.fboard?food=중식"><img class="img-responsive img-full" src="img/cfood03.jpg" style="width:200px;height:600px;"></a>
                  </div>
               </div>


               <a class="left carousel-control" href="#carousel-example-generic"
                  data-slide="prev"> <span class="icon-prev"></span>
               </a> <a class="right carousel-control" href="#carousel-example-generic"
                  data-slide="next"> <span class="icon-next"></span>
               </a>
            </div>
            
            </a>   
            </div>
            </div>
            </div>
            
            <div class="row ">
              <div class="box">
                <div class="col-lg-12 text-center"><h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">오늘의 추천 영상</h2></div>
                <hr>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/80iGxD8AGIM" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/9tHdGnL4tsg" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/2NGLm53K3SU" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                </div>
                </div>
            
         </c:when>
         
         
         <c:when test="${sessionScope.member_food == '일식'}">
               <div class="row ">
              <div class="box">
                <div class="col-lg-12 text-center">
               <h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">일식 맛집 확인하러 가기</h2>   
            ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼ ▽ ▼
            <a href="<%=request.getContextPath()%>/wfboard/wfboard_list.fboard?food=일식">
            
            <div id="carousel-example-generic" class="carousel slide"
               data-ride="carousel">
               <!-- data-ride="carousel" 자동 슬라이드 기능 -->

               <ol class="carousel-indicators hidden-xs">
                  <li data-target="#carousel-example-generic" data-slide-to="0"
                     class="active"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                  <li data-target="#carousel-example-generic" data-slide-to="2"></li>

               </ol>


               <div class="carousel-inner">
                  <div class="item active">
                     <a href="<%=request.getContextPath()%>/jfboard/jfboard_list.fboard?food=일식"><img class="img-responsive img-full" src="img/jfood01.jpg" style="width:200px;height:600px;"></a>
                  </div>
                  <div class="item">
                     <a href="<%=request.getContextPath()%>/jfboard/jfboard_list.fboard?food=일식"><img class="img-responsive img-full" src="img/jfood02.jpg" style="width:200px;height:600px;"></a>
                     <!-- img-full 옵션 class -->
                  </div>
                  <div class="item">
                     <a href="<%=request.getContextPath()%>/jfboard/jfboard_list.fboard?food=일식"><img class="img-responsive img-full" src="img/jfood03.jpg" style="width:200px;height:600px;"></a>
                  </div>
                
               </div>


               <a class="left carousel-control" href="#carousel-example-generic"
                  data-slide="prev"> <span class="icon-prev"></span>
               </a> <a class="right carousel-control" href="#carousel-example-generic"
                  data-slide="next"> <span class="icon-next"></span>
               </a>
            </div>
            
            </a>   
            </div>
            </div>
            </div>
            
            <div class="row ">
              <div class="box">
                <div class="col-lg-12 text-center"><h2 style="font-size: 300%; font-family: 'Nanum Pen Script'">오늘의 추천 영상</h2></div>
               
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/17fTWXbcojE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/APWn3WRr5YA" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                <div class="col-lg-4 text-center">
                <iframe width="350" height="200" src="https://www.youtube.com/embed/2QiE0ylkiWY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                </div>
                </div>
                </div>
            
         </c:when>
      </c:choose>
     
      </div>
   
<%@ include file="include/footer.jsp"%>