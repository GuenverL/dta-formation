package dta.pizzeria.stock.model;

import javax.persistence.*;


@Entity
public class Ingredient {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer id;
	@Column(name = "nom", length = 50, nullable = false) private String nom;
	@Column(name = "prix", nullable = false) private double prix;
	@Column(name = "quantite", nullable = false) private int quantite;

	public Ingredient() {

	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
