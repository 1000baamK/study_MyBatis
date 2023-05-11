<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#list-area{
		border: 1px solid white;
		text-align: center;
	}
	
	.outer a{
		color: white;
		text-decoration: none;
	}
	
	#list-area>tbody>tr:hover{
		cursor: pointer;
		color: gray;
	}
</style>
</head>
<body>
	
	<jsp:include page="../common/menubar.jsp"/>
	
	<!--
	<script>
		$(function(){
			$("#list-area>tbody>tr").on("click", function(){
				
				var bno = $(this).children().eq(0).text();
				
				location.href = "detail.bo?bno="+bno;
			});			
		});		
	</script>
	 -->
	
	<div class="outer" align="center">
		<h1 align="center">게시판</h1>
		
		<div id="search-area">
			<form action="search.bo" method="get">
				<input type="hidden" name="currentPage" value="1">
				
				<select name="status">
					<option value="title">제목</option>
					<option value="writer">작성자</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="keyword">
				<button type="submit">검색</button>
			</form>
		</div>
		
		<c:if test="${not empty status }">
		<script>
			$(function(){
				console.log($("#search-area option[value=${status}]"));
				
				$("#search-area option").each(function(){
					if($(this).val()=="${status}"){
						$(this).attr("selected", true);
					}
				});
			});
			
		</script>
			
		</c:if>
		
		<table id="list-area">
			<thead>
				<tr>
					<th>글번호</th>
					<th width="400">제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="b" items="${list }">
					<tr onclick="location.href='detail.bo?bno=${b.boardNo}'">
						<td>${b.boardNo }</td>
						<td>${b.boardTitle }</td>
						<td>${b.boardWriter }</td>
						<td>${b.count }</td>
						<td>${b.createDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		
		<div id="paging-area">
			
			<a href="list.bo?currentPage=${pi.currentPage-1 }">이전</a>
			
			<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }" step="1">
				<c:choose>
					<c:when test="${empty status }">
						<a href="list.bo?currentPage=${p }">${p }</a>					
					</c:when>
					<c:otherwise>
						<a href="search.bo?currentPage=${p }&status=${status }&keyword=${keyword }">${p }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<a href="list.bo?currentPage=${pi.currentPage+1 }">다음</a>

		</div>
		
	</div>
</body>
</html>