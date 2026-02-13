package APP_GESTION_GROUPE;

import APP_GESTION_GROUPE.Gestion_Utilisateur.*;
import java.util.*;
import APP_GESTION_GROUPE.Collecte_Donnees.*;
import APP_GESTION_GROUPE.Moteur_Repartition.*;

public abstract class Enseignant extends Utilisateur {

	private Collection<Sondage> sesSondages;
	private Collection<Groupe> sesGroupes;
	private Collection<Promotion> sesPromotions;
	private String matricule;
	private String nom;
	private String prenom;
	private String mail_ens;
	private String specialite;
	private String statut;

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail_ens() {
		return this.mail_ens;
	}

	public void setMail_ens(String mail_ens) {
		this.mail_ens = mail_ens;
	}

	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public abstract List<Groupe> consulterGroupes();

	public abstract List<Etudiant> consulterEtudiants();

}