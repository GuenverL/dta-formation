package dta.pizzeria.model;

import java.lang.reflect.Field;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import dta.pizzeria.exception.StockageException;

@Entity
@NamedQueries({ @NamedQuery(name = "pizza.findAll", query = "SELECT p FROM Pizza"),
		@NamedQuery(name = "pizza.findByCode", query = "SELECT p FROM Pizza WHERE p.code = :code") })
public class Pizza implements Comparable<Pizza> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "code", length = 5, nullable = false, unique = true)
	private String code;
	@Column(name = "nom", length = 50, nullable = false)
	private String nom;
	@Column(name = "prix", nullable = false)
	private double prix;
	@Enumerated(EnumType.STRING)
	@Column(name = "categorie", nullable = false)
	private CategoriePizza categorie;

	public Pizza() {
	}

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.code = code.toUpperCase();
		this.nom = nom;
		this.prix = prix;
		this.categorie = CategoriePizza.valueOf(categorie.toString().toUpperCase());
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Field field : this.getClass().getDeclaredFields()) {
				try {
					sb.append(field.get(this).toString());
					sb.append(" ");
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new StockageException("ToString error", e);
				}
		}
		return sb.toString();

	}

	@Override
	public int compareTo(Pizza o) {
		return this.code.compareTo(o.getCode());
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public double getPrix() {
		return prix;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Pizza rhs = (Pizza) obj;
		return new EqualsBuilder().
				append(code, rhs.code).
				append(nom, rhs.nom).
				append(prix, rhs.prix).
				append(categorie, categorie).
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
		return nom;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
}
