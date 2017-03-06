package dta.pizzera_ihm;

import java.util.Comparator;

import dta.pizzeria_model.Pizza;

public class ActionAfficherPlusChere extends Action {
	public ActionAfficherPlusChere(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Afficher la pizza la plus chere";
	}

	@Override
	public void faire() {

		ihmTools.getDao().findAllPizzas().stream().max(Comparator.comparing(Pizza::getPrix))
				.ifPresent(System.out::println);
	}
}
