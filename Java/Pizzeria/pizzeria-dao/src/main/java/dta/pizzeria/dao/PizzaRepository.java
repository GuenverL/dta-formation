package dta.pizzeria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dta.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

	default void deleteByCode(String codePizza) {
		delete(findByCode(codePizza));
	}

	default void updateByCode(String codePizza, Pizza pizza) {
		deleteByCode(codePizza);
		save(pizza);
	}

	Pizza findByCode(String codePizza);

}
