package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public abstract class Action {
	protected String nom;
	protected IPizzaDao dao;
	protected Scanner sc;

	public Action(IPizzaDao dao, Scanner sc) {
		this.dao = dao;
		this.sc = sc;
	}

	public String getNom() {
		return nom;
	}

	public void faire() {
	}
}
