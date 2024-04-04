<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="onedaybaking.*"%>
<jsp:include page="top.jsp"/>
<%
	String id = (String)session.getAttribute("idKey");
%>
<!DOCTYPE html>
<html>
<head>
	<title>강의 등록</title>
	<link href="yeounsu.css" rel="stylesheet" type="text/css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<style>
		.step-section {
			display: none;
		}
		.step-section.active {
			display: block;
		}
		.detailcontainer {
			display: grid;
			grid-template-columns: repeat(2, 1fr); 
			grid-gap: 10px; 
			border: 1px solid #ccc;
			width: 700px;
			left: 100px;'
			border-color: #E7DBCC; 
			border-radius: 5px;
		}
		.detailitem {
			display: flex;
			align-items: center;
			margin-top: 15px;
			margin-bottom: 15px;
		}
		.button-container2 {
			text-align: center;
			justify-content: center;
			align-items: center;
		}
		.custom-button {
			padding: 10px 70px;
			display: inline-block;
			margin: 0 auto;
			background-color: #884A01; 
			color: white;
			border: 1px solid #884A01;
			border-radius: 10px;
		}
		#pcate1{
	width:45%;
    border-radius: 5px;
    height: 35px;
}

#pcate2{
	width:45%;
    border-radius: 5px;
    height: 35px;
    }
    
 #pcate3{
	width:45%;
    border-radius: 5px;
    height: 35px;
    }
	</style>
</head>
<body>
    <div class="container">
        <div class="button-container">
            <button id="btnPanel1" class="as active" onclick="showPanel('panel1', 'btnPanel1')">제품 소개</button>
            <button id="btnPanel2" class="as" onclick="showPanel('panel2', 'btnPanel2')">상세 설명</button>
        </div>
        <div id="panel1" class="panel-container active">
			<div id="step1" class="step-section active">
    			<form id="step1Form" onsubmit="return false;">
    				<label for="title" style="font-weight: bold; font-size: 14px;">제품 소개</label><br><br>
					<label id="notice" for="notice" style="font-size: 14px">제품의 이름과 카테고리를 등록해주세요.</label><br><br>
					<label for="selectcate">카테고리</label> <br>
