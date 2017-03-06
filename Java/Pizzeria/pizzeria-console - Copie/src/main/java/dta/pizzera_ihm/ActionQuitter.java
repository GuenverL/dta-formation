package dta.pizzera_ihm;

public class ActionQuitter extends Action {
	public ActionQuitter(IhmTools ihmTools) {
		super(ihmTools);
		this.nom = "Sortir";
	}

	@Override
	public void faire() {
		System.out.println("Adios");
	}

}
