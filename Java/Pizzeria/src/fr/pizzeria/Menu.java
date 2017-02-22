package fr.pizzeria;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private List<Action> actions = new ArrayList<Action>();

	public Menu() {
		this.actions.add(new ActionAfficherListe());
		this.actions.add(new ActionAjouterPizza());
	}

	public void afficher() {
		System.out.println("***** Pizzeria Administration *****");
		for (Action action : actions) {
			System.out.println((actions.indexOf(action) + 1) + ". " + action.getNom());
		}
	}

	public void faire(int choix) {
		actions.get(choix - 1).faire();
	}
}