<select id= "pcate1" onchange="categoryChange(this)">
         <option>카테고리를 선택해주세요.</option>
         <option value="제과">제과</option>
         <option value="제빵">제빵</option>
         <option value="커피">커피</option>
      </select>
      
      <select id="pcate2">
         <option>원하는 세부사항을 선택해주세요.</option>
      </select>

					<br><br><br><br>
					<label for="productnames">상품 명</label>
					<label id="must">(필수)</label><br>
					<input type="text" id="productnames" name="typingname" placeholder="제품 명을 입력하세요" style="color: gray; width: 100%"><br><br><br>
					<br>
					<label for="productprice">제품가격</label>
					<label id="must">(필수)</label><br>
					<input type="text" id="productprice" name="typingname" placeholder="제품가격을 입력하세요" style="color: gray; width: 100%"><br><br><br>
					<label for="producttitleimg">대표 이미지</label>
					<label id="must">(필수)</label> <br>

					<div id="image-upload-container" style="position: relative; display: inline-block; width: 50%">
					    <div id="pimage-frame" style="width: 100%; height: 200px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
					     	<img id="puploaded-image" src="photoadd.png" style="max-width: 10%; max-height: 10%; " ><br>
					        클릭하여 이미지를 업로드하세요
					    </div >
					    <input type="file" id="pimage-upload" style="position: absolute; width: 100%; height: 100%; top: 0; left: 0; opacity: 0; cursor: pointer; ">
					</div>

					<div style="position: absolute; display: inline-block;">
						<div id="image-upload-container2" style="position: absolute; display: inline-block;">
							<div>
								<div id="pimage-frame2" style="font-size:9px; width: 150px; height: 100px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
									<img id="puploaded-image2" src="photoadd.png" style="max-width: 20%; max-height: 20%; " ><br>
									클릭하여 이미지를 업로드하세요
								</div>
								<input type="file" id="pimage-upload2" style="position: absolute; width: 100%; height: 50%; top: 0; left: 0; opacity: 0; cursor: pointer; ">
								<div id="pimage-frame3" style="font-size:9px; width: 150px; height: 100px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
									<img id="puploaded-image3" src="photoadd.png" style="max-width: 20%; max-height: 20%; " ><br>
									클릭하여 이미지를 업로드하세요
								</div>
								<input type="file" id="pimage-upload3" style="position: absolute; width: 100%; height: 50%; top: 152; left: 0; opacity: 0; cursor: pointer; ">
							</div>
						</div>
						<div id="image-upload-container2" style="position: absolute; display: inline-block;">
							<div style="position: absolute; left: 151px;">
    							<div id="pimage-frame4" style=" font-size:9px; width: 150px; height: 100px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
     								<img id="puploaded-image4" src="photoadd.png" style="max-width: 20%; max-height: 20%; " ><br>
									클릭하여 이미지를 업로드하세요
								</div>
								<input type="file" id="pimage-upload4" style="position: absolute; width: 100%; height: 50%; top: 0; left: 0; opacity: 0; cursor: pointer; ">
								<div id="pimage-frame5" style=" font-size:9px; width: 150px; height: 100px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
									<img id="puploaded-image5" src="photoadd.png" style="max-width: 20%; max-height: 20%; " ><br>
									클릭하여 이미지를 업로드하세요
								</div>
								<input type="file" id="pimage-upload5" style="position: absolute; width: 100%; height: 50%; top: 152; left: 0; opacity: 0; cursor: pointer; ">
							</div>
						</div>
					</div>
					<script>
					    document.getElementById('pimage-frame').addEventListener('click', function() {
					        document.getElementById('pimage-upload').click();        
					    });
					    document.getElementById('pimage-frame2').addEventListener('click', function() {
					        document.getElementById('pimage-upload2').click();
					    });
					    document.getElementById('pimage-frame3').addEventListener('click', function() {
					        document.getElementById('pimage-upload3').click();
					    });
					    document.getElementById('pimage-frame4').addEventListener('click', function() {
					        document.getElementById('pimage-upload4').click();
					    });
					    document.getElementById('pimage-frame5').addEventListener('click', function() {
					        document.getElementById('pimage-upload5').click();
					    });
					
					    document.getElementById('pimage-upload').addEventListener('change', function() {
					        var file = this.files[0];
					        if (file) {
					            var reader = new FileReader();
					            reader.onload = function(e) {
					                document.getElementById('pimage-frame').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
					            };
					            reader.readAsDataURL(file);
					        }
					    });
					    document.getElementById('pimage-upload2').addEventListener('change', function() {
					        var file = this.files[0];
					        if (file) {
					            var reader = new FileReader();
					            reader.onload = function(e) {
					                document.getElementById('pimage-frame2').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
					            };
					            reader.readAsDataURL(file);
					        }
					    });
					    document.getElementById('pimage-upload3').addEventListener('change', function() {
					        var file = this.files[0];
					        if (file) {
					            var reader = new FileReader();
					            reader.onload = function(e) {
					                document.getElementById('pimage-frame3').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
					            };
					            reader.readAsDataURL(file);
					        }
					    });
					    document.getElementById('pimage-upload4').addEventListener('change', function() {
					        var file = this.files[0];
					        if (file) {
					            var reader = new FileReader();
					            reader.onload = function(e) {
					                document.getElementById('pimage-frame4').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
					            };
					            reader.readAsDataURL(file);
					        }
					    });
					    document.getElementById('pimage-upload5').addEventListener('change', function() {
					        var file = this.files[0];
					        if (file) {
					            var reader = new FileReader();
					            reader.onload = function(e) {
					                document.getElementById('pimage-frame5').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
					            };
					            reader.readAsDataURL(file);
					        }
					    });
					</script>
					<br><br><br>
					<div class="optionlabel">
					<div style="float: left; width:50%">
					<label for="option" >메인옵션</label>
					<label id="must">(최소 1개 이상 작성)</label>
					</div>
					<div style="float: right; width:50%">
	<label for="option" style="left: 50px">부가옵션  (선택)</label><br>
	</div>
	</div>
	<div class="mainoption">
    <div style="float: left; width: 50%;">
        <input type="text" id="pmainoption1" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption2" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption3" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption4" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption5" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
    	<input type="text" id="pmainoption6" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption7" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption8" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption9" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption10" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br><br><br><br>
    </div>
    <div style="float: right; width: 50%;">
        <input type="text" id="pmainoption11" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption12" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption13" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption14" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption15" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption16" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption17" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption18" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption19" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br>
        <input type="text" id="pmainoption20" name="mainoption[]" placeholder="제품 옵션을 선택하세요." style="color: gray; width: 98%"><br><br><br><br>
    </div>
