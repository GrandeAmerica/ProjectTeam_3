<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>매장 상세</title>
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
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
          <img src="C:\ktsdev\work\project3team\html\img\예사날logo.png"  class="img" alt="..." height="40" width="40">&nbsp;        
          <span class="fs-4">예사날</span>
        </a>    

        <ul class="nav nav-pills">
            <button type="button" href="reserve" class="btn btn-secondary">예약내역</button>&nbsp;           
            <button type="button" href="bisMember" class="btn btn-secondary">사업자</button>&nbsp;           
            <button type="button" href="login" class="btn btn-secondary">로그인</button>&nbsp;           
            <button type="button" href="join" class="btn btn-secondary">회원가입</button>           
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
      <img src="C:\ktsdev\work\project3team\html\img\store01.jpg" alt="Los Angeles" class="d-block" style="width:100%; height: 400px;">
      <div class="carousel-caption">
        <h3>딤딤섬</h3>
        <p>홍콩에서 건너온 중식 맛집</p>
      </div>
    </div>
    <div class="carousel-item">
      <img src="C:\ktsdev\work\project3team\html\img\store02.jpg" alt="Chicago" class="d-block" style="width:100%; height: 400px">
      <div class="carousel-caption">
        <h3>메인 건물 사진</h3>
        <p>어서오세요</p>
      </div> 
    </div>
    <div class="carousel-item">
      <img src="C:\ktsdev\work\project3team\html\img\store03.jpg" alt="New York" class="d-block" style="width:100%; height: 400px">
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
              <h3>업체 이름</h3>
                <div class="d-grid gap-0">
                  <div class="col-5 bg-light border text-center">주소</div>
                  <p>서울특별시 영등포구 타임스퀘어 B1 맛집</p>
                  <div class="col-5 bg-light border text-center">운영시간</div>
                  <p>평일 : 00:00~00:00 <br>주말 : 00:00~00:00 </p>
                  <div class="col-5 bg-light border text-center">전화번호</div>
                  <p>02-1234-1234</p>
                  <div class="col-5 bg-light border text-center">주차여부</div>
                  <p>가능 <br>00주차타워 2시간 무료 </p>
                </div>
            </div>
            <div class="col-lg-6">
             
              <h4>메뉴</h4>
              <table class="table">
                <thead class="table-success">
                  <tr>
                    <th scope="col">메뉴코드</th>
                    <th scope="col">메뉴명</th>
                    <th scope="col">가격</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td>001</td>
                    <td>짜장면</td>
                    <td>7,000</td>
                  </tr>
                  <tr>
                    <td>002</td>
                    <td>짬뽕</td>
                    <td>9,000</td>
                  </tr>
                  <tr>
                    <td>003</td>
                    <td>탕수육</td>
                    <td>18,000</td>
                  </tr>
                </tbody>
              </table>
              <div class="d-grid gap-2 col-6 mx-auto">
                <button class="btn btn-primary" type="button">예약하기</button>
              </div>
            </div>
            <div class="col-lg-3">
              
              <h5>업체중심 지도<h5>
              <div id="map" style="width:100%;height:200px;"></div>
              
              <script type="text/javascript" src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=a38ea37c202ed21ab47b545d098a8456&libraries=services"></script>
              <script>
              var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                  mapOption = {
                      center: new kakao.maps.LatLng(37.517166739209756, 126.90378260000001), // 지도의 중심좌표
                      level: 3 // 지도의 확대 레벨
                  };  
              
              // 지도를 생성합니다    
              var map = new kakao.maps.Map(mapContainer, mapOption); 
              
              // 주소-좌표 변환 객체를 생성합니다
              var geocoder = new kakao.maps.services.Geocoder();
              
              // 주소로 좌표를 검색합니다
              geocoder.addressSearch('서울 영등포구 영중로 15', function(result, status) {
              
                  // 정상적으로 검색이 완료됐으면 
                   if (status === kakao.maps.services.Status.OK) {
              
                      var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
              
                      // 결과값으로 받은 위치를 마커로 표시합니다
                      var marker = new kakao.maps.Marker({
                          map: map,
                          position: coords
                      });
              
                      // 인포윈도우로 장소에 대한 설명을 표시합니다
                      var infowindow = new kakao.maps.InfoWindow({
                          content: '<div style="width:150px;text-align:center;padding:6px 0;">맛집</div>'
                      });
                      infowindow.open(map, marker);
              
                      // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                      map.setCenter(coords);
                  } 
              });    
              </script>
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

