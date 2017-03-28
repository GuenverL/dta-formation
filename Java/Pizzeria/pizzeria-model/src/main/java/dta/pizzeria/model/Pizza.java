package dta.pizzeria.model;

import java.lang.reflect.Field;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import dta.pizzeria.exception.StockageException;

@Entity
@NamedQueries({ @NamedQuery(name = "pizza.findAll", query = "SELECT P FROM Pizza P"), @NamedQuery(name = "pizza.findByCode", query = "SELECT P FROM Pizza P WHERE P.code = :code") })
public class Pizza implements Comparable<Pizza> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ToString
	@Column(name = "code", length = 5, nullable = false, unique = true)
	private String code;
	@ToString
	@Column(name = "nom", length = 50, nullable = false)
	private String nom;
	@ToString
	@Column(name = "prix", nullable = false)
	private double prix;
	@ToString
	@Enumerated(EnumType.STRING)
	@Column(name = "categorie", nullable = false)
	private CategoriePizza categorie;

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.code = code.toUpperCase();
		this.nom = nom;
		this.prix = prix;
		this.categorie = CategoriePizza.valueOf(categorie.toString().toUpperCase());
	}

	public String getCode() {
		return this.code;
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
	public int compareTo(Pizza o) {
		return this.code.compareTo(o.getCode());
	}

	public CategoriePizza getCategorie() {
		return this.categorie;
	}

	public double getPrix() {
		return this.prix;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}
		Pizza rhs = (Pizza) obj;
		return new EqualsBuilder().
						append(this.code, rhs.code).
						append(this.nom, rhs.nom).
						append(this.prix, rhs.prix).
						append(this.categorie, this.categorie).
						isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).
						append(this.code).
						append(this.nom).
						append(this.prix).
						append(this.categorie).
						toHashCode();
	}

	public String getNom() {
		return this.nom;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
}
