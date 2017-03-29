package dta.pizzeria.dao;

import java.util.*;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dta.pizzeria.model.*;

@Repository
public class PizzaDaoSpringJpa implements IDao<Pizza> {

	private static final String PIZZA_FIND_BY_CODE = "pizza.findByCode";
	@PersistenceContext private EntityManager em;


	@Override
	public List<Pizza> findAll() {
		return this.em.createNamedQuery("pizza.findAll", Pizza.class).getResultList();
	}

	@Override
	@Transactional
	public void saveNew(Pizza pizza) {
		this.em.persist(pizza);
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		Pizza oldPizza = this.em.createNamedQuery(PIZZA_FIND_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
		if (oldPizza != null) {
			pizza.setId(oldPizza.getId());
			this.em.merge(pizza);
		}
	}

	@Override
	public void delete(String codePizza) {
		Pizza pizza = this.em.createNamedQuery(PIZZA_FIND_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
		if (pizza != null) {
			this.em.remove(pizza);
		}
	}


	public Pizza findPizza(String codePizza) {
		return this.em.createNamedQuery(PIZZA_FIND_BY_CODE, Pizza.class).setParameter("code", codePizza).getSingleResult();
	}
}