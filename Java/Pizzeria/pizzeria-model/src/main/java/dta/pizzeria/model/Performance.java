package dta.pizzeria.model;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.persistence.*;

import dta.pizzeria.exception.StockageException;

@Entity
public class Performance implements Comparable<Performance> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ToString
	@Column(name = "service", length = 50, nullable = false) private String service;
	@ToString
	@Column(name = "date", nullable = false) private LocalDateTime date;
	@ToString
	@Column(name = "temps", nullable = false) private Duration temps;

	public Performance() {
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Field field : this.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(ToString.class)) {
				try {
					sb.append(field.get(this).toString());
					sb.append(" ");
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new StockageException("ToString error", e);
				}
			}
		}
		return sb.toString();

	}


	@Override
	public int compareTo(Performance o) {
		return this.getService().compareTo(o.getService());
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the service
	 */
	public String getService() {
		return this.service;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(String service) {
		this.service = service;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return this.date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	/**
	 * @return the temps
	 */
	public Duration getTemps() {
		return this.temps;
	}



	/**
	 * @param temps
	 *            the temps to set
	 */
	public void setTemps(Duration temps) {
		this.temps = temps;
	}


}
