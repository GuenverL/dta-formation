package dta.pizzeria.console;

import java.util.Scanner;
import java.util.logging.Level;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.*;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import dta.pizzeria.dao.*;
import dta.pizzeria.ihm.Menu;
import dta.pizzeria.model.Pizza;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class PizzeriaAppSpringConfig {


	@Bean
	public Scanner sc() {
		return new Scanner(System.in);
	}

	@Bean
	public EmbeddedDatabase getData() {
		/*
		 * private DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 * this.dataSource.setUrl("jdbc:mysql://localhost:3306/pizzadb?useSSL=false");
		 * this.dataSource.setUsername("root");
		 * this.dataSource.setPassword("");
		 * dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		 *
		 */
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql").build();
	}

	@Bean
	public IDao<Pizza> pizzaDao() {
		return new PizzaDaoSpringJpa();
	}


	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {
			Menu menu = context.getBean(Menu.class);
			menu.lancer();
		}
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(this.getData());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		return new LocalContainerEntityManagerFactoryBean();
	}
}

