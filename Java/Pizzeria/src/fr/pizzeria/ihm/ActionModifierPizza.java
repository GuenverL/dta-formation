package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ActionModifierPizza extends Action {

	public ActionModifierPizza(IPizzaDao dao, Scanner sc) {
		super(dao, sc);
		this.nom = "Mettre à jour une Pizza";
	}

	@Override
	public void faire() {
		
		String code, nom;
		double prix;
		
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza.toString());
		}
		
		System.out.println("Veuillez choisir la pizza à modifier (entrez le code) :\n(99 pour abandonner).");

		String oldCode = sc.nextLine();
		
		if (oldCode.equals("99")) {
			
		}else if(dao.findPizza(oldCode) < 0) {
			System.out.println("\nCette pizza n'existe pas\n");
		} else {

			System.out.println("Veuiller saisir le code");
			code = sc.nextLine();
			System.out.println("Veuiller saisir le nom (sans espace)");
			nom = sc.nextLine();
			System.out.println("Veuiller saisir le prix");
			prix = sc.nextDouble();

			dao.updatePizza(oldCode, new Pizza(code, nom, prix));
		}
	}
}
