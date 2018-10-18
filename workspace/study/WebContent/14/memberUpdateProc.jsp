<%@page import="kr.or.nextit.mber.service.MberVo"%>
<%@page import="kr.or.nextit.mber.service.impl.MberServiceImpl"%>
<%@page import="kr.or.nextit.mber.service.Mberservice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%
	String memId = request.getParameter("userId");
	String memPw = request.getParameter("userPw");
	String memName = request.getParameter("userName");
	String memPhone = request.getParameter("userPhone");
	String memEmail = request.getParameter("userEmail");

	Mberservice mber = new MberServiceImpl();
	MberVo mberVo = mber.updateMemberItem(memId, memPw, memName, memPhone, memEmail);

	out.println(mberVo);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="/inc/lib.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/inc/navbar.jsp"></jsp:include>

<div class="container">
<%
if(mberVo.isState()){
	// 뷰 페이지 이동
	StringBuilder url = new StringBuilder();
	url.append(request.getContextPath());
	url.append("/14/memberViewForm.jsp");
	url.append("?memId=");
	url.append(mberVo.getMemId());
	
	response.sendRedirect(url.toString());
}else{
	%>
	<pre>
	다음과 같은 에러 발생<br>
	<%=mberVo.getMessage() %>
	</pre>
	
	<% 
}
%>
</div>
</body>
</html>