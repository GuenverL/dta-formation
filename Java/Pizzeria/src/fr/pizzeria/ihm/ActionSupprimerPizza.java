package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ActionSupprimerPizza extends Action {

	public ActionSupprimerPizza(IPizzaDao dao, Scanner sc) {
		super(dao, sc);
		this.nom = "Supprimer une pizza";
	}

	@Override
	public void faire() {
		for (Pizza pizza : dao.findAllPizzas()) {
			System.out.println(pizza.toString());
		}
		System.out.println("Veuillez choisir la pizza à supprimer (entrez le code) :\n(99 pour abandonner).");

		String code = sc.nextLine();

		if (code.equals("99")) {

		} else if (!dao.deletePizza(code))
			System.out.println("\nCette pizza n'existe pas\n");
	}
}
