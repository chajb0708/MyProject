package kr.or.nextit.common.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.function.service.ComCodeService;
import kr.or.nextit.function.service.CommCodeVo;
import kr.or.nextit.function.service.impl.ComCodeServiceImpl;

@WebFilter(filterName="IpcheckFilter", urlPatterns= {"/test123/*"})
public class IpcheckFilter implements Filter {
	
	private Map<String, String> ipMap;
	
	private ComCodeService codeService;
	
	private List<CommCodeVo> ipList = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//HttpServletRequest myreq = (HttpServletRequest) req;
		//HttpServletResponse myresp = (HttpServletResponse) resp;
		
		String ip = req.getRemoteAddr();
		
		if(ip != null && ipMap.containsKey(ip)) {
			// 존재하는 IP (Access/ Deny)
			if("A".equals(ipMap.get(ip))) { //허용
				System.out.println("존재하는 IP 승인 ==========");
				chain.doFilter(req, resp);
			} else {
				System.out.println("존재하지 않는 IP 거부 ==========");
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/Deny.jsp");
				dispatcher.forward(req, resp);
			}
		}else {
			// 존재하지 않는 IP
			// sendRedirect, forward
			System.out.println("존재하지 않는 IP index.jsp ==========");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Deny.jsp");
			dispatcher.forward(req, resp);
		}

	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		codeService = new ComCodeServiceImpl();
		
		try {
			ipList = codeService.getIpList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 초기화
		ipMap = new HashMap<>();
		ipMap.put("127.0.0.1", "A");
		ipMap.put("192.168.10.86", "A");
		ipMap.put("192.168.10.22", "A");
		ipMap.put("192.168.10.20", "A");
		
		System.out.println("ipMap data init() 등록된 IP 확인 !!!");
		Set<String> ipkey = ipMap.keySet();
		for (String key : ipkey) {
			System.out.println(String.format("IP Key = %s : 승인여부 = %s", key, ipMap.get(key)));
		}
	}

}
