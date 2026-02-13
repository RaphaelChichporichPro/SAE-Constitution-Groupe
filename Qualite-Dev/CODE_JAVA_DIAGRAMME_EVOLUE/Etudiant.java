package APP_GESTION_GROUPE;

import APP_GESTION_GROUPE.Gestion_Utilisateur.*;
import java.util.*;
import APP_GESTION_GROUPE.Collecte_Donnees.*;
import APP_GESTION_GROUPE.Moteur_Repartition.*;

public class Etudiant extends Utilisateur {

	private Collection<Reponse_Sondage> sesReponses;
	private Participation_Covoiturage saParticipationCov;
	private Collection<Choix_Activite> sesChoixActivites;
	private Collection<Note> sesNotes;
	private Collection<Groupe_Etudiant> sesGroupeEtudiants;
	private Promotion saPromotion;
	private int num_etu;
	private String nom;
	private String prenom;
	private TypeGenre Genre;
	private String mail_univ;
	private Date date_naissance;
	private TypeBac type_bac;
	private boolean redoublant;
	private String adresse;
	private String telephone;
	private boolean apprentissage;

	public int getNum_etu() {
		return this.num_etu;
	}

	public void setNum_etu(int num_etu) {
		this.num_etu = num_etu;
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

	public TypeGenre getGenre() {
		return this.Genre;
	}

	public void setGenre(TypeGenre Genre) {
		this.Genre = Genre;
	}

	public String getMail_univ() {
		return this.mail_univ;
	}

	public void setMail_univ(String mail_univ) {
		this.mail_univ = mail_univ;
	}

	public Date getDate_naissance() {
		return this.date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public TypeBac getType_bac() {
		return this.type_bac;
	}

	public void setType_bac(TypeBac type_bac) {
		this.type_bac = type_bac;
	}

	public boolean isRedoublant() {
		return this.redoublant;
	}

	public void setRedoublant(boolean redoublant) {
		this.redoublant = redoublant;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public boolean isApprentissage() {
		return this.apprentissage;
	}

	public void setApprentissage(boolean apprentissage) {
		this.apprentissage = apprentissage;
	}

	public List<Groupe> consulterGroupes() {
		// TODO - implement Etudiant.consulterGroupes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param s
	 * @param val_rep
	 * @param ordre
	 */
	public void repondreSondage(Sondage s, String val_rep, int ordre) {
		// TODO - implement Etudiant.repondreSondage
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param a
	 */
	public void choisirActivite(Activite a) {
		// TODO - implement Etudiant.choisirActivite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 * @param role_part
	 */
	public void rejoindreCovoiturage(Covoiturage c, String role_part) {
		// TODO - implement Etudiant.rejoindreCovoiturage
		throw new UnsupportedOperationException();
	}

}