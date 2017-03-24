package event;

import java.time.LocalDateTime;

import dta.pizzeria.model.Pizza;

public class ModifierPizzaEvent extends PizzaEvent {

	public ModifierPizzaEvent(Pizza newPizza, LocalDateTime now) {
		super(newPizza, now);
	}
}
