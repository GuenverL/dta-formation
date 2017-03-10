package dta.pizzeria.dao;

import java.util.List;
import javax.persistence.*;

import dta.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IDao<Pizza> {

	private EntityManagerFactory emf;

	public PizzaDaoJpa() {
		emf = Persistence.createEntityManagerFactory("pizzeria-console");
	}

	@Override
	public List<Pizza> findAll() {
		return emf.createEntityManager().createQuery("SELECT P FROM Pizza P", Pizza.class).getResultList();
	}

	@Override
	public void saveNew(Pizza pizza) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(pizza);
		et.commit();
		em.close();
	}

	@Override
	public void update(String codePizza, Pizza pizza) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza WHERE p.code = :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza oldPizza = query.getSingleResult();
		if (oldPizza != null) {
			pizza.setId(oldPizza.getId());
			em.merge(pizza);
		}
		et.commit();
		em.close();
	}

	@Override
	public void delete(String codePizza) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza WHERE p.code = :code", Pizza.class);
		query.setParameter("code", codePizza);
		Pizza pizza = query.getSingleResult();
		if (pizza != null) {
			em.remove(pizza);
		}

		et.commit();
		em.close();
	}

}
