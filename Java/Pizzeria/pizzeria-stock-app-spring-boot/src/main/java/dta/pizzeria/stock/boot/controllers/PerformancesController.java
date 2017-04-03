package dta.pizzeria.stock.boot.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import dta.pizzeria.model.Performance;
import dta.pizzeria.stock.boot.repositories.PerformanceRepository;

@Controller
@RequestMapping("performances")
public class PerformancesController {
	@Autowired private PerformanceRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listPerformances() {
		ModelAndView mav = new ModelAndView();
		List<Performance> performances = this.repo.findAll();
		mav.addObject("performances", performances);
		mav.setViewName("performances");
		return mav;
	}
}
