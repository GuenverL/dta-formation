package dta.pizzeria.ihm;

import java.util.stream.Collectors;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.Pizza;

public class ActionAfficherListeGroupee extends Action {
	public ActionAfficherListeGroupee(IhmTools ihmtools) {
		super(ihmtools);
		this.nom = "Lister les pizzas par categorie.";
	}

	@Override
	public void faire() throws StockageException {
		ihmTools.getDao().findAll().stream().collect(Collectors.groupingBy(Pizza::getCategorie))
				.forEach((k, v) -> {
					System.out.println(k);
					v.stream().forEach(System.out::println);
				});
	}

}
