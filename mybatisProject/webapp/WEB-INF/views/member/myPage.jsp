<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer">
		<br>
		<h1 align="center">마이페이지</h1>
		
		<form action="update.me" method="post">
			<input type="hidden" name="userNo" value="${loginUser.userNo }">
			<table align="center">
				<tr>
					<td>ID</td>
					<td>${loginUser.userId }</td>
				</tr>
				
				<tr>
					<td>PWD</td>
					<td><input type="password" name="newPwd" required value="${loginUser.userPwd }"></td>
				</tr>
				
				<tr>
					<td>NAME</td>
					<td>${loginUser.userName }</td>
				</tr>
				
				<tr>
					<td>EMAIL</td>
					<td><input type="email" name="newEmail" value="${loginUser.email }"></td>
				</tr>
				
				<tr>
					<td>BIRTHDAY</td>
					<td>${loginUser.birthday }</td>
				</tr>
				
				<tr>
					<td>GENDER</td>
					<td>
						<c:choose>
							<c:when test="${loginUser.gender eq 'M' }">
								남자
							</c:when>
							<c:otherwise>
								여자
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				
				<tr>
					<td>PHONE</td>
					<td><input type="text" name="newPhone" placeholder="-포함" value="${loginUser.phone }"></td>
				</tr>
				
				<tr>
					<td>ADDRESS</td>
					<td><input type="text" name="newAddress" value="${loginUser.address }"></td>
				</tr>
			</table>
			<br>
			<div align="center">
				<button type="submit">정보수정</button>
				<button type="button">회원탈퇴</button>
			</div>
			
		</form>
	</div>

	<!-- 
	<script>
		$(function(){
			$("input[type=radio]").each(function(){
				
				var gender = "${loginUser.gender}";
				
				if($(this).val() == gender){
					$(this).attr("checked", true);
				}
			});
		});
	</script>
	 -->	
</body>
</html>