<%@page import="kr.or.nextit.function.service.impl.ComCodeServiceImpl"%>
<%@page import="kr.or.nextit.function.service.ComCodeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
<c:import url="/inc/lib.jsp"></c:import>
</head>
<body>
	<c:import url="/inc/navbar.jsp"></c:import>
	
	<div class="container">
		<%
		try{
			ComCodeService codeService = new ComCodeServiceImpl();
		
			//codeService.getErrorTest("123asd");
			//codeService.getErrorTest2("차차");
			codeService.getBizErrorTest("차차");
			
			//try{
			//String value = "집가자~~~!";
			//int num = Integer.parseInt(value);
			//}catch(Exception e){
			//	out.println(e.getMessage());
			//}
		}catch(Exception e){
			out.println(e.getMessage());
		}
		%>
	</div>

</body>
</html>