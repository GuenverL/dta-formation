package dta.pizzeria.ihm;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.CategoriePizza;
import dta.pizzeria.model.Pizza;

public class ActionModifierPizza extends Action {

	public ActionModifierPizza(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Mettre a jour une pizza";
	}

	@Override
	public void faire() {
		
		String code, nom;
		double prix;
		
		for (Pizza pizza : ihmTools.getDao().findAll()) {
			System.out.println(pizza.toString());
		}
		
		System.out.println("Veuillez choisir la pizza a modifier (entrez le code) :\n(99 pour abandonner).");

		String oldCode = ihmTools.getSc().nextLine();
		
		if (oldCode.equals("99")) {
			
		} else {

			System.out.println("Veuiller saisir le code");
			code = ihmTools.getSc().nextLine();
			System.out.println("Veuiller saisir le nom (sans espace)");
			nom = ihmTools.getSc().nextLine();
			System.out.println("Veuiller saisir le prix");
			prix = ihmTools.getSc().nextDouble();

			try {
				ihmTools.getDao().update(oldCode, new Pizza(code, nom, prix, CategoriePizza.SANS_VIANDE));
			} catch (StockageException e) {
				System.out.println("\nCette pizza n'existe pas\n");
			}
		}
	}
}
