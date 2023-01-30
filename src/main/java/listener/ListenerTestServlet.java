package listener;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 *
 */
@WebListener("/ListenerTestServlet")
public class ListenerTestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ServletContext sc;
	
	public ListenerTestServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		sc = getServletContext();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sc.setAttribute("name", "全辨悼");
		
		HttpSession session = req.getSession();
		session.setAttribute("ssName", session.getId() + ": 技记 加己 历厘");
	}
	
    
	
}
