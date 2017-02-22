package fr.pizzeria;

public class ActionAfficherListe extends Action {

	public ActionAfficherListe() {
		this.nom = "Lister les Pizza";
	}

	@Override
	public void faire() {
		System.out.println("je liste les pizzas");
	}
}
