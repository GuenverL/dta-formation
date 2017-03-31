package dta.pizzeria.stock.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("dta.pizzeria.stock")
@EnableJpaRepositories("dta.pizzeria.stock")
@EnableTransactionManagement
@EnableWebMvc
public class PizzeriaAppSpringMvcConfig {

	@Bean
	public DriverManagerDataSource getData() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mariadb://localhost:3306/pizzadb");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		return dataSource;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
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
		f.setPackagesToScan("dta.pizzeria.stock");
		f.setDataSource(this.getData());
		f.setJpaProperties(this.additionalProperties());
		f.afterPropertiesSet();
		return f.getObject();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return properties;
	}
}
