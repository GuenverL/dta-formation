package event;

import java.time.LocalDateTime;

import dta.pizzeria.model.Pizza;

public class CreerPizzaEvent extends PizzaEvent {

	public CreerPizzaEvent(Pizza newPizza, LocalDateTime now) {
		super(newPizza, now);
	}
}
