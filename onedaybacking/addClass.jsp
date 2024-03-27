<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="top.jsp"/>
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
</style>
</head>
<body>

    <div class="container">
        <div class="button-container">
            <button id="btnPanel1" onclick="showPanel('panel1', 'btnPanel1')">강의 등록</button>
            <button id="btnPanel2" onclick="showPanel('panel2', 'btnPanel2')">강사 등록</button>
        </div>

        <div id="panel1" class="panel-container active"> 

	
<div class="step-section active" id="step1">
    <form id="step1Form" onsubmit="return false;">
    <label for="title" style="font-weight: bold; font-size: 14px;">클래스 상세 내용</label><br>
    <br>
    <label id="notice" for="notice" style="font-size: 14px">클래스 상세 내용을 작성해주세요.</label><br>
    
  <br>	
   <label for="classname">클래스 명</label>
   <label id="must">(필수)</label>
   	<br>
   
<input type="text" id="classname" name="username" placeholder="클래스 명을 입력하세요" style="color: gray;"><br><br>
<br>
<label for="selectcate">카테고리</label> <br>
<select name="cate1" id="cate1">
    <option value="option1">제과</option>
    <option value="option2">제빵</option>
    <option value="option3">커피</option>
    <option value="option4" selected="selected">카테고리를 선택해주세요.</option>
</select>

<select name="cate2" id="cate1">
    <option value="option1">제과</option>
    <option value="option2">제빵</option>
    <option value="option3">커피</option>
    <option value="option4" selected="selected">카테고리를 선택해주세요.</option>
</select>
<br><br>
<br>
<br>
<label for="classtitleimg">대표 이미지</label>
<label id="must">(필수)</label> <br>

<div id="image-upload-container" style="position: relative; display: inline-block;">
    <div id="image-frame" style="width: 300px; height: 200px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
     <img id="uploaded-image" src="photoadd.png" style="max-width: 10%; max-height: 10%; " ><br>
        클릭하여 이미지를 업로드하세요
    </div >
    <input type="file" id="image-upload" style="position: absolute; width: 100%; height: 100%; top: 0; left: 0; opacity: 0; cursor: pointer; ">
</div>

<div style="position: absolute; display: inline-block;">
<div id="image-upload-container2" style="position: absolute; display: inline-block;">
<div>
    <div id="image-frame2" style="font-size:9px; width: 150px; height: 100px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
     <img id="uploaded-image2" src="photoadd.png" style="max-width: 20%; max-height: 20%; " ><br>
        클릭하여 이미지를 업로드하세요
    </div >
    <input type="file" id="image-upload2" style="position: absolute; width: 100%; height: 50%; top: 0; left: 0; opacity: 0; cursor: pointer; ">
    <div id="image-frame3" style="font-size:9px; width: 150px; height: 100px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
     <img id="uploaded-image3" src="photoadd.png" style="max-width: 20%; max-height: 20%; " ><br>
        클릭하여 이미지를 업로드하세요
    </div >
    <input type="file" id="image-upload3" style="position: absolute; width: 100%; height: 50%; top: 152; left: 0; opacity: 0; cursor: pointer; ">
   </div>
</div>
<div id="image-upload-container2" style="position: absolute; display: inline-block;">
<div style="position: absolute; left: 151px;">
    <div id="image-frame4" style=" font-size:9px; width: 150px; height: 100px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
     <img id="uploaded-image4" src="photoadd.png" style="max-width: 20%; max-height: 20%; " ><br>
        클릭하여 이미지를 업로드하세요
    </div >
    <input type="file" id="image-upload4" style="position: absolute; width: 100%; height: 50%; top: 0; left: 0; opacity: 0; cursor: pointer; ">
        <div id="image-frame5" style=" font-size:9px; width: 150px; height: 100px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
     <img id="uploaded-image5" src="photoadd.png" style="max-width: 20%; max-height: 20%; " ><br>
        클릭하여 이미지를 업로드하세요
    </div >
    <input type="file" id="image-upload5" style="position: absolute; width: 100%; height: 50%; top: 152; left: 0; opacity: 0; cursor: pointer; ">
   </div>
</div>
</div>

