package fr.pizzeria;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.Menu;

public class Pizzeria {
	public static void main(String args[]) {

		IPizzaDao dao = new PizzaDaoImpl();

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
