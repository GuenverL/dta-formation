package dta.pizzeria.ihm;

import org.springframework.stereotype.Controller;

import dta.pizzeria.model.Pizza;

@OptionMenu
@Controller
public class ActionAfficherListe extends Action {


	public ActionAfficherListe() {
		this.nom = "Lister les pizzas";
	}

	@Override
	public void faire() {
		for (Pizza pizza : this.dao.findAll()) {
			System.out.println(pizza.toString());
		}
		System.out.println("\n");
	}
}
