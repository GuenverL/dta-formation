package dta.pizzeria.dao;

import java.io.IOException;
import java.util.List;

import dta.pizzeria.exception.StockageException;

public interface IDao<T> {

	List<T> findAll() throws StockageException;

	int find(String code);

	void saveNew(T pizza) throws StockageException;

	void update(String codePizza, T pizza) throws StockageException;

	void delete(String codePizza) throws StockageException;

}
