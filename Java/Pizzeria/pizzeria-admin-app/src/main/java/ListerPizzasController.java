import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dta.pizzeria.dao.PizzaDaoImpl;

@WebServlet("/pizzas/list")
public class ListerPizzasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PizzaDaoImpl dao = Dao.DAO;




	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pizzas", this.dao.findAll());
		RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
		disp.forward(request, response);
	}

}
