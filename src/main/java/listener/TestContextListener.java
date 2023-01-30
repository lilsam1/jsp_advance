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
    	// 컨텍스트를 종료할 때 자동으로 호출되는 메서드
    	System.out.println("TestContextListener 종료되었습니다");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	// 컨텍스트를 초기화할 때 자동으로 호출되는 메서드
    	ServletContext ctx = sce.getServletContext();
    	Books mybook = new Books("자바 정복", "황희성", 20000, "출판사");
    	ctx.setAttribute("book", mybook);
    	System.out.println("TestContextListener 초기화되었습니다");
    }
	
}
