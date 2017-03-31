package dta.pizzeria.stock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import dta.pizzeria.stock.model.Ingredient;
import dta.pizzeria.stock.repositories.IngredientRepository;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {
	@Autowired private IngredientRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listIngredients() {
		ModelAndView mav = new ModelAndView();
		List<Ingredient> ingredients = this.repo.findAll();
		mav.addObject("ingredients", ingredients);
		mav.setViewName("listerIngredient");
		return mav;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("ingredient", new Ingredient());
		return "ajouterIngredient";
	}

	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public String setupForm(Model model, @PathVariable("id") Integer id) {
		Ingredient i = new Ingredient();
		model.addAttribute("ingredient", i);
		model.addAttribute("id", id);
		return "editerIngredient";
	}
}
