package dta.pizzera_ihm;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import dta.pizzera_ihm.OptionMenu;

public class Menu {

	private IhmTools ihmTools;
	private Map<Integer, Action> actions = new TreeMap<>();
	private int choix;

	public Menu(IhmTools ihmTools) {

		Reflections reflections = new Reflections("my.project");

		Set<Class<? extends Action>> actionClasses = reflections.getSubTypesOf(Action.class);

		List<? extends Action> listActions = actionClasses.stream()
				.filter(actions -> actions.getAnnotation(OptionMenu.class) != null).map(actions -> {
					return actions.newInstance();
				}).collect(Collectors.toList());

		for (int i = 0; i < listActions.size(); i++) {
			actions.put(i, listActions.get(i));
		}
	}

		/*
		 * Set<Class<?>> annotated =
		 * reflections.getTypesAnnotatedWith(OptionMenu.class);
		 * 
		 * this.ihmTools = ihmTools; this.actions.put(1, new
		 * ActionAfficherListe(ihmTools)); this.actions.put(4, new
		 * ActionAjouterPizza(ihmTools)); this.actions.put(5, new
		 * ActionModifierPizza(ihmTools)); this.actions.put(6, new
		 * ActionSupprimerPizza(ihmTools)); this.actions.put(2, new
		 * ActionAfficherListeGroupee(ihmTools)); this.actions.put(3, new
		 * ActionAfficherPlusChere(ihmTools));
		 * 
		 * this.actions.put(99, new ActionQuitter(ihmTools));
		 */

	}

	public void afficher() {
		System.out.println("\n\n***** Pizzeria Administration *****");

		for (Map.Entry<Integer, Action> entree : actions.entrySet()) {
			System.out.println(entree.getKey() + ". " + entree.getValue().getNom());
		}

	}

	public void lancer() {

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
