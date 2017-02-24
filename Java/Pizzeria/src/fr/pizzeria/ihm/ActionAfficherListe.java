package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class ActionAfficherListe extends Action {

	public ActionAfficherListe(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Lister les Pizza";
	}

	@Override
	public void faire() {
		for (Pizza pizza : ihmTools.getDao().findAllPizzas()) {
			System.out.println(pizza.toString());
		}
		System.out.println("\n");
	}
}
