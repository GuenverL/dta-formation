package metier;


public enum CategorieEvent {

	CREATION("créées"), MODIFICATION("modifiées"), SUPRESSION("supprimées");

	private String categorie;

	CategorieEvent(String categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return this.categorie;
	}
}
