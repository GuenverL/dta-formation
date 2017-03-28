package dta.pizzeria.ihm;

import java.util.Scanner;

import dta.pizzeria.dao.IDao;
import dta.pizzeria.model.Pizza;

public abstract class Action {
	protected String nom;
	protected IDao<Pizza> dao;
	protected Scanner sc;


	public String getNom() {
		return this.nom;
	}

	public void faire() {
	}

	public void setDao(IDao<Pizza> dao) {
		this.dao = dao;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

}
