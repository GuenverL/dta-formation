package dta.pizzeria.dao;

import java.util.List;

import dta.pizzeria.exception.StockageException;

public interface IDao<T> {

	List<T> findAll();

	void saveNew(T o);

	void update(String s, T o);

	void delete(String s);

	default void importPizzas() {
		throw new StockageException("Veuillez changez de configuration");
	}

}
