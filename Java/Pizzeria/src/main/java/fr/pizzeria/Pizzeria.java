package fr.pizzeria;

import fr.pizzeria.ihm.IhmTools;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Pizza;

public class Pizzeria {
	public static void main(String args[]) {

		IhmTools ihmTools = new IhmTools();
		new Pizza(null, null, 0, null).hashCode();

		Menu menu = new Menu(ihmTools);

		menu.lancer();

		ihmTools.getSc().close();
	}
}
