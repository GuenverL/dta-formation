package controller;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import metier.PizzaService;

@WebServlet("/pizzas/list")
public class ListerPizzasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private PizzaService ps;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pizzas", this.ps.findAll());
		RequestDispatcher disp = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
		disp.forward(request, response);
	}

}
