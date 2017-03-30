package dta.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import dta.pizzeria.dao.IDao;
import dta.pizzeria.model.Pizza;

@Component
@Controller
public abstract class Action {
	protected String nom;
	protected IDao<Pizza> dao;
	protected Scanner sc;


	public String getNom() {
		return this.nom;
	}

	public void faire() {
	}

	@Autowired
	@Qualifier("pizzaDao1")
	public void setDao(IDao<Pizza> dao) {
		this.dao = dao;
	}

	@Autowired
	public void setSc(Scanner sc) {
		this.sc = sc;
	}

}
