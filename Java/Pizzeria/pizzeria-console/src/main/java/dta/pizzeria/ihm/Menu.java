package dta.pizzeria.ihm;

import java.util.Map;
import java.util.TreeMap;
import dta.pizzeria.exception.StockageException;

public class Menu {

	private IhmTools ihmTools;
	private Map<Integer, Action> actions = new TreeMap<>();

	public Menu(IhmTools ihmTools) {

		this.ihmTools = ihmTools;
		actions.put(1, new ActionAfficherListe(ihmTools));
		actions.put(2, new ActionAjouterPizza(ihmTools));
		actions.put(3, new ActionModifierPizza(ihmTools));
		actions.put(4, new ActionSupprimerPizza(ihmTools));
		actions.put(99, new ActionQuitter(ihmTools));
		 
	}

	public void afficher() {
		System.out.println("\n\n***** Pizzeria Administration *****");

		for (Map.Entry<Integer, Action> entree : actions.entrySet()) {
			System.out.println(entree.getKey() + ". " + entree.getValue().getNom());
		}

	}

	public void lancer() {
		int choix;

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
