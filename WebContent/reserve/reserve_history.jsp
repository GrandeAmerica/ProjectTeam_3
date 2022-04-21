<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/footers/">   

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="./css/headers.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="./css/footers.css" rel="stylesheet">   
    
    <link href="./css/reset.css" rel="stylesheet">
</head>
 
<body>   
    <div class="container themed-container" style="background-color: #4598d3;">
        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
            <a href="index.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img src="images/예사날logo.png"  class="img" alt="..." height="40" width="40">&nbsp;        
                <span class="fs-4">예사날</span>
            </a>    

            <ul class="nav nav-pills">
<%
			if(session.getAttribute("login") == "1") {
				%>
				<button type="button" onclick="location.href='N_reservationServlet'" class="btn btn-secondary">예약내역</button>&nbsp;
				<button type="button" onclick="location.href='ProfileServlet'" class="btn btn-secondary">내 정보</button>&nbsp;
				<button type="button" onclick="location.href='LogoutServlet'" class="btn btn-secondary">로그아웃</button>&nbsp;
				<%
			} else if(session.getAttribute("login") == "2") {
				%>
				<button type="button" href="bisMember" class="btn btn-secondary">매장관리</button>&nbsp;
				<button type="button" onclick="location.href='ProfileServlet'" class="btn btn-secondary">내 정보</button>&nbsp;
				<button type="button" onclick="location.href='LogoutServlet'" class="btn btn-secondary">로그아웃</button>&nbsp;
	            <%
			} else {
				%>
				<button type="button" onclick="location.href='member/login.jsp'" class="btn btn-secondary">로그인</button>&nbsp;           
	            <button type="button" onclick="location.href='member/memchoice.jsp'" class="btn btn-secondary">회원가입</button> 
	            <%
			}
%>   
            </ul>
        </header>
    </div>

    <main>
        <div class="container">
            <div class="row">
                <div class="card " style="width: auto;" > 
                    <div class="card-body">
                        <div class="col-4" style="width: auto;">
                            <div class="d-grid gap-2">&nbsp;
                                <button class="btn btn-primary" onclick="location.href='N_reservationServlet'" type="button">예약 내역</button>&nbsp;
                                <button class="btn btn-secondary" onclick="location.href='ProfileServlet'" type="button">회원정보변경</button>&nbsp;
                                <button class="btn btn-secondary" onclick="location.href='member/n_secession.jsp'" type="button">회원탈퇴</button>&nbsp;
                            </div> 
                        </div>
                    </div>
                </div>
                &nbsp;

                <div class="col">
                    <h6 class="display-5 fw-normal">예약내역</h6>&nbsp;&nbsp;
                
					<table class="table table-bordered">
					<thead>
						<tr>
							<th>예약번호</th>
							<th>예약자 이름</th>
							<th>예약자 전화번호</th>
							<th>예약 업체명</th>
							<th>예약한 날짜</th>
							<th>예약한 시간</th>
							<th>예약한 업체 요구사항</th>
							<th>사용 기간</th>
							<th>인원 수</th>
							<th>예약한 내용</th>
							<th>예약시 안내 사항</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rlist" items="${reservationList }">
							<tr>
								<td>${rlist.resr_number }</td>
								<td>${rlist.resr_user_name }</td>
								<td>${rlist.resr_user_tel }</td>
								<td>${rlist.resr_store_name }</td>
								<td>${rlist.resr_date }</td>
								<td>${rlist.resr_time }</td>
								<td>${rlist.resr_store_need }</td>
								<td>${rlist.resr_usingtime }</td>
								<td>${rlist.resr_person }</td>
								<td>${rlist.resr_info }</td>
								<td>${rlist.resr_before_info }</td>

							</tr>
						</c:forEach>
					</tbody>
					</table>

                </div>

                
            </div>
        </div>
    </main>

    <div class="p-3"></div>
    <div class="container themed-container" style="background-color: #dfe3e6;">
        <footer class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
<!--         <footer class="py-3 my-4"> -->
            <ul class="nav nav-pills">
                <button type="button" class="btn btn-secondary">고객센터</button>&nbsp;
                <button type="button" class="btn btn-secondary">회사소개</button>&nbsp;
            </ul>
        </footer>
    </div> 

    <script src="./js/bootstrap.bundle.min.js"></script>  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>   
</body>
</html>