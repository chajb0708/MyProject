package kr.or.nextit.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.common.web.IController;

@WebServlet(name = "comBoardServlet", urlPatterns = { "*.do" })
public class ComBoardServlet extends HttpServlet {

	private Map<String, IController> controllerMap = new HashMap<>();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		try {

			String uri = req.getRequestURI();
			System.out.printf("사용자 요청 URI : %s", uri);

			uri = uri.substring(req.getContextPath().length());
			System.out.printf("변경된 URI : %s", uri);

			Set<String> keys = controllerMap.keySet();

			if (controllerMap.containsKey(uri)) {
				IController controller = controllerMap.get(uri);
				String viewPage = controller.process(req, resp);

				if (controller.isRedirect()) {
					resp.sendRedirect(viewPage);
				} else {
					RequestDispatcher dispatcher = req
							.getRequestDispatcher(String.format("/WEB-INF/view%s.jsp", viewPage));
					dispatcher.forward(req, resp);
				}
			} else {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}

			/*
			 * for(String key : keys) { System.out.printf(" key : %s", key);
			 * if(uri.equals(key)){ IController controller = controllerMap.get(key);
			 * controller.process(req, resp); } else {
			 * 
			 * } }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {

		System.out.println("ComBoardServlet.init()");
		// 클래스패스에서 프로퍼티 파일 검색
		ResourceBundle bundle = ResourceBundle.getBundle("ComBoardMapper");
		// resource File 의 키값만 가져옴
		Enumeration<String> keys = bundle.getKeys();
		// 가지고온 키 값의 목록을 갯수만큼 반복함
		while (keys.hasMoreElements()) {
			String key = keys.nextElement().trim();
			String value = bundle.getString(key).trim();

			try { // 객체 인스턴스 생성 시 에러가 발생할 경우 에러를 처리함
					// class.forName 으로 인터페이스에 해당하는 객체를 찾아서 인스턴스를 생성
				IController controller = (IController) Class.forName(value).newInstance();

				controllerMap.put(key, controller);

				System.out.printf("%s 의 컨트롤 %s 등록", key, value);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}
}
