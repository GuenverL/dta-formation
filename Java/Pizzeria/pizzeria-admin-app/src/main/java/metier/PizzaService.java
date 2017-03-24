package metier;

import java.time.LocalDateTime;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import dta.pizzeria.model.Pizza;
import event.*;

public class PizzaService {

	@EJB
	private PizzaServiceEJB ejb;
	@Inject
	private Event<PizzaEvent> e;

	public Object findAll() {
		return this.ejb.findAll();
	}

	public Pizza findPizza(String parameter) {
		return this.ejb.findPizza(parameter);
	}

	public void update(String oldCode, Pizza pizza) {
		this.e.fire(new ModifierPizzaEvent(this.ejb.findPizza(oldCode), LocalDateTime.now()));
		this.ejb.update(oldCode, pizza);
	}

	public void saveNew(Pizza pizza) {
		this.ejb.saveNew(pizza);
		this.e.fire(new CreerPizzaEvent(pizza, LocalDateTime.now()));
	}

	public void delete(String parameter) {
		this.e.fire(new SuppressionPizzaEvent(this.ejb.findPizza(parameter), LocalDateTime.now()));
		this.ejb.delete(parameter);
	}

}
