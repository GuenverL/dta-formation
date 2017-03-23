package controller;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final String LOGIN_VIEW = "/WEB-INF/views/pizzas/login.jsp";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher disp = this.getServletContext().getRequestDispatcher(LOGIN_VIEW);
		disp.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().setAttribute("mail", req.getParameter("userMail"));
		req.getSession().setAttribute("password", req.getParameter("userPass"));
		resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}

}
