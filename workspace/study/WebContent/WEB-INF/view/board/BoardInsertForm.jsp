<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글등록</title>
<c:import url="/inc/lib.jsp"></c:import>
</head>
<body>
	<c:import url="/inc/navbar.jsp"></c:import>

	<div class="container">

		<form action="/board/boardInsertProc.do">
			<table class="table">
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>글 유형</th>
						<td>
							<select name="serviceType">
								<option value="NOTICE">공지</option>
								<option value="QNA">문의</option>
								<option value="FREE">잡담</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea cols='50' rows='10' name="content"></textarea></td>
					</tr>
					<tr>
						<th><button type="submit">저장</button></th>
					</tr>
				</tbody>
			</table>

		</form>

	</div>

</body>
</html>