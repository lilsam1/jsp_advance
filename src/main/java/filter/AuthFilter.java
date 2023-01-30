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
 * Servlet Filter implementation class AuthFilter
 */


public class AuthFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		// ���� �������� ȣ��
		System.out.println("Filter01.jsp clear...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// ���͸� ���ҽ��� ����
		System.out.println("Filter01.jsp ����...");
		String name = request.getParameter("name");	// ������������ ���۵� ��û �Ķ���͸� ����
		
		if (name == null || name.equals("")) {
			// ������������ ���۵� ��û �Ķ���Ͱ� ������ ���������� ����
			// chain.doFilter()�� �����ϱ� ���� ����
			
			// ���� �� �������� �޼����� ����ϵ��� ���� �� �������� ���� ���� ���ڵ�, ������ ����, �޼��� �ۼ�
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter printWriter = response.getWriter();
			String message = "�Էµ� name ���� null�Դϴ�";
			printWriter.println(message);
			return;
		}
		// ���������� ���Ͱ� ������ ���� ���ͷ� ��� �ѱ⵵�� FilterChain ��ü Ÿ���� doFilter() �޼��� �ۼ�
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		// ���͸� �ʱ�ȭ
		System.out.println("Filter01 init...");
	}

}
