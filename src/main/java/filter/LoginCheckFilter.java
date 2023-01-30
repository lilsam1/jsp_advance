package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
//@WebFilter("/LoginCheckFilter")
public class LoginCheckFilter extends HttpFilter implements Filter {
	 private FilterConfig fConfig = null;
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginCheckFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// 폼 페이지에서 전송된 요청 파라미터인 아이디와 비밀번호를 전달
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// web.xml 파일의 <init-param> 요소에 설정된 매개변수 param1, param2를 전달받도록
		// FilterConfig.getInitParameter() 메서드를 작성
		String param1 = fConfig.getInitParameter("param1");
		String param2 = fConfig.getInitParameter("param2");
		
		String error = request.getParameter("error");
		
		// 응답 웹 페이지에 대한 문자 인코딩, 콘텐츠 유형을 설정하도록 response 내장 객체의 메서드 작성
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		if (error != null && error.equals("1")) {
		}
		
		// 폼 페이지에서 전송된 요청 파라미터와 web.xml 파일에 설정된 매개변수의 값을 비교하여 메세지 출력
		if (id.equals(param1) && passwd.equals(param2)) {
			error = "0";
		}
		else {
			error = "1";
		}

		// pass the request along the filter chain
		// 연속적으로 필터가 있으면 다음 필터로 제어를 넘김
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.fConfig = fConfig;
	}

}
