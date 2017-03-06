package dta.pizzeria_dao;

import java.util.List;

import dta.pizzeria.exception.StockageException;

public interface IPizzaDao<T> {

	List<T> findAllPizzas();

	int findPizza(String code);

	void saveNewPizza(T pizza) throws StockageException;

	void updatePizza(String codePizza, T pizza) throws StockageException;

	void deletePizza(String codePizza) throws StockageException;

}
