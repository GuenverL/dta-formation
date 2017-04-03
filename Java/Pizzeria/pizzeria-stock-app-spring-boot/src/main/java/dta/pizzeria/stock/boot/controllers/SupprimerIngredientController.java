package dta.pizzeria.stock.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import dta.pizzeria.stock.boot.repositories.IngredientRepository;

@Controller
@RequestMapping("/ingredients/del")
public class SupprimerIngredientController {

	@Autowired private IngredientRepository repo;


	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public String del(@PathVariable("id") Integer id) {
		this.repo.deleteById(id);
		return "redirect:/ingredients";
	}
}
