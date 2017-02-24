package fr.pizzeria.ihm;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ActionModifierPizza extends Action {

	public ActionModifierPizza(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Mettre à jour une Pizza";
	}

	@Override
	public void faire() {
		
		String code, nom;
		double prix;
		
		for (Pizza pizza : ihmTools.getDao().findAllPizzas()) {
			System.out.println(pizza.toString());
		}
		
		System.out.println("Veuillez choisir la pizza à modifier (entrez le code) :\n(99 pour abandonner).");

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
				ihmTools.getDao().updatePizza(oldCode, new Pizza(code, nom, prix, CategoriePizza.SANS_VIANDE));
			} catch (StockageException e) {
				System.out.println("\nCette pizza n'existe pas\n");
			}
		}
	}
}
