

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/technique")
public class TechniqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TECH_VIEW = "/WEB-INF/views/pizzas/technique.jsp";



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = this.getServletContext().getRequestDispatcher(TECH_VIEW);
		disp.forward(req, resp);
	}
}
