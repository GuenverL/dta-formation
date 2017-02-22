package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {

	private List<Pizza> pizzas;

	public PizzaDaoImpl(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public int findPizza(String code) {
		int index = -1;
		for (Pizza pizza : pizzas) {
			if (pizza.getCode().equals(code)) {
				index = pizzas.indexOf(pizza);
			}
		}
		return index;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		return pizzas.add(pizza);
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza newPizza) {
		int index = findPizza(codePizza);
		if (index > -1) {
			pizzas.set(index, newPizza);
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		int index = findPizza(codePizza);
		if (index > -1) {
			pizzas.remove(index);
			return true;
		}
		return false;
	}

}
