

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dta.pizzeria.dao.PizzaDaoImpl;
import dta.pizzeria.model.*;

@WebServlet("/new")
public class AjouterPizzaController extends HttpServlet {
	private static final String NEW_PIZZA_VIEW = "/WEB-INF/views/pizzas/ajouterPizza.jsp";
	private static final long serialVersionUID = 1L;
	private PizzaDaoImpl dao = Dao.DAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pizza pizza = this.dao.findPizza(req.getParameter("code"));
		req.setAttribute("pizza", pizza);
		RequestDispatcher disp = this.getServletContext().getRequestDispatcher(NEW_PIZZA_VIEW);
		disp.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.dao.saveNew(new Pizza(req.getParameter("pizzaCode"), req.getParameter("pizzaName"), Double.valueOf(req.getParameter("pizzaPrice")), CategoriePizza.valueOf((req.getParameter("pizzaCat")
						.toUpperCase()))));
		resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}

}
