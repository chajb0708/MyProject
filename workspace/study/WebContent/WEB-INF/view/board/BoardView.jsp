<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세보기</title>
<c:import url="/inc/lib.jsp"></c:import>
</head>
<body>
	<c:import url="/inc/navbar.jsp"></c:import>

	<div class="container">
		<table class="table">
			<tbody>
				<tr>
					<th>제목</th>
					<td>${boardView.title }</td>
				</tr>
				<tr>
					<th>유형</th>
					<td>${boardView.serviceType }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${boardView.viewCount }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${boardView.regUser }</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${boardView.regDate }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
							<textarea cols='50' rows='10' name="content" readonly="readonly">${boardView.content }</textarea>
						</td>
				</tr>
				<tr>
				<th>수정자</th>
					<td>${boardView.upUser }</td>
				</tr>
				<tr>
					<th>수정일</th>
					<td>${boardView.upDate }</td>
				</tr>
		</table>

		<br>

		<c:url var="updateProc" value="/board/boardUpdateForm.do">
			<c:param name="seqNo" value="${boardView.seqNo }" />
		</c:url>
		<a href="${updateProc }"><button>수정</button></a>

		<c:url var="deleteProc" value="/board/boardDeleteProc.do">
			<c:param name="seqNo" value="${boardView.seqNo }" />
		</c:url>
		<a href="${deleteProc }"><button>삭제</button></a> <br>
		<br>
		<a href="/board/boardList.do"><button>목록으로</button></a>

	</div>

</body>
</html>