package dta.pizzeria.stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import dta.pizzeria.stock.model.Ingredient;
import dta.pizzeria.stock.repositories.IngredientRepository;

@Controller
@RequestMapping("/ingredient/add")
public class AjouterIngredientController {

	@Autowired private IngredientRepository repo;


	@RequestMapping(method = RequestMethod.POST)
	public String save(Ingredient i) {
		this.repo.save(i);
		return "redirect:/mvc/ingredient";
	}
}
