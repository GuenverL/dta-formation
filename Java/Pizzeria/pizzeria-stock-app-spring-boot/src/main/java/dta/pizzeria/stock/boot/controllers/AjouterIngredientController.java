package dta.pizzeria.stock.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import dta.pizzeria.stock.boot.model.Ingredient;
import dta.pizzeria.stock.boot.repositories.IngredientRepository;

@Controller
@RequestMapping("/ingredients/add")
public class AjouterIngredientController {

	@Autowired private IngredientRepository repo;


	@RequestMapping(method = RequestMethod.POST)
	public String save(Ingredient i) {
		this.repo.save(i);
		return "redirect:/ingredients";
	}
}
