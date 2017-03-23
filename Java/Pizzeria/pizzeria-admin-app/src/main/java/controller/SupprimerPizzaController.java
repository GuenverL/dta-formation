package controller;


import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import metier.PizzaService;

@WebServlet("/pizzas/del")
public class SupprimerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private PizzaService ps;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.ps.delete(req.getParameter("code"));
		resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}

}
