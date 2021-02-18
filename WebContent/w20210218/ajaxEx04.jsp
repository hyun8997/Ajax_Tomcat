<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxEx04.jsp</title>
<script type="text/javascript">
	// 비동기 통신 객체 : XMLHttpRequest 객체
	// (참고) 이 비동기 통신 객체가 웹 브라우저에 따라서 이름이 다름. 특히 MS ..
	
	var xhr = null;
	
	function getXMLHttpRequest(){
		// MS 브라우저라면..
		if(window.ActiveObject){
			try{
				return new ActiveObject("MsXML2.XMLHttp");
			}catch(e1){
				try{
					return new ActiveObject("Microsoft.XMLHTTP");
				}catch(e2){
					null;
				}				
			}// outer try~catch end			
		}else if(window.XMLHttpRequest){
			// 그 외 브라우저라면...
			return new XMLHttpRequest();
		}else{
			return null;
		}		
	}// getXMLHttpRequest() end
	
	function load(url){
		//console.log(url);
		
		// 1. 비동기 통신 객체 얻어오기
		xhr = new getXMLHttpRequest();
		
		//console.dir(xhr);
		
		// 2. 화면에 출력할 부분 로직 
		// 대기하고 있다가 응답이 오면 로직이 실행 - callback 호출
		xhr.onreadystatechange = viewMessage;
		
		// 3. open (method 결정, 주소, 비동기통신여부)
		xhr.open('GET', url, true);
		
		// 4. 실행
		xhr.send();
		
	}// load() end
	
	function viewMessage(){
		// readyState : 0 ~ 4 단계 (4면 완료)
		if(xhr.readyState==4){       // 완료되면 ..			
			if(xhr.status==200){     // 현재 웹페이지가 정상이면 ..
				alert(xhr.responseText);
			
				var div1 = document.getElementById('div1');
				
				div1.innerHTML = "<h1>"+xhr.responseText+"</h1>";
				
			}
		}
	}// viewMessage() end


</script>
</head>
<body>
	<!-- 
	Ajax (Asynchrouous Javascript and XML)
	: 자바스크립트를 이용해서 서버와 XML(데이터)로부터 데이터를 추출하여
	  웹페이지 전체 갱신없이 부분적으로 갱신하여 출력할 수 있도록 하는 기술
	 -->
	 
	 <input type="button" value="simple1.txt" onclick="load('simple1.txt')" />
	 <input type="button" value="simple1.jsp" onclick="load('simple1.jsp')" />
	 <input type="button" value="simple2.txt" onclick="load('simple2.txt')" />
	 <input type="button" value="simple2.jsp" onclick="load('simple2.jsp')" />
	 
	 <div id="div1">
	 	<!-- 서버 혹은 데이터 파일에서 가져온 내용을 웹페이지 갱신없이 부분적으로 갱신하여 출력 -->
	 </div>
	 
</body>
</html>




