package dta.pizzeria.dao;

import java.util.List;

public interface IDao<T> {

	List<T> findAll();

	int find(String code);

	void saveNew(T pizza);

	void update(String codePizza, T pizza);

	void delete(String codePizza);

	void close();

}
