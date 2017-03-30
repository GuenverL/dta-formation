package dta.pizzeria.aspects;

import java.time.Duration;
import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dta.pizzeria.dao.PerformanceRepository;
import dta.pizzeria.model.Performance;
import dta.pizzeria.model.Pizza;

@Aspect
@Component
public class NoCodeAspect {

	@Autowired private PerformanceRepository repo;

	@Pointcut("execution(* dta.pizzeria.dao.PizzaDaoSpringDataJpa.save*(..))")
	private void onSave() {}

	@Before("dta.pizzeria.aspects.NoCodeAspect.onSave() && args(pizza)")
	private void saveOperation(JoinPoint jp, Pizza pizza) throws Throwable {
		String nom = pizza.getNom();
		int l = nom.length();
		if (pizza.getCode() == "")
			pizza.setCode(pizza.getNom().substring(0, l < 4 ? l : 4).toUpperCase());
	}

	@Pointcut("execution(* dta.pizzeria.dao.PizzaDaoSpringDataJpa.*(..))")
	private void onAction() {
	}

	@Around("dta.pizzeria.aspects.NoCodeAspect.onAction()")
	private void savePerformance(ProceedingJoinPoint pjp) throws Throwable {
		Performance p = new Performance();
		p.setDate(LocalDateTime.now());
		pjp.proceed();
		p.setTemps(Duration.between(p.getDate(), LocalDateTime.now()));
		this.repo.savePerf(p);
	}
}
