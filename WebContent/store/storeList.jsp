<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>검색 리스트</title>
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
	<form action="" method="post">
		<div class="container themed-container"
			style="background-color: #4598d3;">
			<header
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
				<a href="../index.jsp"
					class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
					<img src="../images/예사날logo.png" class="img" alt="..." height="40"
					width="40">&nbsp; <span class="fs-4">예사날</span>
				</a>


				<ul class="nav nav-pills">
					<button type="button" href="reserve" class="btn btn-secondary"
						href="./member/n_profile.jsp">예약내역</button>
					&nbsp;
					<button type="button" href="bisMember" class="btn btn-secondary">사업자</button>
					&nbsp;
					<button type="button" href="login" class="btn btn-secondary">로그인</button>
					&nbsp;
					<button type="button" href="join" class="btn btn-secondary">회원가입</button>
				</ul>
			</header>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-3">
					<input type="text" class="form-control pull-right"
						placeholder="Search" name="searchWord" />
				</div>
				<button class="btn btn-primary col-1" type="submit">
					<span class="glyphicon glyphicon-search">검색</span>
				</button>
			</div>
			<hr>
			<div class="row">
				<div class="col-6">

					<!-- 업체 목록 -->
					<h4>업체 검색 결과</h4>
					<table border="1">
						<tr>
							<td>대표이미지</td>
							<td>업체명</td>
							<td>업종</td>
							<td>주소</td>
						</tr>
						<c:forEach var="" items="${storeList}">
							<tr>
								<td>${store.store_photo1}</td>
								<td>${store.store_name}</td>
								<td>${store.store_type}</td>
								<td>${store.store_addr}</td>
								<td><a href="./Store_Detail.jsp?store_name=${store.store_name}">상품상세</a></td>
						</c:forEach>
						</tr>
					</table>
				</div>

			</div>
			<hr>
		</div>

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
				</ul>
			</footer>
		</div>
	</form>
</body>
</html>