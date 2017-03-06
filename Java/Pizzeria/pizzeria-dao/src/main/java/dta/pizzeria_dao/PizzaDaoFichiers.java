package dta.pizzeria_dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria_model.CategoriePizza;
import dta.pizzeria_model.Pizza;


public class PizzaDaoFichiers implements IPizzaDao<Pizza> {

	public PizzaDaoFichiers() {
	}

	public List<Pizza> findAllPizzas() {
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
	public int findPizza(String code) {
		return 0;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws StockageException {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("data", pizza.getCode() + ".txt"))) {
			writer.write(pizza.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws StockageException {
		deletePizza(codePizza);
		saveNewPizza(pizza);
	}

	@Override
	public void deletePizza(String codePizza) throws StockageException {
		try {
			Files.delete(Paths.get("data", codePizza + ".txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
