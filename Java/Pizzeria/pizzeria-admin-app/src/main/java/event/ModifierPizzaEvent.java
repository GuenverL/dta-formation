package event;

import java.time.LocalDateTime;

import dta.pizzeria.model.Pizza;

public class ModifierPizzaEvent {
	private Pizza pizza;
	private LocalDateTime time;

	public ModifierPizzaEvent(Pizza newPizza, LocalDateTime now) {
		this.pizza = newPizza;
		this.time = now;
	}

}
