

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dta.pizzeria.dao.PizzaDaoImpl;

/**
 * Servlet implementation class ListerPizzasController
 */
public class ListerPizzasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PizzaDaoImpl dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerPizzasController() {
		super();
		this.dao = new PizzaDaoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pizzas", this.dao.findAll());
		RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
