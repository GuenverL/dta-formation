package fr.pizzeria.ihm;

import java.util.Comparator;

import fr.pizzeria.model.Pizza;

public class ActionAfficherPlusChere extends Action {
	public ActionAfficherPlusChere(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Afficher la pizza la plus chère";
	}

	@Override
	public void faire() {

		ihmTools.getDao().findAllPizzas().stream().max(Comparator.comparing(Pizza::getPrix))
				.ifPresent(System.out::println);
	}
}
