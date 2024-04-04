<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="top.jsp"/>
<!DOCTYPE html>
<html>
<head>
	<title>강의 등록</title>
	<link href="panel.css" rel="stylesheet" type="text/css">
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
	</style>
</head>
<body>
    <div class="container">
        <div class="button-container">
            <button id="btnPanel1" onclick="showPanel('panel1', 'btnPanel1')">강의 등록</button>
            <button id="btnPanel2" onclick="showPanel('panel2', 'btnPanel2')">강사 등록</button>
        </div>
        <div id="panel1" class="panel-container active">
			<div id="step1" class="step-section active">
    			
			</div>

			<!-- step 2 -->
			<div class="step-section" id="step2"> 
				<form id="step2Form" onsubmit="return false;">
					
				</form>
			
			</div>
		</div><!-- panel1 div -->
		
        <!-- 강사 등록하기 패널에 해당 jsp 파일 추가한 것. 이후 수정 필요 -->
		<div id="panel2" class="panel-container">
			
			
			<script>
				
			</script>

		
			
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
		</script>
		
		

		
</body>
</html>
