package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ActionAfficherListe extends Action {

	public ActionAfficherListe(IPizzaDao dao, Scanner sc) {
		super(dao, sc);
		this.nom = "Lister les Pizza";
	}

	@Override
	public void faire() {
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza.toString());
		}
		System.out.println("\n");
	}
}
