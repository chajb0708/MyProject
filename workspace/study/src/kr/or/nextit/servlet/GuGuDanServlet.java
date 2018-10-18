package kr.or.nextit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "GuguDan", urlPatterns = { "/guguDan.test" })
public class GuGuDanServlet extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();

		String flag = req.getParameter("flag");

		out.print("<html>");
		out.print("<head>");
		out.print("<title>구구단</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>구구단 출력</h1>");
		out.print("<div>");

		out.println("<table border=2>");

		out.println(("left".equals(flag) ? "<tr style=\"text-align: center;\">" : ""));
		for (int i = 2; i < 10; i++) {
			if ("left".equals(flag)) {
				out.print("<td>");
			} else {
				out.println("<tr style=\"text-align: center;\"> \n <td>");
			}
			for (int j = 1; j < 10; j++) {
				out.printf("%d * %d = %d<br> \n", i, j, i * j);
			}
			out.println(("left".equals(flag) ? "</td> \n" : "</td> \n</tr> \n"));
		}
		out.println(("left".equals(flag) ? "</tr> \n" : ""));

		out.print("</table>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}
}
