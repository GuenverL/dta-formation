package dta.pizzeria.dao;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.persistence.*;

import dta.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IDao<Pizza> {

	private EntityManagerFactory emf;

	public PizzaDaoJpa() {
		emf = Persistence.createEntityManagerFactory("pizzeria-console");
	}

	@Override
	public List<Pizza> findAll() {
		return emf.createEntityManager().createNamedQuery("pizza.findAll", Pizza.class).getResultList();
	}

	public void emGestion(Consumer<EntityManager> cem) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		cem.accept(em);
		et.commit();
		em.close();
	}

	@Override
	public void saveNew(Pizza pizza) {
		emGestion(em -> em.persist(pizza));
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		emGestion(em -> {
			Pizza oldPizza = em.createNamedQuery("pizza.findPizzaByCode", Pizza.class).setParameter("code", codePizza)
					.getSingleResult();
			if (oldPizza != null) {
				pizza.setId(oldPizza.getId());
				em.merge(pizza);
			}
		});
	}

	@Override
	public void delete(String codePizza) {
		emGestion(em -> {
			Pizza pizza = em.createNamedQuery("pizza.findPizzaByCode", Pizza.class).setParameter("code", codePizza)
					.getSingleResult();
			if (pizza != null) {
				em.remove(pizza);
			}
		});
	}

}
