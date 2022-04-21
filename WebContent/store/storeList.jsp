<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/headers/">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.1/examples/footers/">

<!-- Custom styles for this template -->
<link href="css/headers.css" rel="stylesheet">
<link href="css/footers.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="reset/index.css" rel="stylesheet">
</head>
<body>
	<!-- <main> -->

	<div class="container themed-container"
		style="background-color: #4598d3;">
		<header
			class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
			<a href="index.jsp"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
				<img src="images/예사날logo.png" class="img" alt="..." height="40"
				width="40">&nbsp; <span class="fs-4">예사날</span>
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

	<div class="container">
		<hr>
		<div class="row">
			<div class="col-2">
				<form action="./searchStore.do" method="get">
					<input class="form-control mr-sm-2" name="query" type="text"
						placeholder="Search">
			</div>
			<div class="col-4">
				<input class="btn btn-success" type="submit" value="검색" />
				</form>
			</div>

		</div>
		<hr>
		<table class="table table-hover" border="1">
			<tr>
				<th>대표이미지</th>
				<th>업체명</th>
				<th>업종</th>
				<th>주소</th>
			</tr>
			<c:forEach var="store" items="${searchStore}">
				<tr >
					<td><a href="storeDetail.do?store_name=${store.store_name}">
							<img src="${store.store_photo1}" alt="" style="height: 150px"
							width="200px" /></td>
					<td><a href="storeDetail.do?store_name=${store.store_name}">${store.store_name}</td>
					<td>${store.store_type}</td>
					<td>${store.store_addr}</td>
				</tr>
		
			</c:forEach>
		</table>

		<div class="p-3"></div>

		<div class="p-3"></div>

		<div class="container themed-container"
			style="background-color: #dfe3e6;">
			<footer
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">

				<ul class="nav nav-pills">
					<button type="button" class="btn btn-secondary">고객센터</button>
					&nbsp;
					<button type="button" class="btn btn-secondary">회사소개</button>
					&nbsp;
			</footer>
		</div>
</body>
</html>
>>>>>>> refs/remotes/origin/part2
