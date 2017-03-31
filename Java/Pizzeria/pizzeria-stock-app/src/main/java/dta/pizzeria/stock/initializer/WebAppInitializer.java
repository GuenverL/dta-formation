package dta.pizzeria.stock.initializer;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import dta.pizzeria.stock.config.PizzeriaAppSpringMvcConfig;

public class WebAppInitializer implements WebApplicationInitializer {

	public static final Logger LOG = Logger.getLogger(WebAppInitializer.class.getName());

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		System.out.println("Server launch");

		AnnotationConfigWebApplicationContext wc = new AnnotationConfigWebApplicationContext();
		wc.register(PizzeriaAppSpringMvcConfig.class);

		ServletRegistration.Dynamic d = sc.addServlet("dispatcher", new DispatcherServlet(wc));
		d.setLoadOnStartup(1);

		d.addMapping("/mvc/*");
		sc.addListener(new ContextLoaderListener(wc));
	}

}
