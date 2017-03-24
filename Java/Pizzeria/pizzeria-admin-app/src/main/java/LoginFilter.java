

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

//@WebFilter(urlPatterns = { "/pizzas/*", "/technique" })
public class LoginFilter implements Filter {

	private FilterConfig config = null;

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if ("admin@admin.fr".equals(session.getAttribute("mail")) && "admin".equals(session.getAttribute("password"))) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/login");
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
		this.config.getServletContext().log("LoginFilter initialized");
	}

}
