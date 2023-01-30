package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class LogFileFilter
 */
//@WebFilter("/LogFileFilter")
public class LogFileFilter extends HttpFilter implements Filter {
	PrintWriter printWriter;
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LogFileFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		printWriter.close();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// ���͸� ���ҽ��� �����ϵ��� doFilter() �޼��� �ۼ�
		// ���� �Ͻø� ����ϵ��� ����� ���� �޼����� getCurrentTime()�� ȣ��
		printWriter.println("�����Ͻ�: " + getCurrentTime());
		String clientAddr = request.getRemoteAddr();	// Ŭ���̾�Ʈ�� �ּҸ� ���
		printWriter.println("Ŭ���̾�Ʈ �ּ�: " + clientAddr);
		
		chain.doFilter(request, response);
		
		String contentType = response.getContentType();
		printWriter.println("������ ������ ���� : " + contentType);
		printWriter.println("-------------------------------");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		// ���͸� �ʱ�ȭ
		// web.xml ������ <init-param> ��ҿ� ������ �Ű����� filename ���� ���޹޵���
		// filterConfig ��ü�� getInitParameter() �޼��� �ۼ�
		String filename = fConfig.getInitParameter("filename");
		if (filename == null) {
			throw new ServletException("�α� ������ �̸��� ã�� �� �����ϴ�");
		}
		try {
			printWriter = new PrintWriter(new FileWriter(filename, true), true);
		} catch (IOException e) {
			throw new ServletException("�α� ������ �� �� �����ϴ�");
		}
	}
	
	private String getCurrentTime() {
		// ������ �ð��� ������ ����� ���� �޼���
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return dateFormat.format(calendar.getTime());
	}

}
