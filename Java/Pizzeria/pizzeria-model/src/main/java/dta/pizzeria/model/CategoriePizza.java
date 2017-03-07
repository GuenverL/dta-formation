package dta.pizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String categorie;

	CategoriePizza(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return categorie;
	}

}
