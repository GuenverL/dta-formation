package dta.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.List;

import dta.pizzeria.console.PizzeriaAppSpringConfig;
import dta.pizzeria.dao.IDao;
import dta.pizzeria.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PizzeriaAppSpringConfig.class)
public class PizzaDaoTest {

	@Autowired @Qualifier("pizzaDao1") private IDao<Pizza> dao;

	@Test
	public void testFindAll() {
		this.dao.saveNew(new Pizza("A", "a", 1, CategoriePizza.SANS_VIANDE));
		this.dao.saveNew(new Pizza("B", "b", 2, CategoriePizza.VIANDE));
		this.dao.saveNew(new Pizza("C", "c", 3, CategoriePizza.POISSON));

		List<Pizza> ps = this.dao.findAll();
		assertTrue(ps.stream().anyMatch(p -> "A".equals(p.getCode())));
		assertTrue(ps.stream().anyMatch(p -> "b".equals(p.getNom())));
		assertTrue(ps.stream().anyMatch(p -> "C".equals(p.getCode())));
		this.dao.delete("A");
		this.dao.delete("B");
		this.dao.delete("C");
	}

}
