<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
	<meta charset="UTF-8">
	<title>Headers · Bootstrap v5.1</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" 
    crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/footers/"> 
    <link rel="stylesheet" href="resources/css/plugin/datepicker/bootstrap-datepicker.css">
    <!--달력은 j쿼리 필수, j쿼리 먼저 태그하고 부트스트랩 데이트 피커 태그순서-->  
    <script src="https://code.jquery.com/jquery-3.2.1.js"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.ko.min.js" 
    integrity="sha512-L4qpL1ZotXZLLe8Oo0ZyHrj/SweV7CieswUODAAPN/tnqN3PA1P+4qPu5vIryNor6HQ5o22NujIcAZIfyVXwbQ==" 
    crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <!-- Custom styles for this template -->
    <link href="css/headers.css" rel="stylesheet">
    <link href="css/footers.css" rel="stylesheet">
    <link href="css/reset.css" rel="stylesheet">
  </head>
 
  <body>
    <form method ="post" action="payment.do" enctype="multipart/form-data">
    <!-- <header> -->
    
    <div class="container themed-container" style="background-color: #6ab1e4;">
        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
          <img src="image/logo.png"  class="img" alt="..." height="40" width="40">&nbsp;        
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
        <div class="row">
            <div class="col">
                <ul class="list-group">
                    <li class="list-group-item text-center" style="background-color: skyblue;"> 업체명</li>
                    <li class="list-group-item">예약한 날짜 <input type="date"><br>
         
                    </li>
                    <li class="list-group-item">입실시간 <input type="time" class="step 30"><br>
                        
                    </li>
                    <li class="list-group-item">퇴실시간  <input type="time" class="step 30"><br>
                        
                    </li>
                    <li class="list-group-item">인원 수 &nbsp; <input type="number" id="carousel_number" min=1 max=10 value="1" > </li>
                    <li class="list-group-item">요청사항 <br>
                        <textarea class="col-12"></textarea></li>
                  </ul>
                </div>
                <div class="col-2"> </div>

              <div class="col">
                    <ul class="list-group">
                        <li class="list-group-item text-center" style="background-color: skyblue; ">결제 시 안내 사항</li>
                        <textarea style="height: 220px;">인원 초과시 추가요금 / 겨울엔 수영장 이용 불가 / 야외바베큐 이용자는 요청사항 기재 / xx호텔 체크인/아웃 시간 안내 / 체크인 00:00시 / 체크아웃 00:00시
                        </textarea>   
                    </ul>
                </div>
              </div>

            <div class="p-3"></div>
            <div class="row">
                <div class="col">
                    <ul class="list-group">
                        <li class="list-group-item" style="background-color: skyblue; width: 10rem; "> 상품 선택 확인</li>
                        <table class="table table-hover">
                              <tbody>
                                <tr>
                                  <th scope="row">1</th>
                                  <td>싱글룸</td>
                                  <td>
                                    <input type="number" id="carousel_number" min=1 max=10 value="0" >
                                  </td>  
                                </tr>
                                <tr>
                                  <th scope="row">2</th>
                                  <td>더블룸</td>
                                  <td>
                                    <input type="number" id="carousel_number" min=1 max=10 value="0" >
                                  </td>  
                                </tr>
                                <tr>
                                  <th scope="row">3</th>
                                  <td>스위트룸</td>
                                  <td>
                                    <input type="number" id="carousel_number" min=1 max=10 value="0" >
                                  </td>  
                                </tr>
                               </tbody>
                          </table>
                          <input class="form-control" type="text" value="합계 금액 : " aria-label="readonly input example" readonly>
                      </ul>
                    </div>
                    <div class="col-2"> </div>
                    
                  <div class="col">
                        <ul class="list-group">
                            <li class="list-group-item text-center" style="background-color: skyblue; ">결제수단</li>
                            <table class="table table-hover">
                                <tr>  
                                    <td>카카오페이</td>
                                    <td><div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    </div></td>
                                </tr>
                                <tr>  
                                    <td>삼성페이페이</td>
                                    <td><div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    </div></td>
                                </tr>
                                <tr>  
                                    <td>계좌이체</td>
                                    <td><div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    </div></td>
                                </tr>
                                <tr>  
                                    <td>카드결제</td>
                                    <td><div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    </div></td>
                                </tr>
                            </table>
                        </ul>
                    </div>
                </div>
                <div class="p-2 row">
                    <li class="list-group-item" style="background-color: skyblue; width: 10rem; "> 예약 내용 확인</li>
                    <p>동의하시겠습니까? <input class="form-check-input " type="checkbox" value="" id="flexCheckDefault">
                    <label class="form-check-label" for="flexCheckDefault"></p>

                </div>
                
                <div class="p-3 row">
                    <div class="d-grid gap-2 col-3 mx-auto">
                        <button class="btn btn-primary" type="button">결제하기</button>
                </div>
            </div>    
        </div>        
    </div>
    <!-- <footer> -->

    <div class="p-3"></div>
    
    <div class="container themed-container" style="background-color: #dfe3e6;">
      <footer class=" d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">

        <ul class="nav nav-pills">
          <button type="button" class="btn btn-secondary">고객센터</button>&nbsp;           
          <button type="button" class="btn btn-secondary">회사소개</button>&nbsp;           
        </ul>
      </footer>
    </div>
    </form>   
  </body>
</html>      

