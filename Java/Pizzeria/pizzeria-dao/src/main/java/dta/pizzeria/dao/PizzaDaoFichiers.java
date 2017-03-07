package dta.pizzeria.dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.model.CategoriePizza;
import dta.pizzeria.model.Pizza;


public class PizzaDaoFichiers implements IDao<Pizza> {

	public PizzaDaoFichiers() {
	}

	public List<Pizza> findAll() {
		List<Pizza> pizzas = new ArrayList<Pizza>();
		try {
			Files.list(Paths.get("data")).forEach(path -> {
				try {
					String[] PizzaStr = Files.readAllLines(path).get(0).split(";");
					pizzas.add(new Pizza(PizzaStr[0], PizzaStr[1], Double.parseDouble(PizzaStr[2]),
							CategoriePizza.VIANDE));
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pizzas;
	}
	@Override
	public int find(String code) {
		return 0;
	}

	@Override
	public void saveNew(Pizza pizza) throws StockageException {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("data", pizza.getCode() + ".txt"))) {
			writer.write(pizza.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String codePizza, Pizza pizza) throws StockageException {
		delete(codePizza);
		saveNew(pizza);
	}

	@Override
	public void delete(String codePizza) throws StockageException {
		try {
			Files.delete(Paths.get("data", codePizza + ".txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
