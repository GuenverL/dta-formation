package dta.pizzeria.ihm;

@OptionMenu
public class ActionQuitter extends Action {
	public ActionQuitter() {
		this.nom = "Sortir";
	}

	@Override
	public void faire() {
		System.out.println("Adios");
	}

}
