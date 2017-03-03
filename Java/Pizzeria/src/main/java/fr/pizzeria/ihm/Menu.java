package fr.pizzeria.ihm;

import java.util.Map;
import java.util.TreeMap;

public class Menu {

	private IhmTools ihmTools;
	private Map<Integer, Action> actions = new TreeMap<>();
	// private List<Action> actions = new ArrayList<Action>();
	private int choix;

	public Menu(IhmTools ihmTools) {
		this.ihmTools = ihmTools;
		this.actions.put(1, new ActionAfficherListe(ihmTools));
		this.actions.put(4, new ActionAjouterPizza(ihmTools));
		this.actions.put(5, new ActionModifierPizza(ihmTools));
		this.actions.put(6, new ActionSupprimerPizza(ihmTools));
		this.actions.put(2, new ActionAfficherListeGroupee(ihmTools));
		this.actions.put(3, new ActionAfficherPlusChere(ihmTools));

		this.actions.put(99, new ActionQuitter(ihmTools));

	}

	public void afficher() {
		System.out.println("\n\n***** Pizzeria Administration *****");

		for (Map.Entry<Integer, Action> entree : actions.entrySet()) {
			System.out.println(entree.getKey() + ". " + entree.getValue().getNom());
		}

	}

	public void lancer() {

		do {
			this.afficher();

			choix = ihmTools.getSc().nextInt();
			ihmTools.getSc().nextLine();
			if (actions.get(choix) != null)
				actions.get(choix).faire();
			if (choix == 99)
				break;

		} while (true);
	}
}
