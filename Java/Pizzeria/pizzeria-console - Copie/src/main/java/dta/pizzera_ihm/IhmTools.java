package dta.pizzera_ihm;

import java.util.Scanner;

import dta.pizzeria.model.Pizza;
import dta.pizzeria_dao.IPizzaDao;
import dta.pizzeria_dao.PizzaDaoImpl;

public class IhmTools {

	private IPizzaDao<Pizza> dao = new PizzaDaoImpl();
	private Scanner sc = new Scanner(System.in);

	public IPizzaDao<Pizza> getDao() {
		return dao;
	}

	public Scanner getSc() {
		return sc;
	}
}
