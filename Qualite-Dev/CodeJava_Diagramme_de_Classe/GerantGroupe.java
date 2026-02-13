package APP_GESTION_GROUPE;

public interface GerantGroupe {

	/**
	 * 
	 * @param libelle
	 * @param type
	 * @param capacite
	 */
	Groupe creerGroupe(String libelle, TypeGroupe type, int capacite);

	/**
	 * 
	 * @param e
	 * @param g
	 */
	void affecterEtudiant(Etudiant e, Groupe g);

	/**
	 * 
	 * @param p
	 * @param c
	 */
	void creerGroupeAutomatiquement(Promotion p, Critere c);

	/**
	 * 
	 * @param criteres
	 */
	void definirCriteres(List<Critere> criteres);

	/**
	 * 
	 * @param libelle
	 * @param criteres
	 */
	Sondage creerSondage(String libelle, List<Critere> criteres);

}