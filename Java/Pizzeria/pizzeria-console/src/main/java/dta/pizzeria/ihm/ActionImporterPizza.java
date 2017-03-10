package dta.pizzeria.ihm;

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
