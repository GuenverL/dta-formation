package dta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("dta.pizzeria")
public class PizzeriaStockAppSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzeriaStockAppSpringBootApplication.class, args);
	}
}
