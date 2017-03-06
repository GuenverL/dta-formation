package dta.pizzera_ihm;

import dta.pizzeria.model.Pizza;

public class ActionAfficherListe extends Action {

	public ActionAfficherListe(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Lister les pizzas";
	}

	@Override
	public void faire() {
		for (Pizza pizza : ihmTools.getDao().findAllPizzas()) {
			System.out.println(pizza.toString());
		}
		System.out.println("\n");
	}
}
