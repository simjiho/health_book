<%@page import="vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="master/header.jsp"/>

<section>
<div class="container">
	<p class="title">예약 내용 수정</p>
	<% BookVO book = (BookVO)request.getAttribute("book"); %>
	<form action="/userUpdate" method="POST" name="frm" id="frm">
	<table width="600px">
				<tr>
					<td width="200px">예약아이디</td>
					<td><input type = "number"  value="${book.book_id}" id="book_id" readonly="readonly" name="book_id"></td>
				</tr>
				<tr>
					<td>회원아이디</td>
					<td><input type="number" value="${book.user_id}" id="user_id" name="user_id"></td>
				</tr>
				<tr>
						<td>트레이너 선택</td>
						<td><select id="trainer_name" name="trainer_name">
								<option value="">담당트레이너선택</option>
						
								<option value="최트레이너" <%="최트레이너".equals(book.getTrainer_name())?"selected":""%>>최**/다이어트</option>
			
								<option value="이트레이너" <%="이트레이너".equals(book.getTrainer_name())?"selected":""%>>이**/근육량증가</option>
		
								<option value="박트레이너" <%="박트레이너".equals(book.getTrainer_name())?"selected":""%>>박**/바디프로필</option>
								
								<option value="김트레이너" <%="김트레이너".equals(book.getTrainer_name())?"selected":""%>>김**/체형교정</option>
								
								<option value="전트레이너" <%="전트레이너".equals(book.getTrainer_name())?"selected":""%>>전**/선수준비</option>
							</select>
						</td>				
				</tr>
				
				<tr>
					<td>총 시간</td>
					<td>
						<input type="number" value="${book.book_hour}" id="book_hour" name="book_hour">
					</td>
				</tr>
												
				<tr height="100px">
					<td>가격</td>
					<td>
					<select id="book_pay" name="book_pay">
						<option value="">선택한 트레이너를 클릭</option>
						<option value="10000" <%="10000".equals(book.getBook_pay())?"selected":""%>>최트레이너 / ￦10000</option>
						<option value="20000" <%="20000".equals(book.getBook_pay())?"selected":""%>>이트레이너 / ￦20000</option>
						<option value="40000" <%="40000".equals(book.getBook_pay())?"selected":""%>>박트레이너 / ￦40000</option>
						<option value="30000" <%="30000".equals(book.getBook_pay())?"selected":""%>>김트레이너 / ￦30000</option>
						<option value="50000" <%="50000".equals(book.getBook_pay())?"selected":""%>>전트레이너 / ￦50000</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="submit" value="예약 수정" onclick="return checkForm()">
					<input type="button" value="예약 조회" onclick="location.href ='/userList'">
				</tr>
				
			</table>	
	</form>
</div>
</section>
<script>
	function checkForm() {
		if(document.frm.user_id.value.trim() == ""){
			alert('회원아이디가 입력되지 않았습니다!');
			document.frm.user_id.focus();
			return false;
		}
		if(document.frm.trainer_name.value.trim() == ""){
			alert('트레이너가 선택되지 않았습니다!');
			document.frm.trainer_name.focus();
			return false;
		}
		if(document.frm.book_hour.value.trim() == ""){
			alert('총 시간이 입력되지 않았습니다!');
			document.frm.book_hour.focus();
			return false;
		}
		if(document.frm.book_pay.value.trim() == ""){
			alert('가격이 입력되지 않았습니다!');
			document.frm.book_pay.focus();
			return false;
		}
		document.frm.submit();
		}
</script>
<jsp:include page ="master/footer.jsp"/>