</div>
<br>
			        <div class="button-container2">
			        	<button class="custom-button" onclick="nextStep(1)">다음</button>
	        		</div>
				</form>
			</div>

		
		</div><!-- panel1 div -->
		
        <!-- 강사 등록하기 패널에 해당 jsp 파일 추가한 것. 이후 수정 필요 -->
        
        
		<div id="panel2" class="panel-container">
		<div class="optionlabel">
					<div style="float: left; width:50%">
					<label for="option" >식품유형</label>
					</div>
					<div style="float: right; width:50%">
	<label for="option" style="left: 50px">생산지</label>
	<label id="must">(필수)</label>
	
	</div>
	</div>
		<div class="pdail">
		<div>
		<input type="text" id="ptext" style ="float: left; width: 48%; " disabled="disabled">
		</div>
		<div >
		<input type="text" id="paddress"  placeholder="주소를 입력하세요."  style ="float: right; width: 48%;">
		</div>
		</div> <br><br><br><br><br>
		<div class="optionlabel">
					<div style="float: left; width:50%">
					<label for="option" >제품 소비기한</label>
						<label id="must">(필수)</label>
					</div>
					<div style="float: right; width:50%">
	<label for="option" style="left: 50px">보관방법</label>
	<label id="must">(필수)</label>
	
	</div>
	</div>
		<div class="pdail2">
		<div>
		<input type="text" id="pday"  placeholder="소비기한을 작성해 주세요 ( - 일)"  style ="float: left; width: 48%;">
		</div>
		<div >
			<select name="cate2" id="pcate3" style="float: right; width: 48%; margin-top: 8px;">
					    <option value="냉장 보관해야해요.">냉장 보관해야해요.</option>
					    <option value="냉동 보관해야해요.">냉동 보관해야해요.</option>
					    <option value="실온 보관해야해요.">실온 보관해야해요.</option>
					    <option value="직사광선을 피해서 보관해야해요.">직사광선을 피해서 보관해야해요.</option>
					    <option value="option4" selected="selected">보관 방법을 선택하세요.</option>
					</select>
		</div>
		</div>
		<br><br>
		<br><br><br>
			<label for="title" style="font-weight: bold; font-size: 14px;">상세 설명</label><br>
			<br>
			<label id="notice" for="notice" style="font-size: 14px">제품의 이름과 카테고리를 등록해주세요.</label><br>
			<br><br>
			
					<div id="image-upload-container3" style="position: relative; display: inline-block; left: 60px;"> <br>
						<div id="pimage-frame6" style="width: 500px; height: 350px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
							<img id="uploaded-image6" src="photoadd.png" style="max-width: 10%; max-height: 10%; " >
							<br>클릭하여 이미지를 업로드하세요
						</div>
						<input type="file" id="pimage-upload6" style="position: absolute; width: 100%; height: 100%; top: 0; left: 0; opacity: 0; cursor: pointer; ">
					</div>
					<script>
						document.getElementById('pimage-frame6').addEventListener('click', function() {
						        document.getElementById('pimage-upload6').click();        
						    });
						    
						document.getElementById('pimage-upload6').addEventListener('change', function() {
						    var file = this.files[0];
						    if (file) {
						        var reader = new FileReader();
						        reader.onload = function(e) {
						            document.getElementById('pimage-frame6').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
						        };
						        reader.readAsDataURL(file);
						    }
						});
					</script>
					
     		<br><br><br>
			<div class="button-container2">
				<form name="addItemFrm" method="post" action="addItem" enctype="multipart/form-data">
					<input type="hidden" id="categorygroup" name="categorygroup" value="">
					<input type="hidden" id="categoryname" name="categoryname" value="">
					<input type="hidden" id="itemname" name="itemname" value="">
					<input type="hidden" id="itemprice" name="itemprice" value="">
					<input type="hidden" id="itemoption1" name="itemoption1" value="">
					<input type="hidden" id="itemoption2" name="itemoption2" value="">
					<input type="hidden" id="itemoption3" name="itemoption3" value="">
					<input type="hidden" id="itemoption4" name="itemoption4" value="">
					<input type="hidden" id="itemoption5" name="itemoption5" value="">
					<input type="hidden" id="itemoption6" name="itemoption6" value="">
					<input type="hidden" id="itemoption7" name="itemoption7" value="">
					<input type="hidden" id="itemoption8" name="itemoption8" value="">
					<input type="hidden" id="itemoption9" name ="itemoption9" value="">
					<input type="hidden" id="itemoption10" name ="itemoption10" value="">
					<input type="hidden" id="itemsoption1" name ="itemsoption1" value="">
					<input type="hidden" id="itemsoption2" name ="itemsoption2" value="">
					<input type="hidden" id="itemsoption3" name ="itemsoption3" value="">
					<input type="hidden" id="itemsoption4" name ="itemsoption4" value="">
					<input type="hidden" id="itemsoption5" name ="itemsoption5" value="">
					<input type="hidden" id="itemsoption6" name ="itemsoption6" value="">
					<input type="hidden" id="itemsoption7" name ="itemsoption7" value="">
					<input type="hidden" id="itemsoption8" name ="itemsoption8" value="">
					<input type="hidden" id="itemsoption9" name ="itemsoption9" value="">
					<input type="hidden" id="itemsoption10" name ="itemsoption10" value="">
					<input type="hidden" id="itemlocation" name ="itemlocation" value="">
					<input type="hidden" id="itemperiod" name ="itemperiod" value="">
					<input type="hidden" id="itemdate" name ="itemdate" value="">
					<input type="hidden" id="itemimg" name ="itemimg" value="">
					<input type="hidden" id="itemimg1" name ="itemimg1" value="">
					<input type="hidden" id="itemimg2" name ="itemimg2" value="">
					<input type="hidden" id="itemimg3" name ="itemimg3" value="">
					<input type="hidden" id="itemimg4" name ="itemimg4" value="">
					<input type="hidden" id="itemcontent" name ="itemcontent" value="">
					<input type="hidden" id="ids" name="ids" value="<%=id%>">
					<input class="custom-button" type="button" value="저장하기" onclick="test()">
				</form>
			</div>
			</div>
        </div>
    

    <script>
    function categoryChange(e) {
        var pcate2_a = ["케이크", "파이", "마카롱", "쿠키","머핀","버터 바","팬케이크","와플","기타"];
        var pcate2_b = ["크로와상", "베이글", "식빵", "바게트","호밀빵","호떡","롤케이크","기타"];
        var pcate2_c = ["에스프레소", "아메리카노", "카페라떼", "카푸치노", "모카","아이스 커피","라떼","마끼야또","콜드 브루","더치 커피","기타"];
        var pcate2_d = document.getElementById("pcate2");

        var target = pcate2_d;

        if(e.value == "제과") var d = pcate2_a;
        else if(e.value == "제빵") var d = pcate2_b;
        else if(e.value == "커피") var d = pcate2_c;

        target.options.length = 0;

        for (var x in d) { 
           var opt = document.createElement("option");
           opt.value = d[x];
           opt.innerHTML = d[x];
           target.appendChild(opt);
        } 
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
		
		function nextStep(currentStep) {
			if (currentStep >= 1) {

				document.getElementById('ptext').value = document.getElementById('pcate2').value;
				
				showPanel('panel2', 'btnPanel2');
				currentStep--;
				return;
			}
			
			document.getElementById('step' + currentStep).classList.remove('active');
			document.getElementById('step' + (currentStep + 1)).classList.add('active');
			
		}
	    
		function previousStep(currentStep) {
			document.getElementById('step' + currentStep).classList.remove('active');
			document.getElementById('step' + (currentStep - 1)).classList.add('active');
		}
		

		function test() {
	        var a1 = document.getElementById("pcate1").value;
	        var b1 = document.getElementById("pcate2").value;
	        var c1 = document.getElementById("productnames").value;
	        var d1 = document.getElementById("productprice").value;
	        var imageFile = document.getElementById("pimage-upload").files[0];
	        var imageFile2 = document.getElementById("pimage-upload2").files[0];
	        var imageFile3 = document.getElementById("pimage-upload3").files[0];
	        var imageFile4 = document.getElementById("pimage-upload4").files[0];
	        var imageFile5 = document.getElementById("pimage-upload5").files[0];
	        var imageFile6 = document.getElementById("pimage-upload6").files[0];
	        
	        var o1 = document.getElementById("pmainoption1").value;
	        var o2 = document.getElementById("pmainoption2").value;
	        var o3 = document.getElementById("pmainoption3").value;
	        var o4 = document.getElementById("pmainoption4").value;
	        var o5 = document.getElementById("pmainoption5").value;
	        var o6 = document.getElementById("pmainoption6").value;	        var o7 = document.getElementById("pmainoption7").value;
	        var o8 = document.getElementById("pmainoption8").value;
	        var o9 = document.getElementById("pmainoption9").value;
	        var o10 = document.getElementById("pmainoption10").value;
	        var o11 = document.getElementById("pmainoption11").value;
	        var o12 = document.getElementById("pmainoption12").value;
	        var o13 = document.getElementById("pmainoption13").value;
	        var o14 = document.getElementById("pmainoption14").value;
	        var o15 = document.getElementById("pmainoption15").value;
	        var o16 = document.getElementById("pmainoption16").value;
	        var o17 = document.getElementById("pmainoption17").value;
	        var o18 = document.getElementById("pmainoption18").value;
	        var o19 = document.getElementById("pmainoption19").value;
	        var o20 = document.getElementById("pmainoption20").value;
	        var ppaddress = document.getElementById("paddress").value; 	        var ppday = document.getElementById("pday").value; 
	        var ppcate = document.getElementById("pcate3").value;
	     

	        
	        if (imageFile != null) {
		        var imageName = imageFile.name;
		        var reader = new FileReader();
		        reader.onload = function(e) {
					reader.readAsDataURL(imageFile);
	        	}
		        document.getElementById("itemimg").value = imageName;
	        }
	        if (imageFile2 != null) {
		        var imageName2 = imageFile2.name;
		        var reader2 = new FileReader();
		        reader2.onload = function(e) {
					reader2.readAsDataURL(imageFile2);
	        	}
		        document.getElementById("itemimg1").value = imageName2;
	        }
	        if (imageFile3 != null) {
		        var imageName3 = imageFile3.name;
		        var reader3 = new FileReader();
		        reader3.onload = function(e) {
					reader3.readAsDataURL(imageFile2);
	        	}
		        document.getElementById("itemimg2").value = imageName3;
	        }
	        if (imageFile4 != null) {
		        var imageName4 = imageFile4.name;
		        var reader4 = new FileReader();
		        reader4.onload = function(e) {
					reader4.readAsDataURL(imageFile4);
	        	}
		        document.getElementById("itemimg3").value = imageName4;
	        }
	        if (imageFile5 != null) {
		        var imageName5 = imageFile5.name;
		        var reader5 = new FileReader();
		        reader5.onload = function(e) {
					reader5.readAsDataURL(imageFile5);
	        	}
		        document.getElementById("itemimg4").value = imageName5;
	        }
	        if (imageFile6 != null) {
		        var imageName6 = imageFile6.name;
		        var reader6 = new FileReader();
		        reader5.onload = function(e) {
					reader6.readAsDataURL(imageFile6);
	        	}
		        document.getElementById("itemcontent").value = imageName6;
	        }

	       
	        document.getElementById("categorygroup").value = a1;
	        document.getElementById("categoryname").value = b1;
	        document.getElementById("itemname").value = c1;
	        document.getElementById("itemprice").value = d1;
	        document.getElementById("itemoption1").value = o1;
	        document.getElementById("itemoption2").value = o2;
	        document.getElementById("itemoption3").value = o3;
	        document.getElementById("itemoption4").value = o4;
	        document.getElementById("itemoption5").value = o5;
	        document.getElementById("itemoption6").value = o6;
	        document.getElementById("itemoption7").value = o7;
	        document.getElementById("itemoption8").value = o8;
	        document.getElementById("itemoption9").value = o9;
	        document.getElementById("itemoption10").value = o10;
	        document.getElementById("itemsoption1").value = o11;
	        document.getElementById("itemsoption2").value = o12;
	        document.getElementById("itemsoption3").value = o13;
	        document.getElementById("itemsoption4").value = o14;
	        document.getElementById("itemsoption5").value = o15;
	        document.getElementById("itemsoption6").value = o16;
	        document.getElementById("itemsoption7").value = o17;
	        document.getElementById("itemsoption8").value = o18;
	        document.getElementById("itemsoption9").value = o19;
	        document.getElementById("itemsoption10").value = o20;
	        document.getElementById("itemlocation").value = ppaddress;
	        document.getElementById("itemperiod").value = ppday;
	        document.addItemFrm.submit();
		}
	</script>
</body>
</html>
