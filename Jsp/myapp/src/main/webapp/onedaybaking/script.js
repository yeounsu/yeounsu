	
// keyUp Event 
/*function detect_keyEvent() {
	 check_duplication == 'Y'인 경우, 아이디를 수정했을 때 
 	document.getElementById("check_duplication").value = 'N';
}*/

function inputCheck(){
	if(document.frm.memberId.value==""){
		alert("아이디를 입력해 주세요.");
		document.frm.id.focus();
		return;
	}
	/*if ( document.getElementById("check_duplication").value != "Y" ) {
		alert("중복확인을 해야합니다.");
		document.frm.id.focus();
		return;
	}*/
	if(document.frm.memberPwd.value==""){
		alert("비밀번호를 입력해 주세요.");
		document.frm.memberPwd.focus();	
		return;
	} else if(document.frm.memberPwd.value.length <4){
			alert("비밀번호 4자리 이상 입력해주세요");
			document.frm.memberPwd.focus();
		return;
		}
	if(document.frm.repassword.value==""){
		alert("비밀번호를 확인해 주세요");
		document.frm.repassword.focus();
		return;
	} else if(document.frm.repassword.value.length <4){
			alert("비밀번호 확인 4자리 이상 입력해주세요");
			document.frm.repassword.focus();
		return;
	}
	if(document.frm.memberPwd.value != document.frm.repassword.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.frm.repassword.value="";
		document.frm.repassword.focus();
		return;
	}
	if(document.frm.memberName.value==""){
		alert("이름을 입력해 주세요.");
		document.frm.memberName.focus();
		return;
	}
	if(document.frm.memberNick.value==""){
		alert("닉네임을 입력해 주세요.");
		document.frm.memberNick.focus();
		return;
	}
	if(document.frm.memberPhone.value==""){
		alert("휴대폰번호를 입력해 주세요.");
		document.frm.memberPhone.focus();
		return;
	}
	if(document.frm.memberBirth.value==""){
		alert("생년월일을 입력해 주세요.");
		document.frm.memberBirth.focus();
		return;
	}
	if(document.frm.memberBirth.value.length !=8){
		alert("생년월일을 8자리로 입력해 주세요.");
		document.frm.memberBirth.focus();
		return;
	}
	
	document.frm.submit();
}

function allChk(){
    var f = document.frm;
    var allChecked = f.allCh.checked;

    f.fch.checked = allChecked;
    f.sch.checked = allChecked;
    f.tch.checked = allChecked;
    
    // "모두 동의합니다" 체크박스의 상태에 따라 모든 하위 체크박스를 선택 또는 해제합니다.
    if (allChecked) {
        for (var i = 0; i < f.fch.length; i++) {
            f.fch[i].checked = true;
            f.sch[i].checked = true;
            f.tch[i].checked = true;
        }
    } else {
        for (var i = 0; i < f.fch.length; i++) {
            f.fch[i].checked = false;
            f.sch[i].checked = false;
            f.tch[i].checked = false;
        }
    }
}

// 페이지 로드 시 "모두 동의합니다" 체크박스를 선택하지 않은 상태로 초기화합니다.
window.onload = function() {
    var f = document.frm;
    f.allCh.checked = false;
    allChk(); // 초기화 후에도 모든 하위 체크박스의 상태를 적용합니다.
};


// 하위 체크박스들이 변경될 때마다 "모두 동의합니다" 체크박스의 상태를 업데이트합니다.
document.querySelectorAll('input[name="fch"], input[name="sch"], input[name="tch"]').forEach(function(checkbox) {
    checkbox.addEventListener('change', function() {
        allChk();
    });
});


