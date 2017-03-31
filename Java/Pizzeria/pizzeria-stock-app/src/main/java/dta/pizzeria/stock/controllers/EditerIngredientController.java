package dta.pizzeria.stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import dta.pizzeria.stock.model.Ingredient;
import dta.pizzeria.stock.repositories.IngredientRepository;

@Controller
@RequestMapping("/ingredient/edit")
public class EditerIngredientController {
	private Integer id;

	@Autowired private IngredientRepository repo;

	@RequestMapping(method = RequestMethod.POST)
	public String save() {
		this.repo.save(new Ingredient());
		return "redirect:/mvc/ingredient";
	}

}
