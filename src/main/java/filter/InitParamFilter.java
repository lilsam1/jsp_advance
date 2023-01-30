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
 * Servlet Filter implementation class InitParamFilter
 */

public class InitParamFilter extends HttpFilter implements Filter {
    private FilterConfig filterConfig = null;
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public InitParamFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		// ���Ͱ� �����ϱ� ���� ȣ��
		System.out.println("Filter02 Clear... ");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// ���͸� ���ҽ��� ����
		System.out.println("Filter02 process...");
		// �� �信������ ���۵� ��û �Ķ������ ���̵�� ��й�ȣ�� ����
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// web.xml ������ <init-param> ��ҿ� ������ �Ű����� param1, param2�� ���޹޵���
		// FilterConfig.getInitParameter() �޼��带 �ۼ�
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
		
		String message;
		
		// ���� �� �������� ���� ���� ���ڵ�, ������ ������ �����ϵ��� response ���� ��ü�� �޼��� �ۼ�
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		
		// �� ���������� ���۵� ��û �Ķ���Ϳ� web.xml ���Ͽ� ������ �Ű������� ���� ���Ͽ� �޼��� ���
		if (id.equals(param1) && passwd.equals(param2)) {
			message = "�α��� �����߽��ϴ�";
		}
		else {
			message = "�α��� �����߽��ϴ�";
		}
		printWriter.println(message);

		// pass the request along the filter chain
		// ���������� ���Ͱ� ������ ���� ���ͷ� ��� �ѱ�
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		// ���� �ʱ�ȭ
		System.out.println("Filter02 init...");
		this.filterConfig = filterConfig;
	}

}