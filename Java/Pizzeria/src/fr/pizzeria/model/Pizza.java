package fr.pizzeria.model;

import java.lang.reflect.Field;

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
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
		}
		// return code + " - " + nom + " " + categorie + " " + " (" + prix + "
		// €).";
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
}
