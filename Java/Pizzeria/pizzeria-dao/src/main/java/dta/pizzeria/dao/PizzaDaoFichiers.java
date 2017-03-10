package dta.pizzeria.dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import dta.pizzeria.exception.DeletePizzaException;
import dta.pizzeria.exception.SavePizzaException;
import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.CategoriePizza;
import dta.pizzeria.model.Pizza;


public class PizzaDaoFichiers implements IDao<Pizza> {

	@Override
	public List<Pizza> findAll() {
		List<Pizza> pizzas = new ArrayList<>();
		try {
			Files.list(Paths.get("data")).forEach(path -> pizzas.add(traitement(path)));
		} catch (IOException e) {
			throw new StockageException("Search error", e);
		}
		return pizzas;
	}

	private Pizza traitement(Path path) {
		String[] pizzaStr;
		try {
			pizzaStr = Files.readAllLines(path).get(0).split(" ");
			return new Pizza(pizzaStr[0], pizzaStr[1], Double.parseDouble(pizzaStr[2]),
					CategoriePizza.valueOf(pizzaStr[3].toUpperCase()));
		} catch (IOException e) {
			throw new StockageException("error", e);
		}
	}


	@Override
	public void saveNew(Pizza pizza) {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("data", pizza.getCode() + ".txt"))) {
			writer.write(pizza.toString());
		} catch (IOException e) {
			throw new SavePizzaException("Save error", e);
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		delete(codePizza);
		saveNew(pizza);
	}

	@Override
	public void delete(String codePizza) {
		try {
			Files.delete(Paths.get("data", codePizza + ".txt"));
		} catch (IOException e) {
			throw new DeletePizzaException("delete error", e);
		}
	}

}
