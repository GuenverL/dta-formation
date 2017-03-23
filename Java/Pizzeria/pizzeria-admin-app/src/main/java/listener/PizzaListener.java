package listener;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import event.*;
import metier.TechniqueService;


public class PizzaListener {

	@Inject
	private TechniqueService ts;

	public void creerPizza(@Observes CreerPizzaEvent e) {
		this.ts.add(e.getPizza(), e.getTime());
	}

	public void modifierPizza(@Observes ModifierPizzaEvent e) {

	}

	public void suppressionPizza(@Observes SuppressionPizzaEvent e) {

	}
}
