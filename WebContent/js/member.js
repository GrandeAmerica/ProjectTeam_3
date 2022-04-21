
function n_login() {
	if (document.nfrm.member_n_id.value==="") {
		alert("아이디를 입력해 주세요.")
		nfrm.member_n_id.focus();
		return false;
	}
	if (document.nfrm.member_n_pwd.value==="") {
		alert("패스워드를 입력해 주세요.")
		nfrm.member_n_pwd.focus();
		return false;
	}
	return true;
}
function b_login() {
	if (document.bfrm.member_b_id.value==="") {
		alert("아이디를 입력해 주세요.")
		bfrm.member_b_id.focus();
		return false;
	}
	if (document.bfrm.member_b_pwd.value==="") {
		alert("패스워드를 입력해 주세요.")
		bfrm.member_b_pwd.focus();
		return false;
	}
	return true;
}



function idCheck() {
	window.open("IdCheckServlet", "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function Available() {
	opener.frm.user_id.value = document.frm.user_id.value;
	self.close();
}


function check_pwd(){
	 
    var pwd = document.getElementById('pwd').value;

    if(pwd.length < 6 || pwd.length>20){
    	document.getElementById('check1').innerHTML='비밀번호는 6글자 이상, 20글자 이하만 이용 가능합니다.';
        document.getElementById('check1').style.color='red';
        document.getElementById('pwd').value='';
    }else {
    	document.getElementById('check1').innerHTML='';
    }
    if(document.getElementById('pwd').value !='' && document.getElementById('pw2').value!=''){
        if(document.getElementById('pwd').value==document.getElementById('pw2').value){
            document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
            document.getElementById('check').style.color='blue';
        }
        else{
            document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
            document.getElementById('check').style.color='red';
        }
    }
}

function pwdHide()  {
	if(document.getElementById('pwd').value !='' || document.getElementById('pw2').value!=''){
		document.getElementById('pwd').value='';
		document.getElementById('pw2').value='';
	}
	
	document.getElementById('showBtn').style.display = '';
	document.getElementById('hideBtn').style.display = 'none';
	
	document.getElementById('hidePwd').style.display = 'none';
}
function pwdShow()  {
	document.getElementById('showBtn').style.display = 'none';
	document.getElementById('hideBtn').style.display = '';
	
	document.getElementById('hidePwd').style.display = '';
}

function emailHide()  {
	if(document.getElementById('newEmail').value !='' || document.getElementById('emailCheck').value!=''){
		document.getElementById('newEmail').value='';
		document.getElementById('emailCheck').value='';
	}
	
	document.getElementById('showBtn1').style.display = '';
	document.getElementById('hideBtn1').style.display = 'none';
	
	document.getElementById('hideEmail').style.display = 'none';
}
function emailShow()  {
	document.getElementById('showBtn1').style.display = 'none';
	document.getElementById('hideBtn1').style.display = '';
	
	document.getElementById('hideEmail').style.display = '';
}