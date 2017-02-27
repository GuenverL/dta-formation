package fr.pizzeria.dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao<Pizza> {

	private List<Pizza> pizzas = new ArrayList<Pizza>();

	public PizzaDaoImpl() {
		pizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "Les 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("CAN", "La Cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
		Collections.sort(pizzas);
	}


	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public int findPizza(String code) {
		int index = -1;
		for (Pizza pizza : pizzas) {
			if (pizza.getCode().equalsIgnoreCase(code)) {
				index = pizzas.indexOf(pizza);
			}
		}
		return index;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		if (!pizzas.add(pizza))
			throw new SavePizzaException();
		Collections.sort(pizzas);
	}

	@Override
	public void updatePizza(String codePizza, Pizza newPizza) throws UpdatePizzaException {
		int index = findPizza(codePizza);
		if (index > -1) {
			pizzas.set(index, newPizza);
			Collections.sort(pizzas);
		} else {
			throw new UpdatePizzaException();
		}
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		int index = findPizza(codePizza);
		if (index > -1) {
			pizzas.remove(index);
		} else {
			throw new DeletePizzaException();
		}
	}

	@Override
	public void savePizzas() {
		for (Pizza pizza : pizzas) {
			System.out.println();
			try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/data/" + pizza.getCode() + ".txt"))) {
				writer.write(pizza.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
