package dta.pizzeria.console;

import java.util.Scanner;
import java.util.logging.Level;

import org.springframework.context.annotation.*;
import dta.pizzeria.dao.*;
import dta.pizzeria.ihm.Menu;
import dta.pizzeria.model.Pizza;

@Configuration
@ComponentScan("dta.pizzeria.ihm")
public class PizzeriaAppSpringConfig {

	@Bean
	public Scanner sc() {
		return new Scanner(System.in);
	}

	@Bean
	public IDao<Pizza> pizzaDao() {
		return new PizzaDaoImpl();
	}


	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {
			Menu menu = context.getBean(Menu.class);
			menu.lancer();
		}
	}

}
