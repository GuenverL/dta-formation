package dta.pizzeria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dta.pizzeria.model.*;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {
	public default void savePerf(Performance perf) {
		save(perf);
	}
}
