<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트</title>
<c:import url="/inc/lib.jsp"></c:import>
</head>
<body>
	<c:import url="/inc/navbar.jsp"></c:import>

	<div class="container">

		<form action="">
			<table class="table">
				<thead>
					<tr>
						<th>
						<select name="whereType">
								<option value="title" ${param.whereType == 'title' ? 'selected="selected"' : '' }>제목</option>
								<option value="content" ${param.whereType == 'content' ? 'selected="selected"' : '' }>내용</option>
							</select>
						</th>
						<th>
							<input type="text" name="searchText" value="${param.searchText}" >
						</th>
					</tr>
					<tr>
						<th>
						<select name="serviceType">
								<option value="NOTICE" ${param.serviceType == 'NOTICE' ? 'selected="selected"' : '' }>공지</option>
								<option value="QNA" ${param.serviceType == 'QNA' ? 'selected="selected"' : '' }>문의</option>
								<option value="FREE" ${param.serviceType == 'FREE' ? 'selected="selected"' : '' }>잡담</option>
								<option value="ALL">ALL</option>
							</select>
						</th>
						<th>
							<button type="submit">검색</button>
						</th>
					</tr>
				</thead>
			</table>
		</form>


		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>유형</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
			<tbody>
				<c:forEach var="rs" items="${boardList }" varStatus="status">
					<tr>
						<td>${status.index+1 }</td>
						<td>${rs.serviceType }</td>
						<c:url var="viewPage" value="/board/boardView.do">
							<c:param name="seqNo" value="${rs.seqNo }" />
						</c:url>
						<td><a href="${viewPage}">${rs.title }</a></td>
						<td>${rs.regUser }</td>
						<td>${rs.regDate }</td>
						<td>${rs.viewCount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a href="/board/boardInsertForm.do"><button>글작성</button></a>
	</div>

</body>
</html>