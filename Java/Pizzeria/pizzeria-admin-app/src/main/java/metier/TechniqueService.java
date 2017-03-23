package metier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dta.pizzeria.model.Pizza;

@ApplicationScoped
public class TechniqueService {
	private List<Pizza> pizzas = new ArrayList<>();

	public void add(Pizza pizza, LocalDateTime time) {
		this.pizzas.add(pizza);
	}

	public List<Pizza> getPizzas() {
		return this.pizzas;
	}

}
