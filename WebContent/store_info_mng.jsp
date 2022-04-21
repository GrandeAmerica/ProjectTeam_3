<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*"%>

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
    
<script >

function showImage(input) {
	alert("showImage ~~~");

	
	
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview1').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('preview1').src = "icon_y_l.png";
	}

}

</script>    

    
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
    
    <div class="container">
      <div class="row">

        <div class="col-3">

          <div class="card " style="width: auto;" > 
            <div class="card-body">

              <div class="col-4" style="width: auto;">
                <div class="d-grid gap-2">&nbsp;
                  <button class="btn btn-secondary" type="button">예약관리 서비스</button>&nbsp;
                  <button class="btn btn-primary" type="button">매장관리 서비스</button>&nbsp;
                  <button class="btn btn-secondary" type="button">회원탈퇴</button>&nbsp;
                </div> 
              </div>

            </div>
          </div>
          &nbsp;

        </div>

        <div class="col-9">

          <div>
            <h6 class="display-5 fw-normal">메뉴등록</h6>&nbsp;
          </div>
          &nbsp;
          <div>
          </div>  
          &nbsp;&nbsp;&nbsp;

          <form method="post" action="storeInfoMng.do">

            <div class="row">
				    <div class="col-9">
						  <div class="row">
						       <div class="col-3">
						           <button type="button" class="btn btn-primary"  disabled>대표사진1</button>
						       </div> 
						       <div class="col-9">
					                <input class="form-control" type="text" placeholder="${fileName1}" aria-label="default input example" name="store_img_file_name" disabled>               
						       </div> 
						  </div>
						  <div class="row">
						       <div class="col-3">
						           <button type="button" class="btn btn-primary" disabled>대표사진2</button>
						       </div>
						       <div class="col-9">
					                <input class="form-control" type="text" placeholder="${fileName2}" aria-label="default input example" name="store_img_file_name"  disabled>               
						       </div> 
						  </div>
						  <div class="row">
						       <div class="col-3">
						           <button type="button" class="btn btn-primary" disabled>대표사진3</button>
						       </div>
						       <div class="col-9">
					                <input class="form-control" type="text" placeholder="${fileName3}" aria-label="default input example" name="store_img_file_name"  disabled>               
						       </div> 
						  </div>
				    </div>
				    <div class="col-3">
	 				    <img  id="preview1" src="${pageContext.request.contextPath}/images/${realFileName1}"  class="img-thumbnail" alt="..." width="200" height="200" />  
	 				    <img  id="preview1" src="${pageContext.request.contextPath}/images/${realFileName2}"  class="img-thumbnail" alt="..." width="200" height="200" />  
	 				    <img  id="preview1" src="${pageContext.request.contextPath}/images/${realFileName3}"  class="img-thumbnail" alt="..." width="200" height="200" />  
				    </div>
            </div>
            <div>&nbsp;</div>
<!--
            <div class="row">  
              <div class="col-2">
                <button type="button" class="btn btn-primary" disabled" >${fileName1}</button>
              </div>
              <div class="col-10">
 				    <img  id="preview1" src="${pageContext.request.contextPath}/images/${realFileName1}"  class="img-thumbnail" alt="..." width="200" height="200" />  
              </div>

              <div class="col-2">
                <button type="button" class="btn btn-primary" disabled" >${fileName2}</button>
              </div>
              <div class="col-10">
 				    <img  id="preview1" src="${pageContext.request.contextPath}/images/${realFileName2}"  class="img-thumbnail" alt="..." width="200" height="200" />  
              </div>

              <div class="col-2">
                <button type="button" class="btn btn-primary" disabled" >${fileName3}</button>
              </div>
              <div class="col-10">
 				    <img  id="preview1" src="${pageContext.request.contextPath}/images/${realFileName3}"  class="img-thumbnail" alt="..." width="200" height="200" />  
              </div>
            </div>
            <div>&nbsp;</div>            
 -->

            <div class="row">  
              <div class="col-2">
                <button type="button" class="btn btn-primary" disabled >업체이름</button>
              </div>
              <div class="col-10">
                <input class="form-control" type="text" placeholder="${store_name}" aria-label="default input example" name="store_name" disabled>                
              </div>
            </div>
            <div>&nbsp;</div>            

            <div class="row ">  
              <div class="col-2">
                <button type="button" class="btn btn-primary" disabled>업종선택</button>
              </div>
              <div class="col-10">
                <input class="form-control" type="text" placeholder="${store_type}" aria-label="default input example" name="store_type" disabled>                
              </div>

