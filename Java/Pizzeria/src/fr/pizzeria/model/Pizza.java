package fr.pizzeria.model;

public class Pizza {

	private String code, nom;
	private double prix;

	public Pizza(String code, String nom, double prix) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + " - " + nom + " (" + prix + " €).";

	}

}
