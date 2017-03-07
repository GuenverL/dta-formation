package dta.pizzeria.ihm;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.Pizza;

public class ActionSupprimerPizza extends Action {

	public ActionSupprimerPizza(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Supprimer une pizza";
	}

	@Override
	public void faire() {
		for (Pizza pizza : ihmTools.getDao().findAll()) {
			System.out.println(pizza.toString());
		}
		System.out.println("Veuillez choisir la pizza a supprimer (entrez le code) :\n(99 pour abandonner).");

		String code = ihmTools.getSc().nextLine();

		if (code.equals("99")) {

		} else
			try {
				ihmTools.getDao().delete(code);
			} catch (StockageException e) {
				System.out.println("\nCette pizza n'existe pas\n");
			}
	}
}
