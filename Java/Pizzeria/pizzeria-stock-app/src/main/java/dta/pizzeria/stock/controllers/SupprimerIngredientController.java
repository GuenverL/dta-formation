package dta.pizzeria.stock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import dta.pizzeria.stock.repositories.IngredientRepository;

@Controller
@RequestMapping("/ingredient/del")
public class SupprimerIngredientController {

	@Autowired private IngredientRepository repo;


	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public String del(@PathVariable("id") Integer id) {
		this.repo.deleteById(id);
		return "redirect:/mvc/ingredient";
	}
}