// 페이지 로드 시 "모두 동의합니다" 체크박스를 선택하지 않은 상태로 초기화합니다.
window.onload = function() {
    var f = document.frm;
    f.allCh.checked = false;
    allChk(); // 초기화 후에도 모든 하위 체크박스의 상태를 적용합니다.
};

	
function idCheck(memberId){
	// 정규식 
		var _patterns = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		if(memberId == ""){
			alert("아이디를 입력하세요");
			document.frm.memberId.focus();
			return;
		} 
		else if ( _patterns.test(memberId) ) {
			alert("한글은 허용하지 않습니다.");
			document.getElementById("member_id").value = "";
			document.getElementById("member_id").focus();
			return false;
		}
		else if(document.frm.memberId.value.length <4 || document.frm.memberId.value.length >12){
			alert("4~12자 사이로 입력해주세요.");
			document.frm.memberId.focus();
			return;
		}
		url = "idCheck.jsp?memberId="+memberId;
		window.open(url, "ID 중복체크", "width=300, height=150, top=300, left=500");
	}
	
function loginCheck(){
		f = document.frm;
		if(f.memberId.value == ""){
			alert("아이디를 입력해주세요");
			f.memberId.focus();
			return;
		} 
		if(f.memberPwd.value == ""){
			alert("비밀번호를 입력해주세요");
			f.password.focus();
			return;
		}
		f.submit();	
	}
	
document.addEventListener('DOMContentLoaded', function(){
	
	const pwdInput = document.getElementById('password');
	const togglePwd = document.getElementById('togglePwd');
	
	togglePwd.addEventListener('click', function(){
		if(pwdInput.type==='password'){
			pwdInput.type = 'text';
			togglePwd.src = "logo/show.png";
		} else {
			pwdInput.type = 'password';
			togglePwd.src = "logo/hide.png";
		}
	});
});
document.addEventListener('DOMContentLoaded', function(){
	
	const pwdInput = document.getElementById('newpassword');
	const togglePwd = document.getElementById('newtogglePwd');
	
	togglePwd.addEventListener('click', function(){
		if(pwdInput.type==='password'){
			pwdInput.type = 'text';
			togglePwd.src = "logo/show.png";
		} else {
			pwdInput.type = 'password';
			togglePwd.src = "logo/hide.png";
		}
	});
});
document.addEventListener('DOMContentLoaded', function(){
	
	const pwdInput = document.getElementById('repassword');
	const togglePwd = document.getElementById('retogglePwd');
	
	togglePwd.addEventListener('click', function(){
		if(pwdInput.type==='password'){
			pwdInput.type = 'text';
			togglePwd.src = "logo/show.png";
		} else {
			pwdInput.type = 'password';
			togglePwd.src = "logo/hide.png";
		}
	});
});
	
function idSearch(){
		if(document.frm.idname.value == ""){
			alert("이름을 입력하세요");
			document.frm.idname.focus();
			return;
		}
		if(document.frm.memberPhone.value == ""){
			alert("번호를 입력하세요");
			document.frm.memberPhone.focus();
			return;
		}
		if(document.frm.memberBirth.value == ""){
			alert("생년월일을 입력하세요");
			document.frm.memberBirth.focus();
			return;
		}
		if(document.frm.memberBirth.value.length !=8){
		alert("생년월일을 8자리로 입력해 주세요.");
		document.frm.memberBirth.focus();
		return;
		}
		url = "idSearchOk.jsp?idname=" + document.frm.idname.value 
		+ "&memberPhone=" + document.frm.memberPhone.value 
		+ "&memberBirth=" + document.frm.memberBirth.value;
		window.open(url, "ID찾기", "width=400, height=250, top=350, left=500");
	}
	
function passwordSearch(){
	if(document.frm.memberId.value == ""){
			alert("아이디를 입력하세요");
			document.frm.memberId.focus();
			return;
		}
		if(document.frm.memberName.value == ""){
			alert("이름을 입력하세요");
			document.frm.memberName.focus();
			return;
		}
		url= "passwordSearchOk.jsp?memberId="+ document.frm.memberId.value +"&memberName="+document.frm.memberName.value;
		window.open(url, "PASSWORD 찾기", "width=600, height=400, top=200, left=350");

}	

