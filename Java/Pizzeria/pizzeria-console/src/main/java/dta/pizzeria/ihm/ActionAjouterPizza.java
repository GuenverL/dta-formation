package dta.pizzeria.ihm;

import org.springframework.stereotype.Controller;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.*;

@Controller
public class ActionAjouterPizza extends Action {

	public ActionAjouterPizza() {
		this.nom = "Ajouter une nouvelle pizza";
	}

	@Override
	public void faire() {
		String code;
		String nom;
		double prix;
		int choixcat;
		CategoriePizza[] cats = CategoriePizza.values();

		System.out.println("Veuiller saisir le code");
		code = this.sc.nextLine().toUpperCase();
		System.out.println("Veuiller saisir le nom (sans espace)");
		nom = this.sc.nextLine();
		System.out.println("Veuiller saisir le prix");
		prix = this.sc.nextDouble();

		System.out.println("Veuiller saisir un numero de categorie : ");
		for (CategoriePizza cat : cats) {
			System.out.print(cat.ordinal() + " : ");
			System.out.println(cat.toString());
		}
		choixcat = this.sc.nextInt();

		try {
			this.dao.saveNew(new Pizza(code, nom, prix, cats[choixcat]));
		} catch (StockageException e) {
			throw new StockageException(e.getMessage(), e);
		}

	}
}
