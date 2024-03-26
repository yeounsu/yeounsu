<%@ page contentType="text/html; charset=EUC-KR"%>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Kakao 지도 시작하기</title>
</head>
<body>	
	<h1> 지도 API </h1>
	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1bd0a165f1e8751b8f19a0ed46c8942b"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(33.450701, 126.570667),
			
			level: 3
		};
		

		var map = new kakao.maps.Map(container, options);
	</script>
</body>
</html>