function passwordUpdate(){
	if(document.frm.memberPwd.value==""){
		alert("새로운 비밀번호를 입력해 주세요.");
		document.frm.memberPwd.focus();	
		return;
	}
	if(document.frm.repassword.value==""){
		alert("새로운 비밀번호를 확인해 주세요");
		document.frm.repassword.focus();
		return;
	}
	if(document.frm.memberPwd.value != document.frm.repassword.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.frm.repassword.value="";
		document.frm.repassword.focus();
		return;
	}
	document.frm.submit();
}

function memberUpdate(){
	
	if(document.frm.memberPwd.value==""){
		alert("비밀번호를 입력해 주세요.");
		document.frm.memberPwd.focus();	
		return;
	}
	
	document.frm.submit();
}
function requestAddr() {
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	new daum.Postcode({
		oncomplete: function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
					
			// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var roadAddr = data.roadAddress; // 도로명 주소 변수
			var extraRoadAddr = ''; // 참고 항목 변수
			
			// 법정동명이 있을 경우 추가한다. (법정리는 제외)
			// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
				extraRoadAddr += data.bname;
			}
			// 건물명이 있고, 공동주택일 경우 추가한다.
			if(data.buildingName !== '' && data.apartment === 'Y'){
				extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			}
			// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			if(extraRoadAddr !== ''){
				extraRoadAddr = ' (' + extraRoadAddr + ')';
			}
					
			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('postcode').value = data.zonecode;
			document.getElementById("roadAddress").value = roadAddr;
			document.getElementById("jibunAddress").value = data.jibunAddress;
					 
			document.getElementById("engAddress").value = data.addressEnglish;
					 
			// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
			if(roadAddr !== ''){
				document.getElementById("extraAddress").value = extraRoadAddr;
			} else {
				document.getElementById("extraAddress").value = '';
			}
					
			var guideTextBox = document.getElementById("guide");
			// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
			if(data.autoRoadAddress) {
				var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
				guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
				guideTextBox.style.display = 'block';
					
			} else if(data.autoJibunAddress) {
				var expJibunAddr = data.autoJibunAddress;
				guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
				guideTextBox.style.display = 'block';
			} else {
				guideTextBox.innerHTML = '';
				guideTextBox.style.display = 'none';
			}	}
		}).open();
		}
		
$(document).ready(function() {
    // 글자수 제한 및 표시
    $("#content_cnt").html("(" + $("#content").val().length + " / 1000)");
    if ($("#content").val().length > 1000) {
        $("#content").val($("#content").val().substring(1000));
        $("#content_cnt").html("(1000 / 1000)");
    }
    
    // 엔터시 줄바꿈
    $("#content").keypress(function(event) {
        if (event.keyCode === 13) {
            $(this).val($(this).val() + "\n");
            return false;
        } else {
            return true;
        }
    });

    // 글자수 제한 및 표시(변화 감지)
    $("#content").on("input", function() {
        $("#content_cnt").html("(" + $(this).val().length + " / 1000)");
        if ($(this).val().length > 1000) {
            $(this).val($(this).val().substring(0, 1000));
            $("#content_cnt").html("(1000 / 1000)");
        }
    });
});
function teacherUpdate(){
	if(document.frm.memberInfo.value==""){
		alert("새로운 비밀번호를 입력해 주세요.");
		document.frm.memberInfo.focus();	
		return;
	}
	document.frm.submit();
}

function showPanel(panelId, buttonId) {
			var panels = document.querySelectorAll('.panel-container');
			panels.forEach(function(panel) {
			    panel.classList.remove('active');
			});
			
			var buttons = document.querySelectorAll('.button-container button');
			buttons.forEach(function(button) {
			    button.classList.remove('active');
			});
			
			var currentPanel = document.getElementById(panelId);
			currentPanel.classList.add('active');
			
			var currentButton = document.getElementById(buttonId);
			currentButton.classList.add('active');
}

function win_close(){
	self.close();
}