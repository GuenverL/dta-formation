package dta.pizzeria.console;

import java.util.ResourceBundle;
import java.util.logging.Level;

import dta.pizzeria.dao.IDao;
import dta.pizzeria.ihm.IhmTools;
import dta.pizzeria.ihm.Menu;
import dta.pizzeria.model.Pizza;

public class Pizzeria {

	private Pizzeria() {
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		ResourceBundle bundle = ResourceBundle.getBundle("application");

		IDao<Pizza> instanceDaoImpl = (IDao<Pizza>) Class.forName(bundle.getString("daoImpl")).newInstance();

		IhmTools ihmTools = new IhmTools(instanceDaoImpl);

		Menu menu = new Menu(ihmTools);

		menu.lancer();

		ihmTools.getSc().close();
	}
}
