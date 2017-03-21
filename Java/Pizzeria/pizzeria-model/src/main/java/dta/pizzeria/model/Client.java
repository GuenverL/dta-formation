package dta.pizzeria.model;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nom", length = 50, nullable = false)
	private String nom;
	@Column(name = "prenom", length = 50, nullable = false)
	private String prenom;
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	@Column(name = "mot_de_passe", length = 50, nullable = false)
	private String pass;
	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes;

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
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return this.pass;
	}

	/**
	 * @param pass
	 *            the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

}
