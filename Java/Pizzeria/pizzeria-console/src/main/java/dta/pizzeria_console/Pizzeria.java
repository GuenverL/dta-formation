package dta.pizzeria_console;

import java.util.ResourceBundle;


import dta.pizzera_ihm.IhmTools;
import dta.pizzera_ihm.Menu;
import dta.pizzeria_dao.IDao;
import dta.pizzeria_model.Pizza;

public class Pizzeria {
	public static void main(String args[])
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		ResourceBundle bundle = ResourceBundle.getBundle("application");

		IDao<Pizza> instanceDaoImpl = (IDao<Pizza>) Class.forName(bundle.getString("daoImpl")).newInstance();

		IhmTools ihmTools = new IhmTools(instanceDaoImpl);
		new Pizza(null, null, 0, null).hashCode();

		Menu menu = new Menu(ihmTools);

		menu.lancer();

		ihmTools.getSc().close();
	}
}
