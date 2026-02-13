package APP_GESTION_GROUPE;

public class Resp_Formation extends Enseignant implements GerantGroupe {

	/**
	 * 
	 * @param annee
	 * @param departement
	 * @param parcours
	 */
	public Promotion creerPromotion(int annee, String departement, String parcours) {
		// TODO - implement Resp_Formation.creerPromotion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param libelle
	 * @param type
	 * @param capacite
	 */
	public Groupe creerGroupe(String libelle, TypeGroupe type, int capacite) {
		// TODO - implement Resp_Formation.creerGroupe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param e
	 * @param g
	 */
	public void affecterEtudiant(Etudiant e, Groupe g) {
		// TODO - implement Resp_Formation.affecterEtudiant
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param p
	 * @param c
	 */
	public void creerGroupeAutomatiquement(Promotion p, Critere c) {
		// TODO - implement Resp_Formation.creerGroupeAutomatiquement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param criteres
	 */
	public void definirCriteres(List<Critere> criteres) {
		// TODO - implement Resp_Formation.definirCriteres
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param libelle
	 * @param criteres
	 */
	public Sondage creerSondage(String libelle, List<Critere> criteres) {
		// TODO - implement Resp_Formation.creerSondage
		throw new UnsupportedOperationException();
	}

}