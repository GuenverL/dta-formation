package dta.pizzera_ihm;

import java.util.Scanner;

import dta.pizzeria_dao.IDao;
import dta.pizzeria_dao.PizzaDaoImpl;
import dta.pizzeria_model.Pizza;

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
