package dta.pizzeria.ihm;

import org.springframework.stereotype.Controller;

@OptionMenu
@Controller
public class ActionQuitter extends Action {
	public ActionQuitter() {
		this.nom = "Sortir";
	}

	@Override
	public void faire() {
		System.out.println("Adios");
	}

}
