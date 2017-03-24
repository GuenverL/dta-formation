package listener;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import event.*;
import metier.TechniqueService;

@ApplicationScoped
public class PizzaListener {

	@Inject
	private TechniqueService ts;

	public void creerPizza(@Observes CreerPizzaEvent e) {
		this.ts.add(e.getPizza(), e.getTime());
	}

	public void modifierPizza(@Observes ModifierPizzaEvent e) {
		this.ts.update(e.getPizza(), e.getTime());

	}

	public void suppressionPizza(@Observes SuppressionPizzaEvent e) {
		this.ts.delete(e.getPizza(), e.getTime());

	}
}
