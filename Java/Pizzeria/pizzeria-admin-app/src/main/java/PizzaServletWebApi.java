

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dta.pizzeria.dao.PizzaDaoImpl;
import dta.pizzeria.model.CategoriePizza;
import dta.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzaServletWebApi
 */
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PizzaDaoImpl dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PizzaServletWebApi() {
		super();
		this.dao = new PizzaDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pizza> pizzas = this.dao.findAll();
		response.getWriter().append("<table>");

		for (Pizza pizza : pizzas) {
			response.getWriter().append("<tr><td>");
			response.getWriter().append(pizza.toString());
			response.getWriter().append("</td></tr>");
		}
		response.getWriter().append("</table>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		String cat = request.getParameter("categorie");
		this.dao.saveNew(new Pizza(code, nom, Double.parseDouble(prix), CategoriePizza.valueOf(cat.toUpperCase())));
		this.doGet(request, response);
	}

}
