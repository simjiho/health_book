<%@page import="vo.BookVO"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="master/header.jsp"/>

<section>
		<div class="container">
			<p class="title">예약목록 조회/수정</p>
<%
	ArrayList<BookVO> list = (ArrayList<BookVO>)request.getAttribute("list");
	if(!list.isEmpty()) {
%>		

	<table>
		<tr>
			<td>예약번호</td>
			<td>회원 아이디</td>
			<td>트레이너 이름</td>
			<td>총 시간</td>
			<td>총 가격</td>
			<td>삭제</td>
		</tr>
		
<%
	for(BookVO user : list) {
		request.setAttribute("user", user);
%>			
	<tr>
	
<!-- 		<td><a href="/courseUpdate?id=${course.id }">${course.id }</a></td>  -->
			<td><a href="/userUpdate?book_id=${user.book_id }">${user.book_id }</a></td>
			<td>${user.user_id }</td>
			<td>${user.trainer_name }</td>
			<td>${user.book_hour }</td>
			<td>${user.book_pay }</td>
		 	<td><a href="/userDelete?book_id=${user.book_id }">삭제</a></td>												
		</tr>
<%
	}
%>						
	</table>
<%
	}else{
%>		
	<p style="text-align: center"> 등록된 회원 정보가 없습니다</p>
<%
	}
%>
		</div>
</section>


<jsp:include page ="master/footer.jsp"/>