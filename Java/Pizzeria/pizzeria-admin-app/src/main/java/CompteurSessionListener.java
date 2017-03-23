import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class CompteurSessionListener implements HttpSessionListener {


	@Override
	public void sessionCreated(HttpSessionEvent se) {
		int cpt = 0;
		ServletContext cont = se.getSession().getServletContext();
		if ((Integer) cont.getAttribute("cpt") != null)
			cpt = (Integer) cont.getAttribute("cpt");
		cont.setAttribute("cpt", cpt + 1);
	}


	@Override
	public void sessionDestroyed(HttpSessionEvent se)  {
		ServletContext cont = se.getSession().getServletContext();
		int cpt = (Integer) cont.getAttribute("cpt");
		cont.setAttribute("cpt", cpt - 1);
	}

}
