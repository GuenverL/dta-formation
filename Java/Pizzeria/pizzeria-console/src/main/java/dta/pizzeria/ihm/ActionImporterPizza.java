package dta.pizzeria.ihm;

import dta.pizzeria.exception.StockageException;

public class ActionImporterPizza extends Action {

	public ActionImporterPizza(IhmTools ihmTools) {
		super(ihmTools);
	}

	public String getNom() {
		return "(BDD) Importer les donnees";
	}

	public void faire() {
		ihmTools.getDao().importPizzas();
	}


}
