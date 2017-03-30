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
		this.dao.saveNew(new Pizza("", "ab", 1, CategoriePizza.SANS_VIANDE));
		this.dao.saveNew(new Pizza("", "bcag", 2, CategoriePizza.VIANDE));
		this.dao.saveNew(new Pizza("", "cabdfhdg", 3, CategoriePizza.POISSON));


		List<Pizza> ps = this.dao.findAll();
		assertTrue(ps.stream().anyMatch(p -> "AB".equals(p.getCode())));
		assertTrue(ps.stream().anyMatch(p -> "BCAG".equals(p.getCode())));
		assertTrue(ps.stream().anyMatch(p -> "CABD".equals(p.getCode())));

		// this.dao.delete("A");
		// this.dao.delete("B");
		// this.dao.delete("C");

		System.out.println(this.dao.findAll());
	}

}
