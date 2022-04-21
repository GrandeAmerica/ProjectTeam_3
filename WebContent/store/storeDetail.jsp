<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Headers · Bootstrap v5.1</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
    crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/footers/">   
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/carousel/">
    <!-- Custom styles for this template -->
    <link href="css/headers.css" rel="stylesheet">
    <link href="css/footers.css" rel="stylesheet">
    <link href="reset/index.css" rel="stylesheet">
  </head>
 
  <body>
    
    <!-- <header> -->
    
    <div class="container themed-container" style="background-color: #4598d3;">
        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="index.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
          <img src="images/예사날logo.png"  class="img" alt="..." height="40" width="40">&nbsp;        
          <span class="fs-4">예사날</span>
        </a>    

        <ul class="nav nav-pills">
				<%
					if (session.getAttribute("login") == "1") {
				%>
				<button type="button" onclick="location.href='N_reservationServlet'"
					class="btn btn-secondary">예약내역</button>
				&nbsp;
				<button type="button" onclick="location.href='ProfileServlet'"
					class="btn btn-secondary">내 정보</button>
				&nbsp;
				<button type="button" onclick="location.href='LogoutServlet'"
					class="btn btn-secondary">로그아웃</button>
				&nbsp;
				<%
					} else if (session.getAttribute("login") == "2") {
				%>
				<button type="button" href="bisMember" class="btn btn-secondary">매장관리</button>
				&nbsp;
				<button type="button" onclick="location.href='ProfileServlet'"
					class="btn btn-secondary">내 정보</button>
				&nbsp;
				<button type="button" onclick="location.href='LogoutServlet'"
					class="btn btn-secondary">로그아웃</button>
				&nbsp;
				<%
					} else {
				%>
				<button type="button" onclick="location.href='member/login.jsp'"
					class="btn btn-secondary">로그인</button>
				&nbsp;
				<button type="button" onclick="location.href='member/memchoice.jsp'"
					class="btn btn-secondary">회원가입</button>
				<%
					}
				%>
			</ul>
        </header>
      </div>

      <!-- <main> -->
        <div class="container">
        <!-- Carousel -->
<div id="demo" class="carousel slide" data-bs-ride="carousel">

  <!-- Indicators/dots -->
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
  </div>
  
  <!-- The slideshow/carousel -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${store.store_photo1}" alt="Los Angeles" class="d-block" style="width:100%; height: 400px;">
      <div class="carousel-caption">
        <h3>${store.store_name}</h3>
        <p></p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="${store.store_photo1}" alt="Chicago" class="d-block" style="width:100%; height: 400px">
      <div class="carousel-caption">
        <h3>메인 건물 사진</h3>
        <p>어서오세요</p>
      </div> 
    </div>
    <div class="carousel-item">
      <img src="${store.store_photo1}" alt="New York" class="d-block" style="width:100%; height: 400px">
      <div class="carousel-caption">
        <h3>메인 건물 사진2</h3>
        <p>맛나요</p>
      </div>  
    </div>
  </div>
  <!-- Left and right controls/icons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>

<div class="container-fluid mt-3">
  </div>
      <div class="p-3"></div>
        <!-- <sub> -->
        <div class="container marketing">

          <!-- Three columns of text below the carousel -->
          <div class="row">
            <div class="col-lg-3">
              <h3>${store.store_name}</h3>
                <div class="d-grid gap-0">
                  <div class="col-5 bg-light border text-center">주소</div>
                  <p>${store.store_addr}</p>
                  <div class="col-5 bg-light border text-center">운영시간</div>
                  <p>평일 : ${store.store_time} <br>주말 : ${store.store_time_w} </p>
                  <div class="col-5 bg-light border text-center">전화번호</div>
                  <p>${store.store_tel}</p>
                  <div class="col-5 bg-light border text-center">주차여부</div>
                  <p>${store.parking} <br>${store.parking_detail} </p>
                </div>
            </div>
            <div class="col-lg-9">
             
              <h4>메뉴</h4>
              <table class="table">
                <thead class="table-success">
                  <tr>
                    <th scope="col">메뉴명</th>
                    <th scope="col">가격</th>
                    <th scope="col">비고</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>${store.menu_info}</td>
                    <td>7,000</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>짬뽕</td>
                    <td>9,000</td>
                    <td></td>
                  </tr>
                  <tr>
                    <td>탕수육</td>
                    <td>18,000</td>
                    <td></td>
                  </tr>
                </tbody>
              </table>
              <div class="p-3" style="height: 100px"></div>
              <div class="d-grid col-3 mx-auto" style="height: 60px">
                <button class="btn btn-primary" type="button">예약하기</button>
              </div>
            </div>
           
          </div><!-- /.row -->
        </div><!-- /.container -->
        
    <!-- <footer> -->
    <div class="p-3"></div>
    
    <div class="container themed-container" style="background-color: #dfe3e6;">
      <footer class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">

        <ul class="nav nav-pills">
          <button type="button" class="btn btn-secondary">고객센터</button>&nbsp;           
          <button type="button" class="btn btn-secondary">회사소개</button>&nbsp;           
        </ul>
      </footer>
    </div>   
  </body>
</html>      