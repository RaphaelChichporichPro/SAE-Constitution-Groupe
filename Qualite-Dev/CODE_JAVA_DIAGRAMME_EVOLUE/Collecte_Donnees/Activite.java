package APP_GESTION_GROUPE.Collecte_Donnees;

import java.util.*;
import APP_GESTION_GROUPE.*;

public class Activite {

	private Collection<Choix_Activite> sesChoixActivites;
	private String id_activite;
	private String libelle_activite;
	private String matiere_optionnelle;
	private boolean enseignement_anglais;
	private boolean covoiturage;
	private String periode_activite;

	public String getId_activite() {
		return this.id_activite;
	}

	public void setId_activite(String id_activite) {
		this.id_activite = id_activite;
	}

	public String getLibelle_activite() {
		return this.libelle_activite;
	}

	public void setLibelle_activite(String libelle_activite) {
		this.libelle_activite = libelle_activite;
	}

	public String getMatiere_optionnelle() {
		return this.matiere_optionnelle;
	}

	public void setMatiere_optionnelle(String matiere_optionnelle) {
		this.matiere_optionnelle = matiere_optionnelle;
	}

	public boolean isEnseignement_anglais() {
		return this.enseignement_anglais;
	}

	public void setEnseignement_anglais(boolean enseignement_anglais) {
		this.enseignement_anglais = enseignement_anglais;
	}

	public boolean isCovoiturage() {
		return this.covoiturage;
	}

	public void setCovoiturage(boolean covoiturage) {
		this.covoiturage = covoiturage;
	}

	public String getPeriode_activite() {
		return this.periode_activite;
	}

	public void setPeriode_activite(String periode_activite) {
		this.periode_activite = periode_activite;
	}

	/**
	 * 
	 * @param e
	 */
	public void ajouterEtudiant(Etudiant e) {
		// TODO - implement Activite.ajouterEtudiant
		throw new UnsupportedOperationException();
	}

}