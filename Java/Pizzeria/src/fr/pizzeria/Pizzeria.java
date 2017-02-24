package fr.pizzeria;

import fr.pizzeria.ihm.IhmTools;
import fr.pizzeria.ihm.Menu;

public class Pizzeria {
	public static void main(String args[]) {

		IhmTools ihmTools = new IhmTools();

		Menu menu = new Menu(ihmTools);

		menu.lancer();

		ihmTools.getSc().close();
	}
}
