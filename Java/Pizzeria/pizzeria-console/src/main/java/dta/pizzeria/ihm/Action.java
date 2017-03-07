package dta.pizzeria.ihm;

import dta.pizzeria.exception.StockageException;

public abstract class Action {
	protected String nom;
	protected IhmTools ihmTools;

	public Action(IhmTools ihmTools) {
		this.ihmTools = ihmTools;
	}

	public String getNom() {
		return nom;
	}

	public void faire() {
	}
}
