<%@page import="kr.or.nextit.function.service.CommCodeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
    <%@page import="kr.or.nextit.function.*" %>
    
<%request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String name ="김태현";

	String toName = request.getParameter("key");
%>
<pre>
안녕 반가워 <br>
이름이 뭐야? <%=name %><br><br>

누가 호출했어? : <%=toName %> 내가 호출했어<br>
el 누가 호출했어? : ${param.key } 내가 호출했어<br>
</pre>

<%String action = request.getContextPath(); %>
<form action="<%=action %>/review/helloProc.jsp" name="frm" method="post">
	<table class="table">
		<tbody>
			
			<tr>
				<td>이름이 뭐야?</td>	
				<td> <input type="text" name="userName" value="${param.userName }"> </td>	
			</tr>
			
			<tr>
				<td>나이가 몇살이야</td>	
				<td>
					<select name="userAge">
						<option value="1"> 1 </option>
						<option value="2"> 2 </option>
						<option value="3"> 3 </option>
						<option value="4"> 4 </option>
						<option value="5"> 5 </option>
					</select>
					
				</td>	
			</tr>
			
			<tr>
				<td>취미</td>	
				<td>
				<%
					List<CommCodeVo> items = MemberUtil.getHobbyItems();
					for(CommCodeVo item : items){
					
				%>
					<input type="checkbox" name="userHobby" value="<%=item.getKey()%>"> 
					<%=item.getValue() %><br>
				<%} %>
				</td>	
			</tr>
			
			<tr>
				<td colspan="2">
					<button type="submit"> 전송 </button>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					난 <%=request.getParameter("userName") %>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					난 ${param.userName }					
				</td>
			</tr>
			
		</tbody>
	</table>

</form>



</body>
</html>