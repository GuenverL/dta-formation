package dta.pizzeria.ihm;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

@Controller
public class Menu {

	private Scanner sc;
	private Map<Integer, Action> actions = new TreeMap<>();

	@Autowired
	private ApplicationContext cont;

	@Autowired
	public Menu(Scanner sc) {
		super();
		this.sc = sc;
	}


	public void setActions(Map<Integer, Action> actions) {
		this.actions = actions;
	}

	public void afficher() {
		System.out.println("\n\n***** Pizzeria Administration *****");

		for (Map.Entry<Integer, Action> entree : this.actions.entrySet()) {
			System.out.println(entree.getKey() + ". " + entree.getValue().getNom());
		}

	}

	public void lancer() {
		int choix;

		do {
			this.afficher();

			choix = this.sc.nextInt();
			this.sc.nextLine();
			if (this.actions.get(choix) != null)
				this.actions.get(choix).faire();
			if (choix == 99)
				break;

		} while (true);
	}

	@PostConstruct
	public void init() {
		this.actions = new HashMap<>();
		this.actions.put(1, this.cont.getBean(ActionAfficherListe.class));
		this.actions.put(99, this.cont.getBean(ActionQuitter.class));
	}
}
