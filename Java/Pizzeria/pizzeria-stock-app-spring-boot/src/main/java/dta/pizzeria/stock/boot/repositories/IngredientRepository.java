package dta.pizzeria.stock.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dta.pizzeria.stock.boot.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

	default void deleteById(Integer i) {
		delete(findById(i));
	}

	default void updateById(int i, Ingredient ingredient) {
		deleteById(i);
		save(ingredient);
	}

	Ingredient findById(Integer i);

}