<script>
    document.getElementById('image-frame').addEventListener('click', function() {
        document.getElementById('image-upload').click();        
    });
    document.getElementById('image-frame2').addEventListener('click', function() {
        document.getElementById('image-upload2').click();
    });
    document.getElementById('image-frame3').addEventListener('click', function() {
        document.getElementById('image-upload3').click();
    });
    document.getElementById('image-frame4').addEventListener('click', function() {
        document.getElementById('image-upload4').click();
    });
    document.getElementById('image-frame5').addEventListener('click', function() {
        document.getElementById('image-upload5').click();
    });

    document.getElementById('image-upload').addEventListener('change', function() {
        var file = this.files[0];
        if (file) {
            var reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById('image-frame').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
            };
            reader.readAsDataURL(file);
        }
    });
    document.getElementById('image-upload2').addEventListener('change', function() {
        var file = this.files[0];
        if (file) {
            var reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById('image-frame2').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
            };
            reader.readAsDataURL(file);
        }
    });
    document.getElementById('image-upload3').addEventListener('change', function() {
        var file = this.files[0];
        if (file) {
            var reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById('image-frame3').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
            };
            reader.readAsDataURL(file);
        }
    });
    document.getElementById('image-upload4').addEventListener('change', function() {
        var file = this.files[0];
        if (file) {
            var reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById('image-frame4').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
            };
            reader.readAsDataURL(file);
        }
    });
    document.getElementById('image-upload5').addEventListener('change', function() {
        var file = this.files[0];
        if (file) {
            var reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById('image-frame5').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
            };
            reader.readAsDataURL(file);
        }
    });
</script>

<br>
<br>
<br>
<label for="classhard">수업 난이도</label>
<label id="must">(필수)</label> <br>


 <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
  <input type="radio" class="btn-check"  name="btnradio" id="btnradio1" autocomplete="off" checked>
  <label class="btn btn-outline-primary" for="btnradio1">초급</label>

  <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off">
  <label class="btn btn-outline-primary" for="btnradio2">중급</label>

  <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off">
  <label class="btn btn-outline-primary" for="btnradio3">고급</label>
</div>
<br>
<br>
<br>
<label for="classfortime">수업 소요시간</label>
   <label id="must">(필수)</label> <br>
<input type="text" id="classname" name="username" placeholder="30분 단위로 적어주세요 ex) 150" style="color: gray;"><br><br>

<br>
<br>
<br>
   <table>
  <tbody>
    <tr>
      <td rowspan="2"><label for="classfortime">수업 소요시간</label>
   <label id="must">(필수) &nbsp; &nbsp; &nbsp;</label> </td>
      <td colspan="2" style="text-align: center;" >최소 인원</td>
      <td style="text-align: center;">최대 인원</td>
      
    </tr>
    <tr>
      <td><input type="text" id="classname" name="username" placeholder="명" style="color: gray; text-align: right;"></td>
      <td>/ &nbsp; &nbsp;&nbsp;</td>
      <td><input type="text" id="classname" name="username" placeholder="명" style="color: gray; text-align: right;"></td>
    </tr>
  </tbody>
</table>
<br>
<br>
<br>
<label for="classfortime">1인 수강금액</label>
   <label id="must">(필수)</label> <br>
<input type="text" id="classname" name="username" placeholder="원" style="color: gray;text-align: right;"><br><br>

<br>

<br><br>
<br>
        
        <button onclick="nextStep(1)">다음</button>
</form>
</div>








<!-- step 2 -->
<div class="step-section" id="step2">
    <form id="step2Form" onsubmit="return false;">
     <label for="title" style="font-weight: bold; font-size: 14px;">클래스 상세 내용</label><br>
    <br>
    <label id="notice" for="notice" style="font-size: 14px">클래스 상세 내용에 들어갈 이미지를 등록해주세요.</label><br>
    
  <br>	
    <br>
