<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		*프레임 워크
		-개발자가 보다 편리한 환경에서 개발할 수 있도록 제공하는 뼈대, 틀
		-소프트웨어 개발에서 공통으로 사용하는 라이브러리/개발도구/인터페이스 등등을 의미한다.
		
		*사용 이유
		-현재 웹프로그래밍 규모가 커짐에 따라서 거대하고 복잡한 프로젝트를 완성하기 위해
		  많은 인력이 필요함. 이때 개발자들의 통일성을 지키기 위해, 빠르고 안정적으로 개발하기 위해 사용함에 있어서
		  좋은 결과를 내고 있음 (생산성 향상에 도움이 된다)
		  
		*프레임워크의 특징
		-자유롭게 설계하고 코딩하는게 아니라 프레임워크가 제공하는 가이드대로 설계하고 코딩해야한다.
		-개발할 수 있는 범위가 정해져있다.
		-개발자를 위한 다양한 도구/플러그인이 지원된다.
		
		*장단점
		-장점 : 개발시간 단축
		-단점 : 너무 의존하다보면 개발자의 개발능력저하가 있을 수 있음, 습득하는데 시간이 걸린다.
	 -->
	 
	 <!-- index페이지에서 main페이지로 포워딩 -->
	 <jsp:forward page="WEB-INF/views/main.jsp"/>
</body>
</html>