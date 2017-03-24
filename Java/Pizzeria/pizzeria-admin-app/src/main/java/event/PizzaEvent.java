package event;

import java.time.LocalDateTime;

import dta.pizzeria.model.Pizza;

public class PizzaEvent {
	private Pizza pizza;
	private LocalDateTime time;

	public PizzaEvent(Pizza newPizza, LocalDateTime now) {
		this.pizza = newPizza;
		this.time = now;
	}

	public Pizza getPizza() {
		return this.pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public LocalDateTime getTime() {
		return this.time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}
