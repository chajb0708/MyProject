package kr.or.nextit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	// init : 서블릿이 메모리에 올라올때 (인스턴스 될때 1번만 발생)
	// service : 모든 요청이 있을때 진입
	// doget : 요청이 GET 방식일때 진입
	// dopost : 요청이 POST 방식일때 진입
	// destroy : 서블릿이 메모리에서 내려갈떄 (인스턴스 될때)

	@Override
	public void init() throws ServletException {
		System.out.println("HttpServlet INIT 메서드 호출");
		// 서블릿 초기화 메서드
	}

	@Override
	public void destroy() {
		System.out.println("HttpServlet destroy 메서드 호출");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 안녕하세요를 출력하는 서블릿
		System.out.println("HttpServlet service");
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// out을 구하기 전에 resp의 인코딩은 변경 되어있어야 함

		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Hello World</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Hello World 안녕하세요</h1>");
		out.print("param : " + req.getParameter("test"));		
		out.print("</body>");
		out.print("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
