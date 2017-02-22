package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {

	private List<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaDaoImpl() {
		pizzas.add(new Pizza("PEP", "Pépéroni       ", 12.50));
		pizzas.add(new Pizza("MAR", "Margherita     ", 14.00));
		pizzas.add(new Pizza("REI", "La Reine       ", 11.50));
		pizzas.add(new Pizza("FRO", "Les 4 fromages ", 12.00));
		pizzas.add(new Pizza("CAN", "La Cannibale   ", 12.50));
		pizzas.add(new Pizza("SAV", "La savoyarde   ", 13.00));
		pizzas.add(new Pizza("ORI", "L'orientale    ", 13.50));
		pizzas.add(new Pizza("IND", "L'indienne     ", 14.00));
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
