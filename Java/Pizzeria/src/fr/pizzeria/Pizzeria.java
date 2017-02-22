package fr.pizzeria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Pizza;

public class Pizzeria {
	public static void main(String args[]) {

		List<Pizza> pizzas = new ArrayList<Pizza>();
		pizzas.add(new Pizza("PEP", "Pépéroni       ", 12.50));
		pizzas.add(new Pizza("MAR", "Margherita     ", 14.00));
		pizzas.add(new Pizza("REI", "La Reine       ", 11.50));
		pizzas.add(new Pizza("FRO", "Les 4 fromages ", 12.00));
		pizzas.add(new Pizza("CAN", "La Cannibale   ", 12.50));
		pizzas.add(new Pizza("SAV", "La savoyarde   ", 13.00));
		pizzas.add(new Pizza("ORI", "L'orientale    ", 13.50));
		pizzas.add(new Pizza("IND", "L'indienne     ", 14.00));

		IPizzaDao dao = new PizzaDaoImpl(pizzas);

		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu(dao, sc);
		menu.afficher();


		int choix = sc.nextInt();
		sc.nextLine();

		while (choix != 99) {
			menu.faire(choix);
			menu.afficher();
			choix = sc.nextInt();
			sc.nextLine();
		}

		System.out.println("Adios");

		sc.close();
	}
}
