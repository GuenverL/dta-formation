package dta.pizzeria.ihm;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import dta.pizzeria.exception.StockageException;
import dta.pizzeria.ihm.OptionMenu;

public class Menu {

	private IhmTools ihmTools;
	private Map<Integer, Action> actions = new TreeMap<>();
	private int choix;

	public Menu(IhmTools ihmTools) {

		Reflections reflections = new Reflections("my.project");

		Set<Class<? extends Action>> actionClasses = reflections.getSubTypesOf(Action.class);

		List<? extends Action> listActions = actionClasses.stream()
				.filter(actionsCls -> actionsCls.getAnnotation(OptionMenu.class) != null).map(actionsCls -> {

					try {
						return actionsCls.newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
						throw new RuntimeException("Menu error", e);
					}

				}).collect(Collectors.toList());

		for (int i = 0; i < listActions.size(); i++) {
			actions.put(i, listActions.get(i));
		}
		this.ihmTools = ihmTools;
	}

	public void afficher() {
		System.out.println("\n\n***** Pizzeria Administration *****");

		for (Map.Entry<Integer, Action> entree : actions.entrySet()) {
			System.out.println(entree.getKey() + ". " + entree.getValue().getNom());
		}

	}

	public void lancer() throws StockageException {

		do {
			this.afficher();

			choix = ihmTools.getSc().nextInt();
			ihmTools.getSc().nextLine();
			if (actions.get(choix) != null)
				actions.get(choix).faire();
			if (choix == 99)
				break;

		} while (true);
	}
}
