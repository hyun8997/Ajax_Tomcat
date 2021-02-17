<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxEx01.jsp</title>
</head>
<body>
<!-- 	
	Ajax (Asynchronous Javascript and XML)
	: 자바스크립트를 이용해서 서버와 XML(데이터) 비동기적으로 웹페이지 전체 갱신없이 부분적으로 갱신할 수 있는 기술 
-->

<script type="text/javascript">
	// XMLHttpRequest 객체 필요
	var request = new XMLHttpRequest();	
	console.log(request);	// __proto__에 함수들 있음
	console.dir(request);
	
	// 현재 내 파일에서 같은 서버나 페이지에 있는 XML에서 가져옴 - 동기, 비동기 선택 가능하나 Ajax는 비동기
	
	// 찾기		(method, data, 동기(false)/비동기(true) )
	request.open('GET', 'data.html', false);
	
	// 수행
	request.send();
	
	// 확인
	//alert(request.responseText);
	
	var txt = request.responseText;
	
	//console.log(txt);
	
	document.write(txt);
	
	
</script>

</body>
</html>