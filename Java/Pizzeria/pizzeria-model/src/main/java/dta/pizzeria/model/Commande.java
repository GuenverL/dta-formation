package dta.pizzeria.model;

import java.sql.Date;

import javax.persistence.*;


public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "numero_commande", nullable = false, unique = true)
	private Integer numero;
	@Enumerated(EnumType.STRING)
	@Column(name = "statut", length = 50, nullable = false)
	private StatutCommande statut;
	@Column(name = "date_commande", nullable = false)
	private Date date;
	@ManyToOne
	@JoinColumn(name = "Client_id")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "Livreur_id")
	private Client livreur;

}
