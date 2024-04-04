<%@ page contentType="text/html; charset=EUC-KR"%>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Kakao ���� �����ϱ�</title>
</head>
<body>	
	<h1> ���� API </h1>
	<div>
	<input type="text" id="sample5_address" placeholder="�ּ�">
<input type="button" onclick="sample5_execDaumPostcode()" value="�ּ� �˻�"><br>
<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>


<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1bd0a165f1e8751b8f19a0ed46c8942b&libraries=services"></script>
<script>
    var mapContainer = document.getElementById('map'), // ������ ǥ���� div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // ������ �߽���ǥ
            level: 5 // ������ Ȯ�� ����
        };

    //������ �̸� ����
    var map = new daum.maps.Map(mapContainer, mapOption);
    //�ּ�-��ǥ ��ȯ ��ü�� ����
    var geocoder = new daum.maps.services.Geocoder();
    //��Ŀ�� �̸� ����
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });


    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // ���� �ּ� ����

                // �ּ� ������ �ش� �ʵ忡 �ִ´�.
                document.getElementById("sample5_address").value = addr;
                // �ּҷ� �� ������ �˻�
                geocoder.addressSearch(data.address, function(results, status) {
                    // ���������� �˻��� �Ϸ������
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //ù��° ����� ���� Ȱ��

                        // �ش� �ּҿ� ���� ��ǥ�� �޾Ƽ�
                        var coords = new daum.maps.LatLng(result.y, result.x);
                        // ������ �����ش�.
                        mapContainer.style.display = "block";
                        map.relayout();
                        // ���� �߽��� �����Ѵ�.
                        map.setCenter(coords);
                        // ��Ŀ�� ��������� ���� ��ġ�� �ű��.
                        marker.setPosition(coords)
                    }
                });
            }
        }).open();
    }
</script>
</div>
</body>
</html>