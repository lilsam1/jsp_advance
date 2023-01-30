package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncFilter
 */
@WebFilter("*.jsp")	// @WebFilter : ���� ������ ���� �������̼�. �Ű������� URL���� �κ�
public class EncFilter extends HttpFilter implements Filter {
    private String encoding = null;	// ���ڿ� ������ �о�� �Ű����� ���� �����ϱ� ���� ���
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncFilter() {
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
		// ���� ó�� �޼���
		// ĳ���� ���ڵ� ������ ���� ��쿡�� ĳ���� ���ڵ� ����
		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(encoding);
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		// ���Ͱ� ó�� �ʱ�ȭ �� �� �� ���� ȣ��Ǵ� �޼���
		// ���� �ʱ�ȭ�� �ʱ�ȭ �Ķ���Ϳ��� ���ڵ� �⺻�� ������
		// web.xml�� �ʱ�ȭ �Ű������� 'encoding'���� ������ ���� ���ڿ� ���� encoding�� ����
		// ���� ������ ������ doFilter() �޼��忡�� �̷����
		this.encoding = fConfig.getServletContext().getInitParameter("encoding");
	}

}
