package dta.pizzeria.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dta.pizzeria.exception.DeletePizzaException;
import dta.pizzeria.exception.SavePizzaException;
import dta.pizzeria.exception.UpdatePizzaException;
import dta.pizzeria.model.CategoriePizza;
import dta.pizzeria.model.Pizza;


public class PizzaDaoImpl implements IDao<Pizza> {

	private List<Pizza> pizzas = new ArrayList<>();

	public PizzaDaoImpl() {
		this.pizzas.add(new Pizza("PEP", "Peperoni", 12.50, CategoriePizza.VIANDE));
		this.pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		this.pizzas.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		this.pizzas.add(new Pizza("FRO", "Les 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		this.pizzas.add(new Pizza("CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		this.pizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		this.pizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		this.pizzas.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
		Collections.sort(this.pizzas);
	}


	@Override
	public List<Pizza> findAll() {
		return this.pizzas;
	}

	private int find(String code) {
		int index = -1;
		for (Pizza pizza : this.pizzas) {
			if (pizza.getCode().equalsIgnoreCase(code)) {
				index = this.pizzas.indexOf(pizza);
			}
		}
		return index;
	}

	public Pizza findPizza(String code) {
		for (Pizza pizza : this.pizzas) {
			if (pizza.getCode().equalsIgnoreCase(code)) {
				return pizza;
			}
		}
		return null;
	}

	@Override
	public void saveNew(Pizza pizza) {
		if (!this.pizzas.add(pizza))
			throw new SavePizzaException("Save error", null);
		Collections.sort(this.pizzas);
	}

	@Override
	public void update(String codePizza, Pizza newPizza) {
		int index = this.find(codePizza);
		if (index > -1) {
			this.pizzas.set(index, newPizza);
			Collections.sort(this.pizzas);
		} else {
			throw new UpdatePizzaException(codePizza, null);
		}
	}

	@Override
	public void delete(String codePizza) {
		int index = this.find(codePizza);
		if (index > -1) {
			this.pizzas.remove(index);
		} else {
			throw new DeletePizzaException(codePizza, null);
		}
	}
}
