package dta.pizzeria;

import dta.pizzera_console.IhmTools;
import dta.pizzera_console.Menu;
import dta.pizzeria.model.Pizza;

public class Pizzeria {
	public static void main(String args[]) {

		IhmTools ihmTools = new IhmTools();
		new Pizza(null, null, 0, null).hashCode();

		Menu menu = new Menu(ihmTools);

		menu.lancer();

		ihmTools.getSc().close();
	}
}
