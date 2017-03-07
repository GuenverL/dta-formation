package dta.pizzeria.ihm;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.CategoriePizza;
import dta.pizzeria.model.Pizza;
public class ActionAjouterPizza extends Action {

	public ActionAjouterPizza(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Ajouter une nouvelle pizza";
	}

	@Override
	public void faire() {
		String code, nom;
		double prix;
		int choixcat = 0;
		CategoriePizza[] cats = CategoriePizza.values();

		System.out.println("Veuiller saisir le code");
		code = ihmTools.getSc().nextLine().toUpperCase();
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
			System.err.println("Probleme lors de l'ajout de la nouvelle pizza");
		}

	}
}
