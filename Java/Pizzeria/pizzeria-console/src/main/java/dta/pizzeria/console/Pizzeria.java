package dta.pizzeria.console;

import java.util.ResourceBundle;

import dta.pizzeria.dao.IDao;
import dta.pizzeria.exception.StockageException;
import dta.pizzeria.ihm.IhmTools;
import dta.pizzeria.ihm.Menu;
import dta.pizzeria.model.Pizza;

public class Pizzeria {
	public static void main(String args[])
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, StockageException {

		ResourceBundle bundle = ResourceBundle.getBundle("application");

		IDao<Pizza> instanceDaoImpl = (IDao<Pizza>) Class.forName(bundle.getString("daoImpl")).newInstance();

		IhmTools ihmTools = new IhmTools(instanceDaoImpl);
		new Pizza(null, null, 0, null).hashCode();

		Menu menu = new Menu(ihmTools);

		menu.lancer();

		ihmTools.getSc().close();
	}
}
