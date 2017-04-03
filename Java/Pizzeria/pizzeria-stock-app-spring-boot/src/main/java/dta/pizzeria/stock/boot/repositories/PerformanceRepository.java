package dta.pizzeria.stock.boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dta.pizzeria.model.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

}
