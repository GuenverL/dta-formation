package dta.pizzeria.ihm;

import java.util.*;

public class Menu {

	private Scanner sc;
	private Map<Integer, Action> actions = new TreeMap<>();

	public void setActions(Map<Integer, Action> actions) {
		this.actions = actions;
	}

	public void afficher() {
		System.out.println("\n\n***** Pizzeria Administration *****");

		for (Map.Entry<Integer, Action> entree : this.actions.entrySet()) {
			System.out.println(entree.getKey() + ". " + entree.getValue().getNom());
		}

	}


	public void lancer() {
		int choix;

		do {
			this.afficher();

			choix = this.sc.nextInt();
			this.sc.nextLine();
			if (this.actions.get(choix) != null)
				this.actions.get(choix).faire();
			if (choix == 99)
				break;

		} while (true);
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

}
