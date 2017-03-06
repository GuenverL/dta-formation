package dta.pizzeria_dao;

import java.util.List;

import dta.pizzeria.exception.StockageException;

public interface IDao<T> {

	List<T> findAll();

	int find(String code);

	void saveNew(T pizza) throws StockageException;

	void update(String codePizza, T pizza) throws StockageException;

	void delete(String codePizza) throws StockageException;

}
