package dta.pizzeria.ihm;

public class ActionImporterPizza extends Action {


	@Override
	public String getNom() {
		return "(BDD) Importer les donnees";
	}

	@Override
	public void faire() {
		this.dao.importPizzas();
	}


}
