package fr.pizzeria.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTest {
	private PizzaDaoImpl pizzaDao;

	@Before
	public void setUp() {
		pizzaDao = new PizzaDaoImpl();
	}

	@Test
	public void test_equals() {
		Pizza[] pizzas = new Pizza[3];
		pizzas[0] = new Pizza("ABC", "abc", 1, CategoriePizza.POISSON);
		pizzas[1] = new Pizza("ABC", "abc", 1, CategoriePizza.POISSON);
		pizzas[1] = new Pizza("ABC", "abc", 1, CategoriePizza.SANS_VIANDE);
		assertTrue(pizzas[0].equals(pizzas[1]));
	}

	/*
	 * @Test public void testFindAllPizzas() { fail("j'echoue"); }
	 * 
	 * @Test public void test_find_all() { List<Pizza> pizzas =
	 * pizzaDao.findAllPizzas(); assertEquals(9, pizzas.size()); }
	 * 
	 * @Test public void test_save() throws StockageException { Pizza pizza =
	 * new Pizza(null, null, 0, null); pizzaDao.saveNewPizza(pizza); List<Pizza>
	 * pizzas = pizzaDao.findAllPizzas(); assertEquals(8, pizzas.size());
	 * assertThat(pizzas.size(), is(8)); }
	 * 
	 * @Test public void test_save_valid() throws StockageException { Pizza
	 * pizza = new Pizza("TEST", "Test", 1.2, CategoriePizza.POISSON);
	 * pizzaDao.saveNewPizza(pizza); List<Pizza> pizzas =
	 * pizzaDao.findAllPizzas(); assertEquals(9, pizzas.size()); }
	 */

}
