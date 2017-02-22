package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class Menu {


	private List<Action> actions = new ArrayList<Action>();

	public Menu(IPizzaDao dao, Scanner sc) {
		this.actions.add(new ActionAfficherListe(dao, sc));
		this.actions.add(new ActionAjouterPizza(dao, sc));
		this.actions.add(new ActionModifierPizza(dao, sc));
		this.actions.add(new ActionSupprimerPizza(dao, sc));
	}

	public void afficher() {
		System.out.println("***** Pizzeria Administration *****");

		for (Action action : actions) {
			System.out.println((actions.indexOf(action) + 1) + ". " + action.getNom());
		}

		System.out.println("99. Sortir");
	}

	public void faire(int choix) {
		if (choix > this.actions.size()) {
			System.out.println("\nmauvais choix !!\n");
		} else {
			actions.get(choix - 1).faire();
		}
	}
}
