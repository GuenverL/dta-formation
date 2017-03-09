package dta.pizzeria.dao;

import java.util.List;

public interface IDao<T> {

	List<T> findAll();

	void saveNew(T pizza);

	void update(String codePizza, T pizza);

	void delete(String codePizza);

	void importPizzas();

}
