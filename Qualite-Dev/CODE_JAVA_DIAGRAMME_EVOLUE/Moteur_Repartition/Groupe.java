package APP_GESTION_GROUPE.Moteur_Repartition;

import APP_GESTION_GROUPE.*;
import APP_GESTION_GROUPE.Collecte_Donnees.*;
import java.util.*;

public class Groupe {

	private Enseignant sonEnseignant;
	private Promotion saPromotion;
	private Collection<Groupe_Etudiant> sesGroupeEtudiants;
	private Collection<Critere> sesCriteres;
	private int id_groupe;
	private String libelle_groupe;
	private TypeGroupe type_groupe;
	private int capacite;
	private int nombreGroupe;

	public int getId_groupe() {
		return this.id_groupe;
	}

	public void setId_groupe(int id_groupe) {
		this.id_groupe = id_groupe;
	}

	public String getLibelle_groupe() {
		return this.libelle_groupe;
	}

	public void setLibelle_groupe(String libelle_groupe) {
		this.libelle_groupe = libelle_groupe;
	}

	public TypeGroupe getType_groupe() {
		return this.type_groupe;
	}

	public void setType_groupe(TypeGroupe type_groupe) {
		this.type_groupe = type_groupe;
	}

	public int getCapacite() {
		return this.capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public int getNombreGroupe() {
		return this.nombreGroupe;
	}

	public void setNombreGroupe(int nombreGroupe) {
		this.nombreGroupe = nombreGroupe;
	}

	/**
	 * 
	 * @param e
	 */
	public void ajouterEtudiant(Etudiant e) {
		// TODO - implement Groupe.ajouterEtudiant
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param e
	 */
	public void retirerEtudiant(Etudiant e) {
		// TODO - implement Groupe.retirerEtudiant
		throw new UnsupportedOperationException();
	}

	public boolean estComplet() {
		// TODO - implement Groupe.estComplet
		throw new UnsupportedOperationException();
	}

}