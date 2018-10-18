package kr.or.nextit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;
import kr.or.nextit.member.service.impl.MemberServiceImpl;

@WebServlet(name = "MemberListServlet", urlPatterns = { "/memberList.next" }, initParams = {
		@WebInitParam(name = "test1", value = "valuetest1"), @WebInitParam(name = "test2", value = "valuetest2"),
		@WebInitParam(name = "test3", value = "valuetest3") })
public class MemberListServlet extends HttpServlet {

	private MemberService memberService;

	@Override
	public void init(ServletConfig config) throws ServletException {

		System.out.println("==========MemberListServlet==========시작");

		memberService = new MemberServiceImpl();

		System.out.println(config.getInitParameter("test"));

		Enumeration<String> params = config.getInitParameterNames();

		while (params.hasMoreElements()) {
			String paramName = (String) params.nextElement();
			System.out.printf("paramName : %s, paramValue : %s\n", paramName, config.getInitParameter(paramName));
		}

		super.init(config);

		System.out.println("==========MemberListServlet==========종료");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		System.out.println("회원정보 출력");

		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>회원 목록</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>회원목록 입니다.</h1>");

		MemberVo memberVo = new MemberVo();

		try {
			List<MemberVo> memberResult = memberService.getMemberList(memberVo);

			out.print("<table class=\"table\" border=\"2\">");
			out.print("<tbody>");
			for (MemberVo memberItem : memberResult) {
				out.println("<tr>");
				out.printf("<td> <a href=\"/memberView.next?userId=%s\"> %s </a> </td>\n", memberItem.getUserId(),
						memberItem.getUserId());

				out.printf("<td> %s </td>\n", memberItem.getUserName());
				out.printf("<td> %s </td>\n", memberItem.getUserHp());
				out.printf("<td> %s </td>\n", memberItem.getUserEmail());
				out.println("</tr>");
			}
			out.print("</tbody>");
			out.println("</table>");
		} catch (Exception e) {
			e.printStackTrace();
			out.printf("error Message : %s", e.getMessage());
		}
		out.print("</body>");
		out.print("</html>");
	}

}
