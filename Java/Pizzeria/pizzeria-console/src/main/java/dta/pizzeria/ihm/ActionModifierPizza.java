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
		
		String code;
		String nom;
		double prix;
		int choixcat;
		CategoriePizza[] cats = CategoriePizza.values();
		
		for (Pizza pizza : ihmTools.getDao().findAll()) {
			System.out.println(pizza.toString());
		}
		
		System.out.println("Veuillez choisir la pizza a modifier (entrez le code) :\n(99 pour abandonner).");

		String oldCode = ihmTools.getSc().nextLine();
		
		if (!("99".equals(oldCode))) {

			System.out.println("Veuiller saisir le code");
			code = ihmTools.getSc().nextLine();
			System.out.println("Veuiller saisir le nom (sans espace)");
			nom = ihmTools.getSc().nextLine();
			System.out.println("Veuiller saisir le prix");
			prix = ihmTools.getSc().nextDouble();

			System.out.println("Veuiller saisir un numero de categorie : ");
			for (CategoriePizza cat : cats) {
				System.out.print(cat.ordinal() + " : ");
				System.out.println(cat.toString());
			}
			choixcat = ihmTools.getSc().nextInt();

			try {
				ihmTools.getDao().saveNew(new Pizza(code, nom, prix, cats[choixcat]));
			} catch (StockageException e) {
				throw new StockageException(e.getMessage(), e);
			}
		}
	}
}
