package dta.pizzeria.boot.aspects;

import java.time.*;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dta.pizzeria.model.*;
import dta.pizzeria.stock.boot.model.Ingredient;
import dta.pizzeria.stock.boot.repositories.PerformanceRepository;

@Aspect
@Component
public class BootAspect {

	@Autowired private PerformanceRepository repo;

	@Pointcut("execution(* dta.pizzeria.stock.boot.repositories.IngredientRepository.*(..))")
	private void onAction() {
	}

	@Before("dta.pizzeria.boot.aspects.BootAspect.onAction() && args(id)")
	private void deleteOperation(JoinPoint jp, Integer id) throws Throwable {
		Performance p = new Performance();
		p.setService("Suppression");
		p.setDate(LocalDateTime.now());
		p.setTemps(Duration.between(p.getDate(), LocalDateTime.now()));
		this.repo.save(p);
	}

	@Before("dta.pizzeria.boot.aspects.BootAspect.onAction() && args(ingredient)")
	private void deleteOperation(JoinPoint jp, Ingredient ingredient) throws Throwable {
		Performance p = new Performance();
		p.setService("Ajout");
		p.setDate(LocalDateTime.now());
		p.setTemps(Duration.between(p.getDate(), LocalDateTime.now()));
		this.repo.save(p);
	}

	@Before("dta.pizzeria.boot.aspects.BootAspect.onAction() && args(id,ingredient)")
	private void updateOperation(JoinPoint jp, Integer id, Ingredient ingredient) throws Throwable {
		Performance p = new Performance();
		p.setService("Modification");
		p.setDate(LocalDateTime.now());
		p.setTemps(Duration.between(p.getDate(), LocalDateTime.now()));
		this.repo.save(p);
	}

}
