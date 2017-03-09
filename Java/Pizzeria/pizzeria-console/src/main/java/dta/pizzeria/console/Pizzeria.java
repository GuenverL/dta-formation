package dta.pizzeria.console;

import dta.pizzeria.dao.IDao;
import dta.pizzeria.dao.PizzaDaoJDBC;
import dta.pizzeria.ihm.IhmTools;
import dta.pizzeria.ihm.Menu;
import dta.pizzeria.model.Pizza;

public class Pizzeria {

	private Pizzeria() {
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		/*
		 * ResourceBundle bundle = ResourceBundle.getBundle("application");
		 * 
		 * @SuppressWarnings("unchecked") IDao<Pizza> instanceDaoImpl =
		 * (IDao<Pizza>)
		 * Class.forName(bundle.getString("daoImpl")).newInstance();
		 */

		IDao<Pizza> instanceDaoImpl = new PizzaDaoJDBC();
		IhmTools ihmTools = new IhmTools(instanceDaoImpl);
		new Pizza(null, null, 0, null).hashCode();

		Menu menu = new Menu(ihmTools);

		menu.lancer();

		ihmTools.getSc().close();
		ihmTools.getDao().close();
	}
}