<!-- 
              <div class="col-10 ">
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="store_type" id="inlineRadio1" value="숙박업" checked>
                  <label class="form-check-label" for="inlineRadio1">숙박업</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="store_type" id="inlineRadio2" value="요식업">
                  <label class="form-check-label" for="inlineRadio2">요식업</label>
                </div>
                <div class="form-check form-check-inline">
                  <input class="form-check-input" type="radio" name="store_type" id="inlineRadio3" value="문화시설">
                  <label class="form-check-label" for="inlineRadio3">문화시설 </label>
                </div>
              </div> 
 -->                
            </div>
            <div>&nbsp;</div>              

            <div class="row ">  
              <div class="col-2">
                <button type="button" class="btn btn-primary" disabled>운영시간</button>
              </div>
              <div class="col-10">
               <input class="form-control " type="text" placeholder="Default input" aria-label="default input example" value="${time_day}" name="time_day" disabled> </a>               
               <input class="form-control " type="text" placeholder="Default input" aria-label="default input example" value="${time_week}" name="time_week" disabled>                
              </div> 
            </div>
            <div>&nbsp;</div>

            <div class="row">  
              <div class="col-2">
                <button type="button" class="btn btn-primary" disabled>주소</button>
              </div>
              <div class="col-10">
                <input class="form-control" type="text" placeholder="${store_addr}" aria-label="default input example" name="store_addr" disabled>                
              </div>
              <div>&nbsp;</div>
              <div class="col-2">
                <button type="button" class="btn btn-primary" disabled>상세주소</button>
              </div>
              <div class="col-10">
                <input class="form-control" type="text" placeholder="${store_addr_detail}" aria-label="default input example" name="store_addr_detail" disabled>                
              </div> 
            </div>
            <div>&nbsp;</div>
            
            <div class="row">  
              <div class="col-2">
                <button type="button" class="btn btn-primary" disabled>업체전화</button>
              </div>
              <div class="col-10">
                <input class="form-control" type="text" placeholder="${store_tel}" aria-label="default input example" name="store_tel" disabled>                
              </div> 
            </div>
            <div>&nbsp;</div>
            

            <div class="row">  
              <div class="col-2">
                <button type="button" class="btn btn-primary" >메뉴등록</button>
              </div>
              <div class="col-10">
                <label type="text" class="btn btn-light"  >메뉴와 가격을 연속해서 입력하시면 됩니다.</button>
                <div class="form-floating">
                  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 300px" name="store_menu"></textarea>
                  <label for="floatingTextarea2">[메뉴명][공백][메뉴가격][공백]</label>
                </div>
              </div> 
            </div>
            <div>&nbsp;</div>


            <div class="row ">  
              <div class="col-2">
                <button type="button" class="btn btn-primary" disabled>주차여부</button>
              </div>
              <div class="col-10">
                <input class="form-control" type="text" placeholder="${store_parking}" aria-label="default input example" name="store_parking" disabled>                
              </div>
<!-- 
              <div class="col-10">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox1" name="store_parking" value="가능" checked>
                    <label class="form-check-label" for="inlineCheckbox1">가능</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="inlineCheckbox2" name="store_parking" value="불가능">
                    <label class="form-check-label" for="inlineCheckbox2">불가능</label>
                </div>
 -->
	            <div class="col-2">
				</div>
 				<div class="col-10">	
                <input class="form-control" type="text" placeholder="${store_parking_etc}" aria-label="default input example" name="store_parking_etc" disabled>
                </div>                
            </div> 
            <div>&nbsp;</div>
            <div>&nbsp;</div>
            <div>&nbsp;</div>

            <div class="row">  
              <div class="col-2">
              </div>
              <div class="col-10">
                <input class="btn btn-primary" type="submit" value="변경">
                &nbsp;
                <input class="btn btn-primary" type="reset" value="취소">
              </div> 
            </div>
            <div>&nbsp;</div>
            <div>&nbsp;</div>
            <div>&nbsp;</div>

          </form> 

          </div>  

        </div>

      </div>


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

