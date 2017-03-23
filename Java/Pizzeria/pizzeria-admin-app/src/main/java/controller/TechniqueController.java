package controller;


import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import metier.TechniqueService;

@WebServlet("/technique")
public class TechniqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TECH_VIEW = "/WEB-INF/views/pizzas/technique.jsp";
	@Inject
	private TechniqueService ts;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = this.getServletContext().getRequestDispatcher(TECH_VIEW);
		req.setAttribute("pizzas", this.ts.getPizzas());
		disp.forward(req, resp);
	}
}
