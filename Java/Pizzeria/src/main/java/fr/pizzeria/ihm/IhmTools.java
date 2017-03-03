package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

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
