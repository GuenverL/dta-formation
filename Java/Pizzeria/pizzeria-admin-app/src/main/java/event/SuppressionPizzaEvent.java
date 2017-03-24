package event;

import java.time.LocalDateTime;

import dta.pizzeria.model.Pizza;

public class SuppressionPizzaEvent extends PizzaEvent {

	public SuppressionPizzaEvent(Pizza newPizza, LocalDateTime now) {
		super(newPizza, now);
	}

}
