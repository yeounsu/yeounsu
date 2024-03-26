<%@ page contentType="text/html; charset=UTF-8" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
    /* notice 라벨에 색상 추가 */

    
</style>

<form style="width:100%">
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
</form>
 <script>
      
    </script>
