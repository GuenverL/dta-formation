package metier;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import dta.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB {

	@PersistenceContext(unitName = "pizzeria-admin-app")
	private EntityManager em;

	public List<Pizza> findAll() {
		return this.em.createNamedQuery("pizza.findAll", Pizza.class).getResultList();
	}

	public void saveNew(Pizza pizza) {
		this.em.persist(pizza);
	}

	public void update(String codePizza, Pizza pizza) {
		Pizza oldPizza = this.em.createNamedQuery("pizza.findByCode", Pizza.class).setParameter("code", codePizza).getSingleResult();
		if (oldPizza != null) {
			pizza.setId(oldPizza.getId());
			this.em.merge(pizza);
		}
	}

	public void delete(String codePizza) {
		Pizza pizza = this.em.createNamedQuery("pizza.findByCode", Pizza.class).setParameter("code", codePizza).getSingleResult();
		if (pizza != null) {
			this.em.remove(pizza);
		}
	}


	public Pizza findPizza(String codePizza) {
		return this.em.createNamedQuery("pizza.findByCode", Pizza.class).setParameter("code", codePizza).getSingleResult();
	}

}
