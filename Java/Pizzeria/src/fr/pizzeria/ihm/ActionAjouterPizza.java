package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class ActionAjouterPizza extends Action {

	public ActionAjouterPizza(IPizzaDao dao, Scanner sc) {
		super(dao, sc);
		this.nom = "Ajouter une nouvelle pizza";
	}

	@Override
	public void faire() {
		String code, nom;
		double prix;

		System.out.println("Veuiller saisir le code");
		code = sc.nextLine();
		System.out.println("Veuiller saisir le nom (sans espace)");
		nom = sc.nextLine();
		System.out.println("Veuiller saisir le prix");
		prix = sc.nextDouble();

		try {
			dao.saveNewPizza(new Pizza(code, nom, prix));
		} catch (StockageException e) {
			System.err.println("Probl�me lors de l'ajout de la nouvelle pizza");
		}

	}
}