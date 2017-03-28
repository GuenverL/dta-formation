package dta.pizzeria.console;

import java.util.logging.Level;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dta.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {

	private PizzeriaAdminConsoleApp() {
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml")) {
			Menu menu = context.getBean(Menu.class);
			menu.lancer();
		}
	}
}
