package metier;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import dta.pizzeria.dao.PizzaDaoImpl;

public class DaoProd {
	@Produces
	@ApplicationScoped
	public PizzaDaoImpl getDao() {
		return new PizzaDaoImpl();
	}
}
