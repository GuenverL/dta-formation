package event;

import java.time.LocalDateTime;

import dta.pizzeria.model.Pizza;

public class SuppressionPizzaEvent {
	private Pizza pizza;
	private LocalDateTime time;

	public SuppressionPizzaEvent(Pizza newPizza, LocalDateTime now) {
		this.pizza = newPizza;
		this.time = now;
	}

}
