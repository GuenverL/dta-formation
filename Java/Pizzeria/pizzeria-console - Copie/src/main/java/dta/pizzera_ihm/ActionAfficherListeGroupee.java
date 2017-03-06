package dta.pizzera_ihm;

import java.util.stream.Collectors;

import fr.pizzeria.model.Pizza;

public class ActionAfficherListeGroupee extends Action {
	public ActionAfficherListeGroupee(IhmTools ihmtools) {
		super(ihmtools);
		this.nom = "Lister les pizzas par categorie.";
	}

	@Override
	public void faire() {
		ihmTools.getDao().findAllPizzas().stream().collect(Collectors.groupingBy(Pizza::getCategorie))
				.forEach((k, v) -> {
					System.out.println(k);
					v.stream().forEach(System.out::println);
				});
	}

}
