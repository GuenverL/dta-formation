package fr.pizzeria.ihm;

public class ActionSavePizzas extends Action {
	public ActionSavePizzas(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Sauvegarder les pizzas.";
	}

	@Override
	public void faire() {
		this.ihmTools.getDao().savePizzas();
	}
}
