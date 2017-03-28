package dta.pizzeria.ihm;

import java.util.Comparator;

import org.springframework.stereotype.Controller;

import dta.pizzeria.model.Pizza;

@Controller
public class ActionAfficherPlusChere extends Action {
	public ActionAfficherPlusChere() {
		this.nom = "Afficher la pizza la plus chere";
	}

	@Override
	public void faire() {

		this.dao.findAll().stream().max(Comparator.comparing(Pizza::getPrix))
		.ifPresent(System.out::println);
	}
}
