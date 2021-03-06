package dta.pizzeria.console;

import java.util.Scanner;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import dta.pizzeria.dao.*;
import dta.pizzeria.model.Pizza;

@Configuration
@ComponentScan("dta.pizzeria")
@EnableJpaRepositories("dta.pizzeria")
@EnableAspectJAutoProxy
@EnableWebMvc
public class PizzeriaAppSpringConfig {


	@Bean
	public Scanner sc() {
		return new Scanner(System.in);
	}

	@Bean
	public EmbeddedDatabase getData() {

		// DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// dataSource.setUrl("jdbc:h2:mem:test");
		// dataSource.setUsername("root");
		// dataSource.setPassword("");
		// dataSource.setDriverClassName("org.h2.Driver");
		// return dataSource;

		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("schema.sql").build();
	}

	@Bean
	@Qualifier("pizzaDao1")
	public IDao<Pizza> pizzaDao() {
		return new PizzaDaoSpringDataJpa();
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

