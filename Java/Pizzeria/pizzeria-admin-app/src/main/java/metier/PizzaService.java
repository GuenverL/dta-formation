package metier;

import java.time.LocalDateTime;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import dta.pizzeria.dao.PizzaDaoImpl;
import dta.pizzeria.model.Pizza;
import event.CreerPizzaEvent;

public class PizzaService {

	@Inject
	private PizzaDaoImpl dao;
	@Inject
	private Event<CreerPizzaEvent> e;

	public Object findAll() {
		return this.dao.findAll();
	}

	public Pizza findPizza(String parameter) {
		return this.dao.findPizza(parameter);
	}

	public void update(String oldCode, Pizza pizza) {
		this.dao.update(oldCode, pizza);
	}

	public void saveNew(Pizza pizza) {
		this.dao.saveNew(pizza);
		this.e.fire(new CreerPizzaEvent(pizza, LocalDateTime.now()));
	}

	public void delete(String parameter) {
		this.dao.delete(parameter);
	}

}
