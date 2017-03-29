package dta.pizzeria.ihm;

import org.springframework.stereotype.Controller;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.CategoriePizza;
import dta.pizzeria.model.Pizza;

@Controller
public class ActionModifierPizza extends Action {

	public ActionModifierPizza() {
		this.nom = "Mettre a jour une pizza";
	}

	@Override
	public void faire() {

		String code;
		String nom;
		double prix;
		int choixcat;
		CategoriePizza[] cats = CategoriePizza.values();

		for (Pizza pizza : this.dao.findAll()) {
			System.out.println(pizza.toString());
		}

		System.out.println("Veuillez choisir la pizza a modifier (entrez le code) :\n(99 pour abandonner).");

		String oldCode = this.sc.nextLine();

		if (!("99".equals(oldCode))) {

			System.out.println("Veuiller saisir le code");
			code = this.sc.nextLine();
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
				this.dao.update(oldCode, new Pizza(code, nom, prix, cats[choixcat]));
			} catch (StockageException e) {
				throw new StockageException(e.getMessage(), e);
			}
		}
	}
}