<br>
<label for="classtitleimg" style="position: relative; left: 60px;">클래스 상세 내용 이미지</label>
<label id="must" style="position: relative; left: 60px;" >(필수)</label> <br>

        <div id="image-upload-container3" style="position: relative; display: inline-block; left: 60px;"> <br>
    <div id="image-frame6" style="width: 500px; height: 350px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
     <img id="uploaded-image6" src="photoadd.png" style="max-width: 10%; max-height: 10%; " >
     
     <br>
        클릭하여 이미지를 업로드하세요
    </div >
    <input type="file" id="image-upload6" style="position: absolute; width: 100%; height: 100%; top: 0; left: 0; opacity: 0; cursor: pointer; ">
</div>
<script>
document.getElementById('image-frame6').addEventListener('click', function() {
        document.getElementById('image-upload6').click();        
    });
    
document.getElementById('image-upload6').addEventListener('change', function() {
    var file = this.files[0];
    if (file) {
        var reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById('image-frame6').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
        };
        reader.readAsDataURL(file);
    }
});
</script>
<label for="classdetailtitleimg" style="position: relative; left: 60px; font-size: 10px; color: gray;"> 이미지 사이즈는 830px * ? px 이에요. (넓이 사이즈가 맞지 않으면 이미지가 잘리거나 뭉개질 수 있어요.) </label>
     <br>
     <button onclick="previousStep(2)">이전</button>
     <button onclick="nextStep(2)">다음</button>
    </form>
</div>


<!-- step 3 -->
<div class="step-section" id="step3">
    <form id="step3Form" onsubmit="return false;">
     <label for="title" style="font-weight: bold; font-size: 14px;">3페이지</label><br>
    <br>
    <label id="notice" for="notice" style="font-size: 14px">클래스 상세 내용에 들어갈 이미지를 등록해주세요.</label><br>
    
  <br>	
    <br>
<br>


     <br>
     <button onclick="previousStep(3)">이전</button>
     <button onclick="nextStep(3)">다음</button>
    </form>
</div>
        </div><!-- panel1 div -->
        
        <!-- 강사 등록하기 패널에 해당 jsp 파일 추가한 것. 이후 수정 필요 -->
        <div id="panel2" class="panel-container">	
             <label for="title" style="font-weight: bold; font-size: 14px;">강사 소개</label><br>
    <br>
    <label id="notice" for="notice" style="font-size: 14px">해당 클래스의 강사님을 소개해주세요.</label><br>
    
  <br>	
    <br>
<label for="classtitleimg" style="position: relative; ">강사 사진</label>
<label id="must" style="position: relative; " >(필수)</label> <br>

        <div id="image-upload-container4" style="position: relative; display: inline-block; left:30px; "> <br>
    <div id="image-frame7" style="width: 100px; height: 100px; border: 2px solid #ccc; cursor: pointer; position: relative;  background-color: #F2F2F2; border-radius: 5px; display: flex; flex-direction: column; justify-content: center; align-items: center;">
     <img id="uploaded-image7" src="photoadd.png" style="max-width: 30%; max-height: 30%; " >
     프로필
     <br>
    </div >
    <input type="file" id="image-upload7" style="position: absolute; width: 100%; height: 100%; top: 0; left: 0; opacity: 0; cursor: pointer; ">
</div>
<script>
document.getElementById('image-frame7').addEventListener('click', function() {
        document.getElementById('image-upload7').click();        
    });
    
document.getElementById('image-upload7').addEventListener('change', function() {
    var file = this.files[0];
    if (file) {
        var reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById('image-frame7').innerHTML = '<img src="' + e.target.result + '" style="max-width: 100%; max-height: 100%;">';
        };
        reader.readAsDataURL(file);
    }
});

</script>
<br>
<br>
<label for="classforteacher">상호명 또는 닉네임</label>
   <label id="must">(필수)</label> <br>
<input type="text" id="classname" name="username" placeholder="상호명 또는 닉네임을 입력해 주세요." style="color: gray;"><br><br>
<br>
<br>
<label for="classintroduce">강사님 소개</label>
   <label id="must">(필수)</label> <br>
<input type="text" id="classname" name="username" placeholder="강사 소개를 입력해 주세요." style="color: gray; height: 300px;"><br><br>

     <br>
     <br><br>
     <input type="submit" value="저장하기">
    
        </div>
    </div>

    <script>
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
    	if (currentStep >= 3) {
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
</script>



</body>
</html>
