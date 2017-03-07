package dta.pizzeria.model;

import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Pizza implements Comparable<Pizza> {

	@ToString(uppercase = true)
	private String code;

	@ToString
	private String nom;

	@ToString
	private double prix;

	private CategoriePizza categorie;

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Field field : this.getClass().getDeclaredFields()) {
			ToString anno = field.getAnnotation(ToString.class);
			if(anno!=null)
				try {
					sb.append(field.get(this).toString());
					sb.append("  ");
				} catch (IllegalArgumentException | IllegalAccessException e) {
					throw new RuntimeException("ToString error", e);
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
}
