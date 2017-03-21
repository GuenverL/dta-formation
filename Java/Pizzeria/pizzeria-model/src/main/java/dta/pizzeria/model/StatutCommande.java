package dta.pizzeria.model;

public enum StatutCommande {

	EN_ATTENTE("En_Attente"), EN_COURS("En_Cours"), COMPLETE("Complete");

	private String statut;

	StatutCommande(String statut) {
		this.statut = statut;
	}

	@Override
	public String toString() {
		return this.statut;
	}

}
