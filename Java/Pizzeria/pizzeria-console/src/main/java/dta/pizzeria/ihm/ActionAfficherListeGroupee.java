package dta.pizzeria.ihm;

import java.util.stream.Collectors;

import dta.pizzeria.model.Pizza;

public class ActionAfficherListeGroupee extends Action {
	public ActionAfficherListeGroupee() {
		this.nom = "Lister les pizzas par categorie.";
	}

	@Override
	public void faire() {
		this.dao.findAll().stream().collect(Collectors.groupingBy(Pizza::getCategorie))
		.forEach((k, v) -> {
			System.out.println(k);
			v.stream().forEach(System.out::println);
		});
	}

}
