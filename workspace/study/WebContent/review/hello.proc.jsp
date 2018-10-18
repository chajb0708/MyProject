<%@page import="kr.or.nextit.function.service.CommCodeVo"%>
<%@page import="kr.or.nextit.review.service.ReviewVo"%>
<%@page import="java.util.*"%>
<%@page import="kr.or.nextit.review.service.ReviewService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<pre>
<%
	ReviewService paramService = new ReviewService();
	HashMap<String, Object> hashMap = paramService.getRequestParamsTest(request);

	out.println(hashMap.get("uName"));
	out.println(hashMap.get("uAge"));

	out.println(request.getParameter("userName"));
	out.println(request.getParameter("userAge"));

	List<CommCodeVo> hobby = (List<CommCodeVo>) hashMap.get("hobbyList");

	String[] uHobby = request.getParameterValues("userHobby");
	for (String item : uHobby) {
		for (CommCodeVo hitem : hobby) {
			if (item.equals(hitem.getKey())) {
				String h = String.format("%s(%s) : 선택한 취미", hitem.getValue(), hitem.getKey());
				out.println(h);
				break;
			} else {
				//String h = String.format("%s(%s)", hitem.getValue(), hitem.getKey());
				//out.println(h);
			}
		}

	}
%>	
===========================================================================	
코드 목록 : 

<%
	ReviewService.getReuestCodeTest(request);

	List<ReviewVo> vList = (List<ReviewVo>) request.getAttribute("codeList");

	for (ReviewVo value : vList) {
		String co = String.format("%s(%s)", value.getCode(), value.getName());
		out.println(co);
	}
%>	
===========================================================================	
회원 목록 :
 
<%
	ReviewService service = new ReviewService();
	service.getRequestTest(request);

	List<String> mList = (List<String>) request.getAttribute("memberList");

	for (String value : mList) {
		out.println(value);
	}
%>
===========================================================================
나이 3살이 넘어오면  "이벤트 당첨!!" 문구 출력
<%
	int age = Integer.parseInt(request.getParameter("userAge"));
	if (age == 3) {
		out.println(String.format("%s 이벤트 당첨 !!", age));
	} else {
		out.println(String.format("%s 다음 기회에 !!", age));
	}
	String result = (age == 3 ? "축하!!!" : "다음에!!!");
	out.println(result);
%>
표현식 : <%=(age == 3 ? "축하!!!" : "다음에!!!")%>
el == ${param.userAge == 3 ? "당첨!!" : "다음에!!"}
===========================================================================
이름
request.getParameter("userName") : <%=request.getParameter("userName")%>
el param : ${param.userName }
===========================================================================
나이
request.getParameter("userAge") : <%=request.getParameter("userAge")%>
el param : ${param.userAge }
===========================================================================
<%
	request.setAttribute("testName", "가나다");
%>
request.setAttribute : <%=request.getAttribute("testName")%>
el request.setAttribute : ${testName}
</pre>

</body>
</html>