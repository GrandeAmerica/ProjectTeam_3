<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Headers · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/footers/">   

    <!-- Bootstrap core CSS -->
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <style>
/* http://meyerweb.com/eric/tools/css/reset/ 
   v2.0 | 20110126
   License: none (public domain)
*/

html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
	display: block;
}
body {
	line-height: 1;
}
ol, ul {
	list-style: none;
}
blockquote, q {
	quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
}

.bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
}

@media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
}

    </style>

    
    <!-- Custom styles for this template -->
    <link href="headers.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="footers.css" rel="stylesheet">    
  </head>
 
  <body>
    

<!-- <main> -->
    <div class="container themed-container" style="background-color: #4598d3;">
        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
          <img src="icon_y_l.png"  class="img" alt="..." height="40" width="40">&nbsp;        
          <span class="fs-4">예사날</span>
        </a>    

        <ul class="nav nav-pills">
            <button type="button" class="btn btn-secondary">예약내역</button>&nbsp;           
            <button type="button" class="btn btn-secondary">사업자</button>&nbsp;           
            <button type="button" class="btn btn-secondary">로그인</button>&nbsp;           
            <button type="button" class="btn btn-secondary">회원가입</button>           
        </ul>

        </header>
      </div>

    </div>  

    <div>
      <div class="container">
        <div class="row">
          <!-- 왼쪽 선택 메뉴 -->
          <div class="card " style="width: auto;" > 
            <div class="card-body">

            <div class="col-4" style="width: auto;">
              <div class="d-grid gap-2">&nbsp;
                <button class="btn btn-primary" type="button">예약관리 서비스</button>&nbsp;
                <button class="btn btn-secondary" type="button">매장정보 서비스</button>&nbsp;
                <button class="btn btn-secondary" type="button">회원탈퇴</button>&nbsp;
              </div> 
            </div>

            </div>
          </div>
          &nbsp;

          <!-- 오른쪽 메뉴내용 -->
          <div class="col-6">
            <h6 class="display-5 fw-normal">예약관리 서비스</h6>&nbsp;&nbsp;

            <ul class="nav nav-tabs">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" >숙박업</a>
              </li>
            </ul>
            &nbsp;
            &nbsp;

            <form method="post" action="#" class="row g-3">
              <div class="col-4">
                <label for="inputState" class="form-label">날짜별</label>
                <select id="inputState" class="form-select">
                  <option selected value="???">모레</option>
                  <option selected value="tomorrow">내일</option>
                  <option selected value="today">오늘</option>
                </select>
              </div>  
              <div class="col-4">
                <label for="inputState" class="form-label">등급별</label>
                <select id="inputState" class="form-select">
                  <option selected value="1">우수</option>
                  <option selected value="-1">불량</option>
                  <option selected value="0">일반</option>
                  <option selected value="2">전체</option>
                </select>
              </div>
              <div class="col-4" align="center" >
 					<div>&nbsp;</div>
                	<button type="submit" class="btn btn-primary" type="button">조회</button>&nbsp;
			  </div>              
            </form>  
            &nbsp;

            <table class="table">
              <thead>
                <tr class="table-danger">
                  <th scope="col">예약번호</th>
                  <th scope="col">예약자명</th>
                  <th scope="col">예약날짜</th>
                  <th scope="col">예약내용</th>
                  <th scope="col">연락처</th>
                  <th scope="col">회원등급</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row">001</th>
                  <td>정우진</td>
                  <td>20220324</td>
                  <td>스위트룸</td>
                  <td>010-8020-5785</td>
                  <td>우수</td>
                </tr>
                <tr>
                  <th scope="row">002</th>
                  <td>김태수</td>
                  <td>20220325</td>
                  <td>VIP룸</td>
                  <td>010-8020-5785</td>
                  <td>불량</td>
                </tr>
                <tr>
                  <th scope="row">003</th>
                  <td>신명훈</td>
                  <td>20220326</td>
                  <td>로얄룸</td>
                  <td>010-8020-5785</td>
                  <td>일반</td>
                </tr>                
              </tbody>
            </table>
            
            <nav aria-label="Page navigation example">
              <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                  <a class="page-link">이전</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item">
                  <a class="page-link" href="#">이후</a>
                </li>
              </ul>
            </nav>            

          </div>
        </div>
      </div>
    </div>
    &nbsp;


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

