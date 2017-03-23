package controller;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dta.pizzeria.model.*;
import metier.PizzaService;

@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private PizzaService ps;
	private String oldCode;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pizza pizza = this.ps.findPizza(req.getParameter("code"));
		this.oldCode = pizza.getCode();
		req.setAttribute("pizza", pizza);
		RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
		disp.forward(req, resp);

	}

	/**
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.ps.update(this.oldCode, new Pizza(req.getParameter("pizzaCode"), req.getParameter("pizzaName"), Double.valueOf(req.getParameter("pizzaPrice")), CategoriePizza.valueOf((req.getParameter("pizzaCat")
						.toUpperCase()))));
		resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}

}
