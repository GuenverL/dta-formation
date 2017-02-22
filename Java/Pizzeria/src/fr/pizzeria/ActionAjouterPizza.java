package fr.pizzeria;

public class ActionAjouterPizza extends Action {

	public ActionAjouterPizza() {
		this.nom = "Ajouter une nouvelle pizza";
	}

	@Override
	public void faire() {
		System.out.println("j'ajoute une pizza");
	}
}
