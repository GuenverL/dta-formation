package dta.pizzeria.console;

import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import dta.pizzeria.dao.*;
import dta.pizzeria.ihm.Menu;
import dta.pizzeria.model.Pizza;

@Configuration
@ComponentScan("dta.pizzeria")
@EnableJpaRepositories("dta.pizzeria")
public class PizzeriaAppSpringConfig {


	@Bean
	public Scanner sc() {
		return new Scanner(System.in);
	}

	@Bean
	public EmbeddedDatabase getData() {

		/*
		 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
		 * dataSource.setUrl("jdbc:mysql://localhost:3306/pizzadb?useSSL=false");
		 * dataSource.setUsername("root");
		 * dataSource.setPassword("");
		 * dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		 * return dataSource;
		 */

		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql").build();
	}

	@Bean
	@Qualifier("pizzaDao1")
	public IDao<Pizza> pizzaDao() {
		return new PizzaDaoSpringDataJpa();
	}


	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {
			Menu menu = context.getBean(Menu.class);
			menu.lancer();
		}
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(this.entityManagerFactory());
		return txManager;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
		va.setGenerateDdl(true);
		LocalContainerEntityManagerFactoryBean f = new LocalContainerEntityManagerFactoryBean();
		f.setJpaVendorAdapter(va);
		f.setPackagesToScan("dta.pizzeria");
		f.setDataSource(this.getData());
		f.afterPropertiesSet();
		return f.getObject();
	}
}

