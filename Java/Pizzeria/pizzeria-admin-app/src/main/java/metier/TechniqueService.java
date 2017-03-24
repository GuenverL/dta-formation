package metier;

import java.time.LocalDateTime;
import java.util.*;

import javax.enterprise.context.ApplicationScoped;

import dta.pizzeria.model.Pizza;
import event.*;

@ApplicationScoped
public class TechniqueService {
	private List<PizzaEvent> pizzasCreees = new ArrayList<>();
	private List<PizzaEvent> pizzasModifiees = new ArrayList<>();
	private List<PizzaEvent> pizzasSupprimees = new ArrayList<>();
	private HashMap<CategorieEvent, List<PizzaEvent>> events = new HashMap<>();

	public TechniqueService() {
		this.events.put(CategorieEvent.CREATION, this.pizzasCreees);
		this.events.put(CategorieEvent.MODIFICATION, this.pizzasModifiees);
		this.events.put(CategorieEvent.SUPRESSION, this.pizzasSupprimees);

	}

	public void add(Pizza pizza, LocalDateTime time) {
		this.events.get(CategorieEvent.CREATION).add(new CreerPizzaEvent(pizza, time));
	}

	public void update(Pizza pizza, LocalDateTime time) {
		this.events.get(CategorieEvent.MODIFICATION).add(new CreerPizzaEvent(pizza, time));

	}

	public void delete(Pizza pizza, LocalDateTime time) {
		this.events.get(CategorieEvent.SUPRESSION).add(new CreerPizzaEvent(pizza, time));

	}

	public Object getEvents() {
		return this.events;
	}

}
