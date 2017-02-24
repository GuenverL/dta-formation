package fr.pizzeria.ihm;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class ActionSupprimerPizza extends Action {

	public ActionSupprimerPizza(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Supprimer une pizza";
	}

	@Override
	public void faire() {
		for (Pizza pizza : ihmTools.getDao().findAllPizzas()) {
			System.out.println(pizza.toString());
		}
		System.out.println("Veuillez choisir la pizza à supprimer (entrez le code) :\n(99 pour abandonner).");

		String code = ihmTools.getSc().nextLine();

		if (code.equals("99")) {

		} else
			try {
				ihmTools.getDao().deletePizza(code);
			} catch (StockageException e) {
				System.out.println("\nCette pizza n'existe pas\n");
			}
	}
}
