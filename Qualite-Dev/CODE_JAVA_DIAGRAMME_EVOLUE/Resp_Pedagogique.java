package APP_GESTION_GROUPE;

import APP_GESTION_GROUPE.Moteur_Repartition.*;
import APP_GESTION_GROUPE.Collecte_Donnees.*;

public class Resp_Pedagogique extends Enseignant implements GerantGroupe {

	/**
	 * 
	 * @param libelle
	 * @param type
	 * @param capacite
	 */
	public Groupe creerGroupe(String libelle, TypeGroupe type, int capacite) {
		// TODO - implement Resp_Pedagogique.creerGroupe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param e
	 * @param g
	 */
	public void affecterEtudiant(Etudiant e, Groupe g) {
		// TODO - implement Resp_Pedagogique.affecterEtudiant
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param p
	 * @param c
	 */
	public void creerGroupeAutomatiquement(Promotion p, Critere c) {
		// TODO - implement Resp_Pedagogique.creerGroupeAutomatiquement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param criteres
	 */
	public void definirCriteres(List<Critere> criteres) {
		// TODO - implement Resp_Pedagogique.definirCriteres
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param libelle
	 * @param criteres
	 */
	public Sondage creerSondage(String libelle, List<Critere> criteres) {
		// TODO - implement Resp_Pedagogique.creerSondage
		throw new UnsupportedOperationException();
	}

}