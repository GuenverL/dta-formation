package dta.pizzeria.ihm;

import java.util.Scanner;

import dta.pizzeria.dao.IDao;
import dta.pizzeria.dao.PizzaDaoImpl;
import dta.pizzeria.model.Pizza;

public class IhmTools {

	private IDao<Pizza> dao = new PizzaDaoImpl();
	private Scanner sc = new Scanner(System.in);

	public IhmTools(IDao<Pizza> instanceDaoImpl) {
		dao = instanceDaoImpl;
	}

	public IDao<Pizza> getDao() {
		return dao;
	}

	public Scanner getSc() {
		return sc;
	}
}
