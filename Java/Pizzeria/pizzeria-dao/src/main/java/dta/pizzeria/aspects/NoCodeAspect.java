package dta.pizzeria.aspects;

import java.time.*;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dta.pizzeria.dao.PerformanceRepository;
import dta.pizzeria.model.*;

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

	@Around("dta.pizzeria.aspects.NoCodeAspect.onSave()")
	private Object savePerformance(ProceedingJoinPoint pjp) throws Throwable {
		Performance p = new Performance();
		System.out.println(LocalDateTime.now());
		p.setService(pjp.getSignature().getName());
		p.setDate(LocalDateTime.now());
		Object proceed = pjp.proceed();
		p.setTemps(Duration.between(p.getDate(), LocalDateTime.now()));
		this.repo.save(p);
		return proceed;
	}
}
