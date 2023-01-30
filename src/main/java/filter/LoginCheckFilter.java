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
		// �� ���������� ���۵� ��û �Ķ������ ���̵�� ��й�ȣ�� ����
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// web.xml ������ <init-param> ��ҿ� ������ �Ű����� param1, param2�� ���޹޵���
		// FilterConfig.getInitParameter() �޼��带 �ۼ�
		String param1 = fConfig.getInitParameter("param1");
		String param2 = fConfig.getInitParameter("param2");
		
		String error = request.getParameter("error");
		
		// ���� �� �������� ���� ���� ���ڵ�, ������ ������ �����ϵ��� response ���� ��ü�� �޼��� �ۼ�
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		if (error != null && error.equals("1")) {
		}
		
		// �� ���������� ���۵� ��û �Ķ���Ϳ� web.xml ���Ͽ� ������ �Ű������� ���� ���Ͽ� �޼��� ���
		if (id.equals(param1) && passwd.equals(param2)) {
			error = "0";
		}
		else {
			error = "1";
		}

		// pass the request along the filter chain
		// ���������� ���Ͱ� ������ ���� ���ͷ� ��� �ѱ�
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
