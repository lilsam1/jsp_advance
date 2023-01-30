package listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestContextListener
 *
 */
@WebListener
public class TestContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	// ���ؽ�Ʈ�� ������ �� �ڵ����� ȣ��Ǵ� �޼���
    	System.out.println("TestContextListener ����Ǿ����ϴ�");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	// ���ؽ�Ʈ�� �ʱ�ȭ�� �� �ڵ����� ȣ��Ǵ� �޼���
    	ServletContext ctx = sce.getServletContext();
    	Books mybook = new Books("�ڹ� ����", "Ȳ��", 20000, "���ǻ�");
    	ctx.setAttribute("book", mybook);
    	System.out.println("TestContextListener �ʱ�ȭ�Ǿ����ϴ�");
    }
	
}
