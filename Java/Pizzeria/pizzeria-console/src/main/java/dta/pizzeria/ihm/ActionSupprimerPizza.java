package dta.pizzeria.ihm;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.Pizza;

public class ActionSupprimerPizza extends Action {

	public ActionSupprimerPizza() {
		this.nom = "Supprimer une pizza";
	}

	@Override
	public void faire() {
		for (Pizza pizza : this.dao.findAll()) {
			System.out.println(pizza.toString());
		}
		System.out.println("Veuillez choisir la pizza a supprimer (entrez le code) :\n(99 pour abandonner).");

		String code = this.sc.nextLine();

		if (!("99".equals(code))) {
			try {
				this.dao.delete(code);
			} catch (StockageException e) {
				throw new StockageException(e.getMessage(), e);
			}
		}
	}
}
