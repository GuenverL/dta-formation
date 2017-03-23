

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dta.pizzeria.dao.PizzaDaoImpl;

@WebServlet("/del")
public class SupprimerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PizzaDaoImpl dao = Dao.DAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.dao.delete(req.getParameter("code"));
		resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}

}
