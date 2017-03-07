package dta.pizzeria.ihm;

import java.util.Comparator;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.Pizza;

public class ActionAfficherPlusChere extends Action {
	public ActionAfficherPlusChere(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Afficher la pizza la plus chere";
	}

	@Override
	public void faire() {

		ihmTools.getDao().findAll().stream().max(Comparator.comparing(Pizza::getPrix))
				.ifPresent(System.out::println);
	}
}
