package dta.pizzeria.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dta.pizzeria.model.*;

@Repository
public class PizzaDaoSpringDataJpa implements IDao<Pizza> {

	@Autowired private PizzaRepository repo;

	@Override
	public List<Pizza> findAll() {
		return this.repo.findAll();
	}

	@Override
	@Transactional
	public void saveNew(Pizza pizza) {
		this.repo.save(pizza);
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		this.repo.updateByCode(codePizza, pizza);
	}

	@Override
	public void delete(String codePizza) {
		this.repo.deleteByCode(codePizza);
	}


	public Pizza findPizza(String codePizza) {
		return this.repo.findByCode(codePizza);
	}
}