<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxEx06.jsp</title>
<script type="text/javascript" src="../js/httpRequest.js"></script>
<script type="text/javascript">
	function prtImg(){
		var txt = document.getElementById("txt").value;
		
		//alert(txt);
		
		var params = "txt="+encodeURIComponent(txt);
		
		// 수행
		sendRequest('search.jsp', params, callback, 'GET');		
	}
	
	function callback(){
		if(xhr.readyState==4 & xhr.status==200){
			//alert(xhr.responseText);
			
			var img = document.getElementById('img');
			img.src = xhr.responseText;
		}
		
	}


</script>
</head>
<body>
	<!-- 현재 페이지에서 상품검색을 수행하고 그 상품이 있으면 이미지로 출력 -->
	<input type="text" name="" id="txt" />
	<input type="button" value="검색" onclick="prtImg()" />
	<hr />
	<div id="div1">
		<img src="../images/2021.jpg" alt="" id="img" />
	</div>

</body>
</html>






